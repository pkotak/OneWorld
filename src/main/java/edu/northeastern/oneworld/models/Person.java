package edu.northeastern.oneworld.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 * Person Representation
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String dType;
	private String address;
	private String email;
	private String username;
	private String password;
	private Date dob;
	private Boolean isAdmin;

	/**
	 * Empty Contructor
	 */
	public Person() {
		super();
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param dType
	 * @param address
	 * @param email
	 * @param username
	 * @param password
	 * @param dob
	 * @param isAdmin
	 */
	public Person(int id, String firstName, String lastName, String phoneNumber, String dType, String address,
			String email, String username, String password, Date dob, Boolean isAdmin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.dType = dType;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.isAdmin = isAdmin;
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

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
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

	public void set(Person newPerson) {
		this.username = newPerson.username != null ? newPerson.username : this.username;
		this.password = newPerson.password != null ? newPerson.password : this.password;
		this.firstName = newPerson.firstName != null ? newPerson.firstName : this.firstName;
		this.lastName = newPerson.lastName != null ? newPerson.lastName : this.lastName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", dType=" + dType + ", address=" + address + ", email=" + email + ", username="
				+ username + ", password=" + password + ", dob=" + dob + ", isAdmin=" + isAdmin + "]";
	}

}
