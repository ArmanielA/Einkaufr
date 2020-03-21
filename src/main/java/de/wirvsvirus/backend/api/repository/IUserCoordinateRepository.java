package de.wirvsvirus.backend.api.repository;

import de.wirvsvirus.backend.api.model.entity.UserCoordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserCoordinateRepository extends JpaRepository<UserCoordinate, Long> {
}
