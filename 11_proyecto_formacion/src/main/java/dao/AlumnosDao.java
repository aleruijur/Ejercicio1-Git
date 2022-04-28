package dao;

import java.util.List;

import model.Alumno;

public interface AlumnosDao {

	Alumno findByUsuarioAndPassword(String usuario, String password);
	List<Alumno> findByCurso(String nombre);
	Alumno findById(String usuario);
	void update(Alumno a);
	List<Alumno> findAll();
	
}
