package edu.northeastern.oneworld.services;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.Destination;
import edu.northeastern.oneworld.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DestinationService {

    @Autowired
    DestinationRepository destinationRepository;

    @PostMapping("/api/destination")
    public Destination saveDestination(@RequestBody String json){
        Gson g = new Gson();
        Destination destination = g.fromJson(json, Destination.class);
        return destinationRepository.save(destination);
    }

    @GetMapping("/api/destination/{dId}")
    public Optional<Destination> findDestinationById(@PathVariable("dId") String id){
        return destinationRepository.findDestinationById(id);
    }

    @GetMapping("/api/destination/{name}")
    public Optional<Destination> findDestinationByName(@PathVariable("name") String name){
        return destinationRepository.findDestinationByName(name);
    }

    @GetMapping("/api/destination/{rating}")
    public List<Destination> findDestinationByRating(@PathVariable("rating") int rating){
        return destinationRepository.findDestinationByRating(rating);
    }
}
