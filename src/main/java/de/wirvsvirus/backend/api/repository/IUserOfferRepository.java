package de.wirvsvirus.backend.api.repository;

import de.wirvsvirus.backend.api.model.entity.UserOffer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserOfferRepository extends CrudRepository<UserOffer, Long> {

}
