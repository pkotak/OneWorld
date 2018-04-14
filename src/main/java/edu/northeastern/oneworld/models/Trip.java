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
    @ManyToOne()
    private User user;
    private Integer tripDuration;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Destination> destinations;
    @ManyToMany(mappedBy = "tripsInCountry", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Country> countries;
    @ManyToMany(mappedBy = "tripsInCity", cascade = CascadeType.ALL)
    private List<City> cities;
    @ManyToMany(mappedBy = "tripsInState", cascade = CascadeType.ALL)
    private List<State> states;

    public Trip() {
        super();
    }


    public Trip(User user, Integer tripDuration, List<Destination> destinations, List<Country> countries, List<City> cities, List<State> states) {
        this.user = user;
        this.tripDuration = tripDuration;
        this.destinations = destinations;
        this.countries = countries;
        this.cities = cities;
        this.states = states;
    }

    public List<Country> getCountries() {
        return countries;
    }


    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }


    public List<City> getCities() {
        return cities;
    }


    public void setCities(List<City> cities) {
        this.cities = cities;
    }


    public List<State> getStates() {
        return states;
    }


    public void setStates(List<State> states) {
        this.states = states;
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

    public void set(Trip newTrip) {
        this.setDestinations(newTrip.getDestinations() != null ? newTrip.getDestinations() : this.getDestinations());
        this.setTripDuration(newTrip.getTripDuration() != null ? newTrip.getTripDuration() : this.getTripDuration());
        this.setUser(newTrip.getUser() != null ? newTrip.getUser() : this.getUser());
        this.setCountries(newTrip.getCountries() != null ? newTrip.getCountries() : this.getCountries());
        this.setCities(newTrip.getCities() != null ? newTrip.getCities() : this.getCities());
        this.setStates(newTrip.getStates() != null ? newTrip.getStates() : this.getStates());
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", user=" + user +
                ", tripDuration=" + tripDuration +
                ", destinations=" + destinations +
                ", countries=" + countries +
                ", cities=" + cities +
                ", states=" + states +
                '}';
    }

}
