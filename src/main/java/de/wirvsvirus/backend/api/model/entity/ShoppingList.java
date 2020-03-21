package de.wirvsvirus.backend.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@Getter @Setter
public class ShoppingList {
    @Id
    private Long id;

    @Column(nullable = false)
    @ElementCollection
    private List<String> shoppingCart;

}
