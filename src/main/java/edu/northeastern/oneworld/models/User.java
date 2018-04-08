package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User Representation
 *
 */
public class User extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private List<Like> likes;
	private List<Review> reviews;
	private Boolean isVerified;

	public User(int id, List<Like> likes, List<Review> reviews, Boolean isVerified) {
		super();
		this.id = id;
		this.likes = likes;
		this.reviews = reviews;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", likes=" + likes + ", reviews=" + reviews + ", isVerified=" + isVerified + "]";
	}

}
