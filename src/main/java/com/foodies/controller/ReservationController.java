package com.foodies.controller;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.foodies.ReservationDto;
import com.foodies.form.ReservationForm;

@Controller
public class ReservationController {

	private  List<ReservationDto>  list = new ArrayList<ReservationDto>();
	
	{
		List<ReservationDto> reservationDtos = Arrays
				.asList(new ReservationDto[] { new ReservationDto("Johnson", "98387393", 2),
						new ReservationDto("Joseph", "98387392", 8),
						new ReservationDto("James", "9832928", 4),
						new ReservationDto("Jack", "72739445", 5) });
		list.addAll(reservationDtos);
	}
	
	@GetMapping("/reservation")
	public String showReservationForm() {
		return "reservation";
	}

	@PostMapping("/reservation")
	public String doReservation(@ModelAttribute("reservationForm") ReservationForm form, ModelMap model) {
		model.addAttribute("person", form.getName());
		list.add(new ReservationDto(form.getName(), form.getPhoneNumber(), form.getPersons()));
		return "reservation-success";
	}

	@GetMapping("/list")
	public String showReservations(ModelMap model) {
		model.addAttribute("reservations", list);
		return "reservation-list";
	}

}
