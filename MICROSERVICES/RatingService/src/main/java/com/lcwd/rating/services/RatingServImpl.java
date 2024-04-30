package com.lcwd.rating.services;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.respositories.RatingRepository;

@Service
public class RatingServImpl implements RatingService {

	@Autowired
	private RatingRepository repository;
	
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		System.out.println(ratingId);
		System.out.println(rating.getRatingId());
		return repository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		
		
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return repository.findByHotelId(hotelId);
	}

}
