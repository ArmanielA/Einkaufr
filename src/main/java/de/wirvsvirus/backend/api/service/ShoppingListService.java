package de.wirvsvirus.backend.api.service;

import de.wirvsvirus.backend.api.model.OfferStatus;
import de.wirvsvirus.backend.api.model.entity.ShoppingList;
import de.wirvsvirus.backend.api.model.entity.UserCoordinate;
import de.wirvsvirus.backend.api.model.entity.UserOffer;
import de.wirvsvirus.backend.api.repository.IUserOfferRepository;
import de.wirvsvirus.backend.api.repository.ShoppingListRepository;
import de.wirvsvirus.backend.api.util.Distance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ShoppingListService {

    private final IUserOfferRepository userOfferRepository;
    private final ShoppingListRepository shoppingListRepository;

    /**
     * check, witch shoppingLists are in range of helping person
     * @param userCoordinate position of helping person
     * @param distance radius in kilometer, in which helping person can help
     * @return List of offers in range
     */
    public List<ShoppingList> getShoppingListInRange(UserCoordinate userCoordinate, Long distance) {
        List<ShoppingList> nearShoppingList = new LinkedList<>();
        userOfferRepository.findAll().forEach( userOffer -> {
            if (Distance.isInRange(userOffer, userCoordinate, distance)) {
                nearShoppingList.add(userOffer.getShoppingList());
            }
        });
        return nearShoppingList;
    }

    /**
     * Add a new shoppingList of a person in quarantine
     * @param shoppingList the list
     */
    public void setShoppingList(ShoppingList shoppingList) {
        shoppingListRepository.save(shoppingList);
    }

    /**
     *
     * @param offerId id of person in quarantine
     * @return his shoppingList
     */
    public ShoppingList getShoppingList(Long offerId) {
        return shoppingListRepository.getOne(offerId);
    }
}
