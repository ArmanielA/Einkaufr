package de.wirvsvirus.backend.api.repository;

import de.wirvsvirus.backend.api.model.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
