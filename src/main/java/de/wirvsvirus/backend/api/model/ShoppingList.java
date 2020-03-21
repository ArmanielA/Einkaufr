package de.wirvsvirus.backend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class ShoppingList {
    @Id
    private Long id;

    @Column(nullable = false)
    @ElementCollection
    private List<String> shoppingCart;

}
