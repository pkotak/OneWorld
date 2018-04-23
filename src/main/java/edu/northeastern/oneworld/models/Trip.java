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
    @ManyToMany(mappedBy = "trips")
    @JsonIgnore
    private List<User> users;
    @ManyToOne
    @JsonIgnore
    private EventManager eventManager;
    private String date;
    @ManyToOne
    @JsonIgnore
    private Destination destination;

    public Trip() {
        super();
    }

    public Trip(String name, List<User> users, EventManager eventManager, String date, Destination destination) {
        this.name = name;
        this.users = users;
        this.eventManager = eventManager;
        this.date = date;
        this.destination = destination;
    }

    public void setTripDuration(Integer tripDuration) {
        this.date = date;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUser() {
        return users;
    }

    public void setUser(List<User> user) {
        this.users = user;
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
        if(!eventManager.getTrips().contains(this))
            eventManager.getTrips().add(this);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void set(Trip newTrip) {
        this.setDestination(newTrip.getDestination() != null ? newTrip.getDestination() : this.getDestination());
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
                ", user=" + users +
                ", eventManager=" + eventManager +
                ", date='" + date + '\'' +
                ", destinations=" + destination +
                '}';
    }
}
