package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Trip representation
 *
 */
@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Person person;
	private int tripDuration;
	@OneToMany(mappedBy = "trip")
	@JsonIgnore
	private List<Event> events;
	@ManyToMany(mappedBy = "tripsInCountry")
	@JsonIgnore
	private List<Country> countries;
	@ManyToMany(mappedBy = "tripsInCity")
	private List<City> cities;
	@ManyToMany(mappedBy = "tripsInState")
	private List<State> states;

	public Trip() {
		super();
	}

	
	public Trip(int id, Person person, int tripDuration, List<Event> events, List<Country> countries, List<City> cities,
			List<State> states) {
		super();
		this.id = id;
		this.person = person;
		this.tripDuration = tripDuration;
		this.events = events;
		this.countries = countries;
		this.cities = cities;
		this.states = states;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(int tripDuration) {
		this.tripDuration = tripDuration;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", person=" + person + ", tripDuration=" + tripDuration + ", events=" + events
				+ ", countries=" + countries + ", cities=" + cities + ", states=" + states + "]";
	}

}
