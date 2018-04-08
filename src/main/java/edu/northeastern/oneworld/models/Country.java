package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	public Country(int id, List<State> states) {
		super();
		this.id = id;
		this.states = states;
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



	@Override
	public String toString() {
		return "Country [id=" + id + ", states=" + states + "]";
	}

	
}
