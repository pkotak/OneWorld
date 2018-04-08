package edu.northeastern.oneworld.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Destinations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JsonIgnore
	private int cityID;
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
	
	
	public Destinations(int id, int cityID, int priceRange, int rating, int phoneNumber, String address, String name,
			String timings, String websiteLink, double latitude, double longitude, String destinationType) {
		super();
		this.id = id;
		this.cityID = cityID;
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
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCityID() {
		return cityID;
	}


	public void setCityID(int cityID) {
		this.cityID = cityID;
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


	@Override
	public String toString() {
		return "Destinations [id=" + id + ", cityID=" + cityID + ", priceRange=" + priceRange + ", rating=" + rating
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", name=" + name + ", timings=" + timings
				+ ", websiteLink=" + websiteLink + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", destinationType=" + destinationType + "]";
	}
	
	
	
}
