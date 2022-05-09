package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PutMapping("{idVuelo}/{plazas}")
	public void getHotel(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazas") int plazas) {
		service.actualizarPlazas(idVuelo, plazas);
	}

}
