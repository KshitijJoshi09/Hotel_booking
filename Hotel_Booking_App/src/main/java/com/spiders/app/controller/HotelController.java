package com.spiders.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spiders.app.dto.HotelDto;
import com.spiders.app.service.HotelService;

@Controller
public class HotelController {

	
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("/findAllHotels")
	public String displayFindHotelPage(){
		// this will redireect to find hotel page 
		return "showHotels";
	}
	
	@RequestMapping("/findByMinMax")
	public String findHotelByMinAndMaxPrice(@RequestParam double min , @RequestParam double max , Model model){
		// this will reciece the information of min and max and will redirect to same page
		
		List<HotelDto> hotels = hotelService.findHotelBtwMinAndMax(min, max);
		System.out.println("hotle list "+hotels.size());
		model.addAttribute("hotels", hotels);
		model.addAttribute("min", min);
		model.addAttribute("max", max);
		
		return "showHotels";
	}
	
	
}
