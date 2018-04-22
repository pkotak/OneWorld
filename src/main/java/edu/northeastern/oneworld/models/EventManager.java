package edu.northeastern.oneworld.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class EventManager extends Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "eventManager")
    private List<Trip> trips;
    private static final long serialVersionUID = 1L;

    public EventManager(List<Trip> trips) {
        super();
        this.trips = trips;
    }

    public EventManager(int id, String firstName, String lastName, String phoneNumber, String address, String email, String username, String password, String dob, Boolean isAdmin, List<Trip> trips) {
        super(id, firstName, lastName, phoneNumber, address, email, username, password, dob, isAdmin);
        this.trips = trips;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "EventManager{" +
                "id=" + id +
                ", trips=" + trips +
                '}';
    }
}
