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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Friend;
import com.example.demo.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/address")
	Address create(@Valid @RequestBody Address address) {
		return addressService.save(address);
	}

	@GetMapping("/address")
	Iterable<Address> read(@RequestBody Friend address) {
		return addressService.findAll();
	}

	@PutMapping("/address")
	ResponseEntity<Address> update(@RequestBody Address address) {
		if (addressService.findById(address.getId()).isPresent()) {
			return new ResponseEntity(addressService.save(address), HttpStatus.OK);
		} else {
			return new ResponseEntity(address, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/address/{id}")
	void delete(@PathVariable("id") Integer Id) {
		addressService.deleteById(Id);
	}

	@GetMapping("/address/{id}")
	Optional<Address> findById(@PathVariable("id") Integer Id) {
		return addressService.findById(Id);
	}

}
