package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Producto> buscarPorSeccion(String seccion) {
		String sql = "select p from Producto p where p.seccion=?1";
		return entityManager.createQuery(sql, Producto.class).setParameter(1, seccion).getResultList();
	}

	@Transactional
	@Override
	public void insetar(Producto p) {
		entityManager.persist(p);
	}

	@Transactional
	@Override
	public void modificar(String nombre, Double precio) {
		String sql = "update Producto p set p.precio=:precio where p.nombre=:nombre";
		entityManager.createQuery(sql).setParameter("precio", precio).setParameter("nombre", nombre).executeUpdate();
	}

	@Transactional
	@Override
	public void eliminar(String nombre) {
		String sql = "delete from Producto p where p.nombre=:nombre";
		entityManager.createQuery(sql).setParameter("nombre", nombre).executeUpdate();
	}

	@Override
	public Producto buscarPorId(int id) {
		return entityManager.find(Producto.class,id);
	}

}
