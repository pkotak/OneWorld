package edu.northeastern.oneworld.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Owner Representation
 *
 */
@Entity
public class Owner extends Person implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String placeId;
	private String placeType;
	private static final long serialVersionUID = 1L;

	public Owner() {
		super();
	}

	public Owner(int id, String placeId, String placeType) {
		super();
		this.id = id;
		this.placeId = placeId;
		this.placeType = placeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", placeId=" + placeId + ", placeType=" + placeType + "]";
	}

}
