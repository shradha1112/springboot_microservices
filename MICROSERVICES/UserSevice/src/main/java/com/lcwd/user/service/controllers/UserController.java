package com.lcwd.user.service.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
    Logger logger = Logger.getLogger(UserController.class.getName());

	int retryCount = 1;

	@PostMapping
	public ResponseEntity<User> createUser (@RequestBody User user)
	{
	User user1 = userService.saveUser (user);
	return ResponseEntity.status (HttpStatus.CREATED).body (user);
	}

	//single user get
	@GetMapping ("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratigHotelFallback")
//	@Retry(name = "ratingHotelBreaker", fallbackMethod = "ratigHotelFallback")
	@RateLimiter(name="userRateLimiter",  fallbackMethod = "ratigHotelFallback")
	public ResponseEntity<User> getSingleUser (@PathVariable String userId) {
		
		logger.log(Level.INFO, "RetryCount ",  retryCount);
		User user = userService.getUser(userId);
		retryCount++;
		return ResponseEntity.ok(user);
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
	    logger.log(Level.SEVERE, "Invalid User", ex.getMessage());

	    User user = new User(); // Initialize User object before setting its properties
	    user.setName("Dummy");
	    user.setEmail("dummy@gmail.com");
	    user.setAbout("This is the dummy Microservice");
	    user.setUserId("454545");

	    return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping 
	public ResponseEntity<List<User>> getAllUser() {
	List<User> allUser = userService.getAllUser();
	return ResponseEntity.ok (allUser);
	}
}
