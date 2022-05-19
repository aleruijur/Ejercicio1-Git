package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	ProductosDao productosDao;
	
	public ProductoServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}
	
	@Override
	public List<Producto> buscarPorSeccion(String seccion) {
		return productosDao.findBySeccion(seccion);
	}

	@Override
	public void insetar(Producto p) {
		productosDao.save(p);
	}

	@Override
	public void eliminar(int id) {
		productosDao.deleteById(id);
	}

	@Override
	public List<Producto> productos() {
		return productosDao.findAll();
	}

}
