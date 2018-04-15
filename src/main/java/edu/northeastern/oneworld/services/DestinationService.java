package edu.northeastern.oneworld.services;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.Destination;
import edu.northeastern.oneworld.models.Review;
import edu.northeastern.oneworld.models.Trip;
import edu.northeastern.oneworld.repositories.DestinationRepository;
import edu.northeastern.oneworld.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DestinationService {

    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    TripRepository tripRepository;

    @PostMapping("/api/destination")
    public Destination saveDestination(@RequestBody String json){
        Gson g = new Gson();
        Destination destination = g.fromJson(json, Destination.class);
        return destinationRepository.save(destination);
    }

    @PostMapping("/api/destination/{dId}/trip/{tripId}")
    public void addDestinationToTrip(@PathVariable("dId") int dId,
                                     @PathVariable("tripId") int tripId){
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        Optional<Destination> optionalDestination = destinationRepository.findById(dId);
        if (optionalTrip.isPresent() && optionalDestination.isPresent()){
            Trip t = optionalTrip.get();
            Destination d = optionalDestination.get();
            d.addToTrip(t);
            destinationRepository.save(d);
        }
    }

    @GetMapping("/api/destination/{dId}")
    public Optional<Destination> findDestinationById(@PathVariable("dId") String id){
        return destinationRepository.findDestinationById(id);
    }

    @GetMapping("/api/destination/{dId}/review")
    public Iterable<Review> getReviewsForDestination(@PathVariable("dId") String id){
        Optional<Destination> optionalDestination = destinationRepository.findDestinationById(id);
        if(optionalDestination.isPresent()){
            Destination d = optionalDestination.get();
            return d.getReviews();
        }
        return null;
    }
}
