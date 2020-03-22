package de.wirvsvirus.backend.api.repository;

import de.wirvsvirus.backend.api.model.entity.ChatText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserChatTextRepository extends JpaRepository<ChatText, Long> {
}
