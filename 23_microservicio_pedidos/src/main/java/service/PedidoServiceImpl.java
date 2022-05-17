package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService {

	PedidosDao dao;
	RestTemplate template;
	String urlBase = "http://servicio-productos/";
	
	public PedidoServiceImpl(@Autowired PedidosDao dao, @Autowired RestTemplate template) {
		super();
		this.dao = dao;
		this.template = template;
	}

	@Override
	public List<Pedido> pedidos() {
		return dao.findAll();
	}

	@Override
	public boolean insertar(Pedido p) {
		ResponseEntity<String> res = template.exchange(urlBase + p.getCodigoProducto() + "/" + p.getUnidades(), HttpMethod.PUT, null, String.class);
		if(res.getBody().equals("true")) {
			p.setFechaPedido(new Date());
			ResponseEntity<String> res2 = template.exchange(urlBase + p.getCodigoProducto(), HttpMethod.GET, null, String.class);
			p.setTotal(p.getUnidades() * Double.valueOf(res2.getBody()));
			dao.save(p);
			return true;
		}
		return false;
	}

}