package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@JsonProperty
	@NotBlank
	private String firstName;
	@JsonProperty
	@NotBlank
	private String lastName;
	@NotBlank
	int age;
	@OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
	Set<Address> addresses;

	public Set<Address> getAddress() {
		return addresses;
	}

	public void setAddress(Set<Address> address) {
		this.addresses = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
}
