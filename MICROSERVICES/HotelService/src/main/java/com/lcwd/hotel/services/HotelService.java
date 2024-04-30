package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface HotelService {

	public Hotel create (Hotel hotel);
	public List<Hotel>getAll() ;
	public Hotel get(String id);
}
