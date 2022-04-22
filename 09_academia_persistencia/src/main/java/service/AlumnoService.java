package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {
	
	boolean insertar(Alumno a);
	List<Alumno> buscarPorCurso(String curso);
	Alumno buscarPorNombre(String nombre);
	List<String> listaCursos();
	
}
