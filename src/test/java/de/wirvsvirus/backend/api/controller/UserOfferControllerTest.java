package de.wirvsvirus.backend.api.controller;

import de.wirvsvirus.backend.api.model.OfferStatus;
import de.wirvsvirus.backend.api.model.entity.UserCoordinate;
import de.wirvsvirus.backend.api.model.entity.UserOffer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOfferControllerTest {

    private static String API_ROOT = "http://localhost:8080/api/v1/offers";

    private UserOffer createRandomOffer() {
        Random random = new Random();
        UserCoordinate coordinate = new UserCoordinate(random.nextLong(),
                                                       random.nextLong(),
                                                       random.nextLong());
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add(RandomStringUtils.randomAlphabetic(10));
        shoppingList.add(RandomStringUtils.randomAlphabetic(5));
        shoppingList.add(RandomStringUtils.randomAlphabetic(20));
        UserOffer offer = new UserOffer(random.nextLong(),
                                        random.toString(),
                                        random.nextLong(),
                                        coordinate,
                                        OfferStatus.UNCLAIMED,
                                        shoppingList);
        return offer;
    }

    public String createOfferAsURI(UserOffer offer){
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(offer)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    public void whenGetAllOffers_thenOk(){
        Response response = RestAssured.get(API_ROOT);
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetOfferById_thenOK() {
        UserOffer offer = createRandomOffer();
        String location = createOfferAsURI(offer);
        Response response = RestAssured.get(location);

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetBookByIdNotExists_thenNotFound() {
        Response response = RestAssured.get(API_ROOT + "/" + RandomStringUtils.randomNumeric(5));
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    @Test
    public void whenCreateNewOffer_thenOk() {
        UserOffer offer = createRandomOffer();
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(offer)
                .post(API_ROOT);
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void findAll() {
    }
}
