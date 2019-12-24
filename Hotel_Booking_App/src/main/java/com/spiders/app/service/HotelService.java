package com.spiders.app.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spiders.app.dto.HotelDto;
import com.spiders.app.dto.UserDto;
import com.spiders.app.repository.HotelDao;
import com.spiders.app.repository.UserDao;

@Repository
public class HotelService {
	
	@Autowired
	private HotelDao hotelDao;

	public List<HotelDto> findHotelBtwMinAndMax(double min , double max) {
		return hotelDao.findHotelBtwMinAndMax(min, max);
	}

}
