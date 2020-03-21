package de.wirvsvirus.backend.api.model.entity;

import de.wirvsvirus.backend.api.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
public class UserOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private UserType userType;

    @Column(nullable = false)
    private long timestamp;

    @Column(nullable = false)
    private Double perimeter;

    @Column(nullable = false)
    @OneToOne
    private UserCoordinate userCoordinate;

}
