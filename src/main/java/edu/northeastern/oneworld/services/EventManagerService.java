package edu.northeastern.oneworld.services;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.EventManager;
import edu.northeastern.oneworld.models.Trip;
import edu.northeastern.oneworld.repositories.EventManagerRepository;
import edu.northeastern.oneworld.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})
public class EventManagerService {

    @Autowired
    EventManagerRepository eventManagerRepository;

    @Autowired
    TripRepository tripRepository;

    /**
     * Method to create a new event manager
     * @param json event manager object
     * @return event manager
     */
    @PostMapping("/api/eventmanager")
    public EventManager createEventManager(@RequestBody String json) {
        Gson g = new Gson();
        EventManager eventManager = g.fromJson(json, EventManager.class);
        return eventManagerRepository.save(eventManager);
    }

    /**
     * Method to find an event manager
     * @param id event manager id
     * @return event manager
     */
    @GetMapping("/api/eventmanager/{eId}")
    public Optional<EventManager> findEventManagerById(@PathVariable("eId") int id) {
        return eventManagerRepository.findById(id);
    }

    /**
     * Method to find an event manager for a trip
     * @param id trip id
     * @return event manager
     */
    @GetMapping("/api/trip/{tid}/eventmanager")
    public EventManager findUserById(@PathVariable("tid") int id) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        if(optionalTrip.isPresent()){
            Trip trip = optionalTrip.get();
            return trip.getEventManager();
        }
        return null;
    }

    /**
     * Method to find an event manager for a trip
     * @param id trip id
     * @return event manager
     */
    @GetMapping("/api/eventmanager/{eid}/trip")
    public Iterable<Trip> findTripsForEventManager(@PathVariable("eid") int id) {
        Optional<EventManager> optionalEventManager = eventManagerRepository.findById(id);
        if(optionalEventManager.isPresent()){
            EventManager eventManager = optionalEventManager.get();
            return eventManager.getTrips();
        }
        return null;
    }

    /**
     * Method to update an event manager for a trip
     * @param id trip id
     * @return event manager
     */
    @PutMapping("/api/eventmanager/{eId}")
    public EventManager updateEventManager(@PathVariable("eId") int id, @RequestBody EventManager neweventmanager) {
        Optional<EventManager> optionalEventManager = eventManagerRepository.findById(id);
        if (optionalEventManager.isPresent()) {
            EventManager eventManager = optionalEventManager.get();
//			owner.set(newowner);
            return eventManagerRepository.save(eventManager);
        } else
            return null;

    }

    /**
     * Method to delete an event manager for a trip
     * @param id event manager id
     */
    @DeleteMapping("/api/eventmanager/{eId}")
    public void deleteEventManager(@PathVariable("eId") int id) {
        eventManagerRepository.deleteById(id);
    }
}
