package de.wirvsvirus.backend.api.service;

import de.wirvsvirus.backend.api.model.ShoppingList;
import de.wirvsvirus.backend.api.model.UserCoordinate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;


@Service
@Transactional
// @RequiredArgsConstructor
public class ShoppingListService {

    /**
     * check, witch shoppingLists are in range of helping person
     * @param userCoordinate geolocation of helping person
     * @param distance radius in kilometer, in which helping person can help
     * @return List of offers in range
     */
    public List<ShoppingList> getShoppingListInRange(UserCoordinate userCoordinate, Long distance) {
        return new LinkedList<>();
    }

    /**
     * Add a new shoppingList of a person in quarantine
     * @param shoppingList the list
     */
    public void setShoppingList(ShoppingList shoppingList) {
    }

    /**
     *
     * @param offerId id of person in quarantine
     * @return his shoppingList
     */
    public ShoppingList getShoppingList(Long offerId) {
        return new ShoppingList();
    }

    /**
     *
     * @param offerId id of person in quarantine
     * @return true, if offer is taken
     */
    public boolean isOfferTaken(Long offerId) {
        return false;
    }
}
