package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import model.Pais;
import service.PaisService;

@CrossOrigin("*")
@RestController
public class PaisController {

	@Autowired
	PaisService service;
	
	@ApiOperation("Devuelve todos los continentes")
	@GetMapping(value="Continentes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.continentes();
	}
	
	@ApiOperation("Devuelve una lista de países que pertenecen al continente dado como parámetro")
	@GetMapping(value="Pais/{continente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> buscar(@PathVariable("continente") String continente){
		return service.paisesPorContiente(continente);
	}
	
	@ApiOperation("Devuelve la suma de la población del continente dado como parámetro")
	@GetMapping(value="Poblacion/{continente}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String habitantes(@PathVariable("continente") String continente){
		return String.valueOf(service.poblacionContiente(continente));
	}
	
}
