package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	ProductosDao dao;
	
	public ProductoServiceImpl(@Autowired ProductosDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Producto> productos() {
		return dao.findAll();
	}

	@Override
	public boolean actualizarStock(int codigoProducto, int unidades) {
		Optional<Producto> op = dao.findById(codigoProducto);
		if(op.isPresent()) {
			Producto p = op.get();
			if(unidades <= p.getStock()) {
				p.setStock(p.getStock() - unidades);
				dao.save(p);
				return true;
			}
		}
		return false;
	}

	@Override
	public Double precio(int codigoProducto) {
		Optional<Producto> op = dao.findById(codigoProducto);
		if(op.isPresent()) {
			return op.get().getPrecioUnitario();
		}else {
			return null;
		}
	}

}