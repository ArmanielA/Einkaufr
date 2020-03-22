package de.wirvsvirus.backend.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class ChatText {
    @Column
    private Long id;
    @Column
    private boolean sendFromHelper;
    @Column
    private LocalDateTime sendDate;
    @Column
    private String chatText;
}
