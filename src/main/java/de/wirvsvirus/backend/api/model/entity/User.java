package de.wirvsvirus.backend.api.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class User {

    private Long id;
    private List<UserOffer> userOffers;
    private int reliability;

}
