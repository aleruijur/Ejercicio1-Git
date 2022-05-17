package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import service.HotelService;

@CrossOrigin("*")
@RestController
public class HotelController {
	
	@Autowired
	HotelService service;
	
	@GetMapping("disponibles")
	public List<Hotel> hotelesDisponibles() {
		return service.hotelesDisponibles();
	}
	
	@GetMapping("{nombre}")
	public Hotel getHotel(@PathVariable("nombre") String nombre) {
		return service.hotelPorNombre(nombre);
	}

}
