package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dtos.ReservaDto;
import model.Reserva;
import service.ReservaService;

@RestController
public class ReservaController {
	
	@Autowired
	ReservaService service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> reservas() {
		return service.reservas();
	}
	
	@PostMapping(value="reservar", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String reservar(@RequestBody ReservaDto r) {
		return String.valueOf(service.reservar(r));
	}

}
