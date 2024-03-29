package com.nagarro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	@NotNull(message = "Required")
	@Size(min = 2, message = "Must Be Minmum Of 2 Character")
	@Pattern(regexp = "^[^\\d]+$", message = "Enter Valid First Name")
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull(message = "Required")
	@Size(min = 2, message = "Must Be Minmum Of 2 Character")
	@Pattern(regexp = "^[^\\d]+$", message = "Enter Valid Last Name")
	private String lastName;
	
	@Column(name = "email")
	@NotNull(message = "Required")
	@Pattern(regexp = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", message = "Must Be Valid Email")
	private String email;
	
	// default Constructor
	
	public Customer() {
		
	}
	
	// getter/setter Methods

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName +", lastName=" + lastName + ", email=" + email;
	}

}
