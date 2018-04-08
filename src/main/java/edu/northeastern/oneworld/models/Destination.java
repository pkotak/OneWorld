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
 * Destination Representation
 *
 */
@Entity
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JsonIgnore
	private City city;
	private int priceRange;
	private int rating;
	private int phoneNumber;
	private String address;
	private String name;
	private String timings;
	private String websiteLink;
	private double latitude;
	private double longitude;
	private String destinationType;
	@OneToMany
	@JsonIgnore
	private List<Event> events;

	public Destination(int id, City city, int priceRange, int rating, int phoneNumber, String address, String name,
			String timings, String websiteLink, double latitude, double longitude, String destinationType,
			List<Event> events) {
		super();
		this.id = id;
		this.city = city;
		this.priceRange = priceRange;
		this.rating = rating;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.name = name;
		this.timings = timings;
		this.websiteLink = websiteLink;
		this.latitude = latitude;
		this.longitude = longitude;
		this.destinationType = destinationType;
		this.events = events;
	}

	public Destination() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(int priceRange) {
		this.priceRange = priceRange;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(String destinationType) {
		this.destinationType = destinationType;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", city=" + city + ", priceRange=" + priceRange + ", rating=" + rating
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", name=" + name + ", timings=" + timings
				+ ", websiteLink=" + websiteLink + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", destinationType=" + destinationType + "]";
	}

}
