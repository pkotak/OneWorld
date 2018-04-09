package edu.northeastern.oneworld.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;


/**
 * Review Representation
 *
 */
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne()
	@JsonIgnore
	private User user;
	private int rating;
	private String description;
	private Date dateOfReview;
	private long numberOfLikes;
	@ManyToOne
	@JsonIgnore
	private Destination destination;
	private DestinationType placeType;
	

	
	public Review() {
		super();
	}



	public Review(int id, User user, int rating, String description, Date dateOfReview, long numberOfLikes,
			Destination destination, DestinationType placeType) {
		super();
		this.id = id;
		this.user = user;
		this.rating = rating;
		this.description = description;
		this.dateOfReview = dateOfReview;
		this.numberOfLikes = numberOfLikes;
		this.destination = destination;
		this.placeType = placeType;
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



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDateOfReview() {
		return dateOfReview;
	}



	public void setDateOfReview(Date dateOfReview) {
		this.dateOfReview = dateOfReview;
	}



	public long getNumberOfLikes() {
		return numberOfLikes;
	}



	public void setNumberOfLikes(long numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}



	public Destination getDestination() {
		return destination;
	}



	public void setDestination(Destination destination) {
		this.destination = destination;
	}



	public DestinationType getPlaceType() {
		return placeType;
	}



	public void setPlaceType(DestinationType placeType) {
		this.placeType = placeType;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + ", dateOfReview="
				+ dateOfReview + ", numberOfLikes=" + numberOfLikes + ", destination=" + destination + ", placeType="
				+ placeType + "]";
	}
	
	
}
