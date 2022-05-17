package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import service.VueloService;

@CrossOrigin("*")
@RestController
public class VueloController {
	
	@Autowired
	VueloService service;
	
	@GetMapping("disponibles/{plazas}")
	public List<Vuelo> vuelosDisponibles(@PathVariable("plazas") int plazas) {
		return service.vuelosDisponibles(plazas);
	}
	
	@PutMapping(value = "{idVuelo}/{plazas}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String getHotel(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazas") int plazas) {
		return String.valueOf(service.actualizarPlazas(idVuelo, plazas));
	}

}
