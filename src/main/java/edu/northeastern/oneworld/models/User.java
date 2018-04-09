package edu.northeastern.oneworld.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * User Representation
 *
 */
@Entity
public class User extends Person implements Serializable{
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy = "user")
	private List<Like> likes;
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
	@OneToMany(mappedBy = "user")
	private List<Trip> trips;
	private Boolean isVerified;
	private static final long serialVersionUID = 1L;

	public User(int id, List<Like> likes, List<Review> reviews, List<Trip> trips, Boolean isVerified) {
		super();
		this.id = id;
		this.likes = likes;
		this.reviews = reviews;
		this.trips = trips;
		this.isVerified = isVerified;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", likes=" + likes + ", reviews=" + reviews + ", trips=" + trips + ", isVerified="
				+ isVerified + "]";
	}

}
