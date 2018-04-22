package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Trip representation
 */
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JsonIgnore
    private User user;
    @ManyToOne
    @JsonIgnore
    private EventManager eventManager;
    private String date;
    @ManyToMany(mappedBy = "trips", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Destination> destinations;

    public Trip() {
        super();
    }

    public Trip(String name, User user, EventManager eventManager, String date, List<Destination> destinations) {
        this.name = name;
        this.user = user;
        this.eventManager = eventManager;
        this.date = date;
        this.destinations = destinations;
    }

    public void setTripDuration(Integer tripDuration) {
        this.date = date;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void set(Trip newTrip) {
        this.setDestinations(newTrip.getDestinations() != null ? newTrip.getDestinations() : this.getDestinations());
        this.setDate(newTrip.getDate() != null ? newTrip.getDate() : this.getDate());
        this.setUser(newTrip.getUser() != null ? newTrip.getUser() : this.getUser());
        this.setName(newTrip.getName() != null ? newTrip.getName() : this.getName());
        this.setEventManager(newTrip.getEventManager() != null ? newTrip.getEventManager() : this.getEventManager());
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", eventManager=" + eventManager +
                ", date='" + date + '\'' +
                ", destinations=" + destinations +
                '}';
    }
}
