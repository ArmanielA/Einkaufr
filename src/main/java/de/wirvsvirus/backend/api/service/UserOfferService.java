package de.wirvsvirus.backend.api.service;

import de.wirvsvirus.backend.api.model.OfferStatus;
import de.wirvsvirus.backend.api.model.entity.UserOffer;
import de.wirvsvirus.backend.api.repository.IUserOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserOfferService {

    private final IUserOfferRepository userOfferRepository;

    /**
     *
     * @param offerId id of person in quarantine
     * @return true, if offer is claimed
     */
    public boolean isOfferClaimed(Long offerId) {
        Optional<UserOffer> userOffer = userOfferRepository.findById(offerId);
        return userOffer.map(offer -> offer.getOfferStatus().equals(OfferStatus.CLAIMED)).orElse(false);
    }
}
