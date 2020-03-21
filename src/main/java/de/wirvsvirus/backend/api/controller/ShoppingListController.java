package de.wirvsvirus.backend.api.controller;


import de.wirvsvirus.backend.api.model.entity.ShoppingList;
import de.wirvsvirus.backend.api.model.entity.UserCoordinate;
import de.wirvsvirus.backend.api.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shoppingList")
@RequiredArgsConstructor
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @GetMapping("/{distance}")
    public List<ShoppingList> getNearShoppingLists(@RequestBody UserCoordinate userCoordinate, @PathVariable Long distance) {
        return shoppingListService.getShoppingListInRange(userCoordinate, distance);
    }
}
