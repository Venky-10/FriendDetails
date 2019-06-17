package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Friend;
import com.example.demo.service.FriendService;

@RestController
public class FriendController {

	@Autowired
	FriendService friendService;

	@PostMapping("/friend")
	Friend create(@Valid @RequestBody Friend friend) {
		return friendService.save(friend);
	}

	@GetMapping("/friend")
	Iterable<Friend> read(@RequestBody Friend friend) {
		return friendService.findAll();
	}

	@PutMapping("/friend")
	ResponseEntity<Friend> update(@RequestBody Friend friend) {
		if (friendService.findById(friend.getId()).isPresent()) {
			return new ResponseEntity(friendService.save(friend), HttpStatus.OK);
		} else {
			return new ResponseEntity(friend, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/friend/{id}")
	void delete(@PathVariable("id") Integer Id) {
		friendService.deleteById(Id);
	}

	@GetMapping("/friend/{id}")
	Optional<Friend> findById(@PathVariable("id") Integer Id) {
		return friendService.findById(Id);
	}

	@GetMapping("/friend/search")
	Iterable<Friend> findAll(@RequestParam(value = "first", required = false) String firstName,
			@RequestParam(value = "last", required = false) String lastName) {
		if (firstName != null && lastName != null) {
			return friendService.findByFirstNameAndLastName(firstName, lastName);
		} else if (firstName != null) {
			return friendService.findByFirstName(firstName);
		} else if (lastName != null) {
			return friendService.findByLastName(lastName);
		} else
			return friendService.findAll();
	}
}
