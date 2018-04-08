package edu.northeastern.oneworld.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Event representation
 *
 */
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JsonIgnore
	private Trip trip;
	private int numberOfDays;
	@ManyToOne
	private Destination destination;

	public Event() {
		super();
	}

	public Event(int id, Trip trip, int numberOfDays) {
		super();
		this.id = id;
		this.trip = trip;
		this.numberOfDays = numberOfDays;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", trip=" + trip + ", numberOfDays=" + numberOfDays + "]";
	}

}
