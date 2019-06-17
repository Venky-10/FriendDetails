package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String street;
	private String city;
//	@ManyToOne 
//	private Friend friend;
//	@ManyToMany
	private Set<Friend> friend;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Friend getFriend() {
//		return friend;
//	}
//	public void setFriend(Friend friend) {
//		this.friend = friend;
//	}

	public Set<Friend> getFriend() {
		return friend;
	}

	public void setFriend(Set<Friend> friend) {
		this.friend = friend;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
