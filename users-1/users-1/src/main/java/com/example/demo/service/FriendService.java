package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Friend;

public interface FriendService extends CrudRepository<Friend, Integer> {

}
