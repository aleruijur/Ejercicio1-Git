package service;

import java.util.List;

import model.Producto;

public interface ProductoService {
	
	List<Producto> productos();
	boolean actualizarStock(int codigoProducto, int unidades);
	Double precio(int codigoProducto);
	
}
