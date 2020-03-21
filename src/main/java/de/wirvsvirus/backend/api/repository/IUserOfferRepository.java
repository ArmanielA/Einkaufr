package de.wirvsvirus.backend.api.repository;

import de.wirvsvirus.backend.api.model.entity.UserOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserOfferRepository extends JpaRepository<UserOffer, Long> {

}
