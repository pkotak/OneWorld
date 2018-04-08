package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Country Representation 
 *
 */
@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy = "country")
	@JsonIgnore
	private List<State> states;
	@ManyToMany
	@JoinTable(name = "TRIPS_COUNTRY", joinColumns = @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "TRIP_ID", referencedColumnName = "ID"))
	@JsonIgnore
	private List<Trip> tripsInCountry;

	public Country(int id, List<State> states, List<Trip> tripsInCountry) {
		super();
		this.id = id;
		this.states = states;
		this.tripsInCountry = tripsInCountry;
	}

	public Country() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public List<Trip> getTripsInCountry() {
		return tripsInCountry;
	}

	public void setTripsInCountry(List<Trip> tripsInCountry) {
		this.tripsInCountry = tripsInCountry;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", states=" + states + ", tripsInCountry=" + tripsInCountry + "]";
	}

}
