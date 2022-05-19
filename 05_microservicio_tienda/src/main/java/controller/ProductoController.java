package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	ProductoService service;
	
	@GetMapping(value="Buscador", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> buscar(@RequestParam("seccion") String seccion){
		return service.buscarPorSeccion(seccion);
	}
	
	@GetMapping(value="Productos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos(){
		return service.productos();
	}
	
	@PostMapping(value="Alta")
	public void alta(@ModelAttribute Producto p){
		service.insetar(p);
	}
	
	@DeleteMapping(value="Eliminar")
	public void eliminar(@RequestParam("id") int id){
		service.eliminar(id);
	}
	
}
