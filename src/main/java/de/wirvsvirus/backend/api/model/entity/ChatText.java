package de.wirvsvirus.backend.api.model.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ChatText {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private boolean sendFromHelper;
    @Column
    private LocalDateTime sendDate;
    @Column
    private String chatText;
}
