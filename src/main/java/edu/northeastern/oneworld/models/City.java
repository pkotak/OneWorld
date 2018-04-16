package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * City Representation
 *
 */
@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JsonIgnore
	private Country country;
	@ManyToOne
	@JsonIgnore
	private State state;
	private String name;
	@ManyToMany
	@JoinTable(name = "TRIPS_CITY", joinColumns = @JoinColumn(name = "CITY_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "TRIP_ID", referencedColumnName = "ID"))
	@JsonIgnore
	private List<Trip> tripsInCity;

	public City() {
		super();
	}

	public City(int id, Country country, State state, String name,
			List<Trip> tripsInCity) {
		super();
		this.id = id;
		this.country = country;
		this.state = state;
		this.name = name;
		this.tripsInCity = tripsInCity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Trip> getTripsInCity() {
		return tripsInCity;
	}

	public void setTripsInCity(List<Trip> tripsInCity) {
		this.tripsInCity = tripsInCity;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", country=" + country + ", state=" + state + ", name=" + name + ", tripsInCity=" + tripsInCity + "]";
	}

}
