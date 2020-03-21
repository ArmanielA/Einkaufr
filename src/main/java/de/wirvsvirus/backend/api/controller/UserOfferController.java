package de.wirvsvirus.backend.api.controller;

import de.wirvsvirus.backend.api.exception.OfferNotFoundException;
import de.wirvsvirus.backend.api.model.entity.UserOffer;
import de.wirvsvirus.backend.api.repository.IUserOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
public class UserOfferController {
    @Autowired
    private IUserOfferRepository offerRepository;

    @GetMapping
    public Iterable findall() {
        return offerRepository.findAll();
    }

    @GetMapping("/perimeter/{perimeter}")
    public List findByPerimeter(@PathVariable Double perimeter) {
        return offerRepository.findUserOfferByPerimeter(perimeter);
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

}
