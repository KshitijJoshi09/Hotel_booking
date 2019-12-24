package com.spiders.app.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spiders.app.dto.HotelDto;
import com.spiders.app.dto.UserDto;

@Repository
public class HotelDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Serializable saveHotel(HotelDto hotel) {
		long id = 0;
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession();){
			tx = session.beginTransaction();
			
			id = (long)session.save(hotel);
		//	session.getTransaction().commit();
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			// TODO: handle exception
		}		
		return id;
	}

	
	public List<HotelDto> findHotelBtwMinAndMax(double min , double max){
		List<HotelDto> listOfHotels = null;
		
		try(Session session = sessionFactory.openSession();){
			
		Query query 
		= session.createQuery("From HotelDto where "
				+ " roomPrice <=:higerPrice and roomPrice >=: lowerPrice"
				+ " order by roomPrice desc");
			query.setParameter("lowerPrice", min);
			query.setParameter("higerPrice", max);
			
			listOfHotels = query.list();
			
		}catch (Exception e) {
	e.printStackTrace();
		}		
		
		return listOfHotels;
	}
	

	
}
