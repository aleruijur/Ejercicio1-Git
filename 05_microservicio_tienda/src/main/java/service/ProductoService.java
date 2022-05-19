package service;

import java.util.List;

import model.Producto;

public interface ProductoService {

	List<Producto> buscarPorSeccion(String seccion);
	List<Producto> productos();
	void insetar(Producto p);
	void eliminar(int id);
}
