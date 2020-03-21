package de.wirvsvirus.backend.api.controller;

import de.wirvsvirus.backend.api.exception.OfferNotFoundException;
import de.wirvsvirus.backend.api.model.entity.UserOffer;
import de.wirvsvirus.backend.api.repository.IUserOfferRepository;
import de.wirvsvirus.backend.api.service.UserOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@RequiredArgsConstructor
public class UserOfferController {

    private final IUserOfferRepository offerRepository;
    private final UserOfferService userOfferService;

    @GetMapping
    public Iterable findAll() {
        return offerRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserOffer findOfferById(@PathVariable Long id){
        return offerRepository.findById(id)
                .orElseThrow(OfferNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserOffer createUserOffer(@RequestBody UserOffer offer){
        return offerRepository.save(offer);
    }

    @GetMapping("/status/{id}")
    public boolean isOfferClaimed(@PathVariable Long id) {
        return userOfferService.isOfferClaimed(id);
    }

}
