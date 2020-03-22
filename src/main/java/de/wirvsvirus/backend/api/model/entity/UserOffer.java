package de.wirvsvirus.backend.api.model.entity;

import de.wirvsvirus.backend.api.model.OfferStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column
	private String owner;

	@Column
	private String helper;

    @Column
    private String title;

    @Column(nullable = false)
    private long timestamp;

    @OneToOne
    private UserCoordinate userCoordinate;

    @Column(nullable = false)
    private OfferStatus offerStatus;
    
    @Column(nullable = false)
    @ElementCollection
    private List<String> shoppingCart;

    @OneToMany
    private List<ChatText> chatTexts;

}
