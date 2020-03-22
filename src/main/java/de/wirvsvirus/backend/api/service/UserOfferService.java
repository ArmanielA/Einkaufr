package de.wirvsvirus.backend.api.service;

import de.wirvsvirus.backend.api.model.OfferStatus;
import de.wirvsvirus.backend.api.model.entity.ChatText;
import de.wirvsvirus.backend.api.model.entity.UserCoordinate;
import de.wirvsvirus.backend.api.model.entity.UserOffer;
import de.wirvsvirus.backend.api.repository.IUserCoordinateRepository;
import de.wirvsvirus.backend.api.repository.IUserOfferRepository;
import de.wirvsvirus.backend.api.repository.IUserChatTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static de.wirvsvirus.backend.api.util.Distance.isInRange;
import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor
public class UserOfferService {

    private final IUserOfferRepository userOfferRepository;
    private final IUserCoordinateRepository userCoordinateRepository;
    private final IUserChatTextRepository userChatTextRepository;

    /**
     *
     * @param offerId id of person in quarantine
     * @return true, if offer is claimed
     */
    public boolean isOfferClaimed(Long offerId) {
        Optional<UserOffer> userOffer = userOfferRepository.findById(offerId);
        return userOffer.map(offer -> offer.getOfferStatus().equals(OfferStatus.CLAIMED)).orElse(false);
    }

    public void takeOffer(Long offerId) {
        Optional<UserOffer> userOffer = userOfferRepository.findById(offerId);
        if (userOffer.isPresent()) {
            UserOffer changedOffer = userOffer.get();
            changedOffer.setOfferStatus(OfferStatus.CLAIMED);
            userOfferRepository.save(changedOffer);
        }
    }

    /**
     * check, witch shoppingLists are in range of helping person
     * @param userCoordinate position of helping person
     * @param distance radius in kilometer, in which helping person can help
     * @return List of offers in range
     */
    public List<UserOffer> getUserOffersInRange(UserCoordinate userCoordinate, Long distance) {
        return userOfferRepository.findAll()
                .stream()
                .filter(offer -> offer.getOfferStatus() == OfferStatus.UNCLAIMED)
                .filter(userOffer ->
                        isInRange(userOffer, userCoordinate, distance))
                .collect(toList());
    }

    @Transactional
    public UserOffer save(UserOffer offer) {
        offer.setChatTexts(userChatTextRepository.saveAll(offer.getChatTexts()));
        offer.setUserCoordinate(userCoordinateRepository.save(offer.getUserCoordinate()));
        return userOfferRepository.save(offer);
    }

    public List<UserOffer> getOffersByUUID(String uuid) {
        return userOfferRepository.findAll()
                .stream()
                .filter(offer ->
                        offer.getOwner().equals(uuid) || offer.getHelper().equals(uuid))
                .collect(toList());
    }
}
