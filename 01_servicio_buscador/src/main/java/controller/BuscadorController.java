package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Pagina;
import service.BuscadorService;

@RestController
public class BuscadorController {
	@Autowired
	BuscadorService service;
	
	@GetMapping(value="Paginas",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> paginas(){
		return service.paginas();
	}
	
//	@GetMapping(value="Buscador",produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<Pagina> buscador(@RequestParam("tematica") String tematica){
//		return service.buscar(tematica);
//	}
	
	@GetMapping(value="Paginas/{tematica}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> buscador(@PathVariable("tematica") String tematica){
		return service.buscar(tematica);
	}
	
	@PostMapping(value="Pagina",produces=MediaType.APPLICATION_JSON_VALUE)
	public void buscador(Pagina p){
		service.alta(p);
	}
}
