package de.wirvsvirus.backend.api.controller;

import de.wirvsvirus.backend.api.exception.OfferNotFoundException;
import de.wirvsvirus.backend.api.model.entity.UserCoordinate;
import de.wirvsvirus.backend.api.model.entity.UserOffer;
import de.wirvsvirus.backend.api.repository.IUserOfferRepository;
import de.wirvsvirus.backend.api.service.UserOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    @GetMapping("/own")
    @Transactional
    public List<UserOffer> getOffersByUUID(@RequestParam String uuid){
    	return userOfferService.getOffersByUUID(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserOffer createUserOffer(@RequestBody UserOffer offer){
        return userOfferService.save(offer);
    }

    @GetMapping("/status/{id}")
    public boolean isOfferClaimed(@PathVariable Long id) {
        return userOfferService.isOfferClaimed(id);
    }

    @PutMapping("take/{id}")
    public void takeOffer(@PathVariable Long id) {
        userOfferService.takeOffer(id);
    }

    @GetMapping("findWithinRange")
    public List<UserOffer> getOffersInRange(@RequestParam Long lat, @RequestParam Long lon, @RequestParam Long distance){
            return userOfferService.getUserOffersInRange(new UserCoordinate(0L, lon, lat), distance);
    }

}
