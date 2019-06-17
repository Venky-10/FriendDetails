package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Address;

public interface AddressService extends CrudRepository<Address, Integer>{

}
