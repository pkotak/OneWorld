package edu.northeastern.oneworld.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Person class representation
 * 
 * @author Paarth
 *
 */
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String dType;
	@OneToMany(mappedBy = "person")
	@JsonIgnore
	private List<Address> addresses;
	private String email;
	private String username;
	private String password;
	private Date dob;
	private Boolean isVerified;

	/**
	 * Empty Contructor
	 */
	public Person() {
		super();
	}

	public Person(int id, String firstName, String lastName, String phoneNumber, String dType, List<Address> addresses,
			String email, String username, String password, Date dob, Boolean isVerified) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.dType = dType;
		this.addresses = addresses;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.isVerified = isVerified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public void set(Person newPerson) {
		this.username = newPerson.username != null ? newPerson.username : this.username;
		this.password = newPerson.password != null ? newPerson.password : this.password;
		this.firstName = newPerson.firstName != null ? newPerson.firstName : this.firstName;
		this.lastName = newPerson.lastName != null ? newPerson.lastName : this.lastName;
		this.isVerified = newPerson.isVerified != null ? newPerson.isVerified : this.isVerified;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", dType=" + dType + ", addresses=" + addresses + ", email=" + email + ", username="
				+ username + ", password=" + password + ", dob=" + dob + ", isVerified=" + isVerified + "]";
	}

}
