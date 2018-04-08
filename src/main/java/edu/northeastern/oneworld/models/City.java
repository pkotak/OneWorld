package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@OneToMany
	@JsonIgnore
	private List<Destination> destinations;
	
	public City() {
		super();
	}
	
	@Override
	public String toString() {
		return "City [id=" + id + ", country=" + country + ", state=" + state + ", name=" + name + ", destinations="
				+ destinations + "]";
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
	
	public List<Destination> getDestinations() {
		return destinations;
	}
	
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
	
	public City(int id, Country country, State state, String name, List<Destination> destinations) {
		super();
		this.id = id;
		this.country = country;
		this.state = state;
		this.name = name;
		this.destinations = destinations;
	}
		
}
