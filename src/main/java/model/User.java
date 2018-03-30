package model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
	@Id
	@Column(name = "CNP", unique = true, nullable = false)
	private String cnp;

	@Column(name = "firstname", nullable = true, length = 30)
	private String firstName;

	@Column(name = "lastname", nullable = true, length = 30)
	private String lastName;

	@Column(name = "username", unique = false, nullable = true)
	private String username;

	@Column(name = "cardnumber", unique = false, nullable = true)
	private String cardNumber;

	@Column(name = "password", nullable = true)
	private String password;

	@Column(name = "email", unique = false, nullable = true)
	private String email;

	@Column(name = "type", nullable = true)
	private String type;
	@Column(name = "country", nullable = true)
	private String country;

	@Column(name = "county", nullable = true)
	private String county;

	@Column(name = "city", nullable = true)
	private String city;

	@Column(name = "street", nullable = true)
	private String street;

	@Column(name = "streetnumber", nullable = true)
	private String streetNumber;

	public User(String cnp, String firstName, String lastName, String username, String cardNumber,
			String password, String email, String type) {
		super();
		this.cnp = cnp;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.cardNumber = cardNumber;
		this.password = password;
		this.email = email;
		this.type = type;
	}

	public User() {
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	@Override
	public String toString() {
		return username;
	}
}
