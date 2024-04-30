package com.lcwd.user.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.user.service.entities.User;

@Service
public interface UserService {
	//create
	User saveUser (User user);
	//get all user
	List<User>getAllUser();
	//get single user of given userId
	User getUser (String userId);
}
