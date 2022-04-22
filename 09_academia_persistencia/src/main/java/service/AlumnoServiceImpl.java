package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public boolean insertar(Alumno a) {
		if(buscarPorNombre(a.getNombre())==null){
			entityManager.persist(a);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Alumno> buscarPorCurso(String curso) {
		String sql = "select a from Alumno a where a.curso=?1";
		return entityManager.createQuery(sql, Alumno.class).setParameter(1, curso).getResultList();
	}

	@Override
	public Alumno buscarPorNombre(String nombre) {
		String sql = "select a from Alumno a where a.nombre=?1";
		try {
			return entityManager.createQuery(sql, Alumno.class).setParameter(1, nombre).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		
	}

	@Override
	public List<String> listaCursos() {
		String sql = "select distinct a.curso from Alumno a";
		return entityManager.createQuery(sql, String.class).getResultList();
	}

}
