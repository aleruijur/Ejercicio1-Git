package service;

import java.util.List;

import model.Pedido;

public interface PedidoService {
	
	List<Pedido> pedidos();
	boolean insertar(Pedido p);
	
}
