package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {
	
	@Autowired
	BuscadorService service;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("tema") String tematica, HttpServletRequest request){
		List<Pagina> paginas = service.buscar(tematica);
		request.setAttribute("paginas", paginas);
		return "listado";
	}
	
	@GetMapping(value="Insertar")
	public String insertarGet(HttpServletRequest request){
		Pagina p = new Pagina(null, null, null);
		request.setAttribute("pagina", p);
		return "insertar";
	}
	
	@PostMapping(value="Insertar")
	public String insertarPost(@RequestParam("dir") String dir, @RequestParam("tema") String tema, @RequestParam("desc") String desc){
		Pagina p = new Pagina(dir, tema, desc);
		service.insertar(p);
		return "datos";
	}

}
