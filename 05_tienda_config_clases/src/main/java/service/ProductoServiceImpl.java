package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Producto> buscarPorSeccion(String seccion) {
		String query = "select * from productos where seccion=?";
		return template.query(query, 
				(rs,f)-> new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getString("seccion"),rs.getDouble("precio"),rs.getInt("stock")), 
				seccion);
	}

	@Override
	public void insetar(Producto p) {
		String query = "insert into productos(nombre, seccion, precio, stock) values (?,?,?,?)";
		template.update(query,p.getNombre(),p.getSeccion(),p.getPrecio(),p.getStock());
	}

	@Override
	public void modificar(String nombre, Number precio) {
		String query = "update productos set precio=? where nombre=?";
		template.update(query,precio,nombre);
	}

	@Override
	public void eliminar(String nombre) {
		String query = "delete from productos where nombre=?";
		template.update(query,nombre);
	}

	@Override
	public Producto buscarPorId(int id) {
		String query = "select * from productos where id=?";
		List<Producto> list = template.query(query, 
				(rs,f)-> new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getString("seccion"),rs.getDouble("precio"),rs.getInt("stock")), 
				id);
		return list.size()>0 ? list.get(0) : null;
	}

}
