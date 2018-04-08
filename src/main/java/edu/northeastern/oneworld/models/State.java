package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * State Representation
 *
 */
@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JsonIgnore
	private Country country;
	private String name;
	@OneToMany(mappedBy = "state")
	@JsonIgnore
	private List<City> cities;
	
	
	public State() {
		super();
	}
	
	
	public State(int id, Country country, String name, List<City> cities) {
		super();
		this.id = id;
		this.country = country;
		this.name = name;
		this.cities = cities;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<City> getCities() {
		return cities;
	}
	
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	@Override
	public String toString() {
		return "State [id=" + id + ", country=" + country + ", name=" + name + ", cities=" + cities + "]";
	}
	
	
}
