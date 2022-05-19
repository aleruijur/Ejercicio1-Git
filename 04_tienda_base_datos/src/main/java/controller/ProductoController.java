package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	ProductoService service;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("seccion") String seccion, HttpServletRequest request){
		List<Producto> productos = service.buscarPorSeccion(seccion);
		request.setAttribute("productos", productos);
		return "listado";
	}
	
	@PostMapping(value="Alta")
	public String alta(@ModelAttribute Producto p){
		service.insetar(p);
		return "alta";
	}
	
	@GetMapping(value="Modificar")
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("precio") Number precio){
		service.modificar(nombre, precio);
		return "inicio";
	}
	
	@GetMapping(value="Eliminar")
	public String eliminar(@RequestParam("nombre") String nombre){
		service.eliminar(nombre);
		return "inicio";
	}
	
}
