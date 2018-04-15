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
    @ManyToOne()
    @JsonIgnore
    private User user;
    private Integer tripDuration;
    @ManyToMany(mappedBy = "trips", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Destination> destinations;
//    @ManyToMany(mappedBy = "tripsInCountry", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Country> countries;
//    @ManyToMany(mappedBy = "tripsInCity", cascade = CascadeType.ALL)
//    private List<City> cities;
//    @ManyToMany(mappedBy = "tripsInState", cascade = CascadeType.ALL)
//    private List<State> states;

    public Trip() {
        super();
    }

    public Trip(String name, User user, Integer tripDuration, List<Destination> destinations, List<Country> countries, List<City> cities, List<State> states) {
        this.name = name;
        this.user = user;
        this.tripDuration = tripDuration;
        this.destinations = destinations;
    }

    public void setTripDuration(Integer tripDuration) {
        this.tripDuration = tripDuration;
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

    public Integer getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(int tripDuration) {
        this.tripDuration = tripDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void set(Trip newTrip) {
        this.setDestinations(newTrip.getDestinations() != null ? newTrip.getDestinations() : this.getDestinations());
        this.setTripDuration(newTrip.getTripDuration() != null ? newTrip.getTripDuration() : this.getTripDuration());
        this.setUser(newTrip.getUser() != null ? newTrip.getUser() : this.getUser());
        this.setName(newTrip.getName() != null ? newTrip.getName() : this.getName());
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", tripDuration=" + tripDuration +
                ", destinations=" + destinations +
                ", countries=" +
                ", cities=" +
                ", states=" +
                '}';
    }

}
