package service;

import java.util.List;

import model.Producto;

public interface ProductoService {

	List<Producto> buscarPorSeccion(String seccion);
	Producto buscarPorId(int id);
	void insetar(Producto p);
	void modificar(String nombre, Double precio);
	void eliminar(String nombre);
}
