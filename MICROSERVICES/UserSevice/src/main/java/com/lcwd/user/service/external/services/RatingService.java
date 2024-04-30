package com.lcwd.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lcwd.user.service.entities.Rating;



@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@PostMapping("/ratings")
	public Rating create(Rating rating);

	@GetMapping("/ratings/{}")
	public List<Rating> getRatings();
	
}
