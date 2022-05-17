package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.PedidoService;

@CrossOrigin("*")
@RestController
public class PedidoController {
	
	@Autowired
	PedidoService service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> pedidos() {
		return service.pedidos();
	}
	
	@PostMapping(produces=MediaType.TEXT_PLAIN_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String alta(@RequestBody Pedido p) {
		return String.valueOf(service.insertar(p));
	}

}
