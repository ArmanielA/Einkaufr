package de.wirvsvirus.backend.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class UserCoordinate{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long longitude;

    private long latitude;

}
