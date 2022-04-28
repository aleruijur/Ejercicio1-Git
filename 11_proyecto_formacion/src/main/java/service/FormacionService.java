package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	Alumno validarUsuario(String usuario, String password);
	List<Curso> cursosDelAlumno(String usuario);
	List<Curso> findAllCursos();
	List<Alumno> alumnosDelCurso(String curso);
	boolean matricular(String usuario, int idCurso);
	List<Alumno> findAllAlumnos();
}
