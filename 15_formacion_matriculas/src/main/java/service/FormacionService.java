package service;

import java.util.Date;
import java.util.List;

import dtos.AlumnoDto;
import dtos.CursoDto;
import dtos.MatriculaDto;

public interface FormacionService {
	AlumnoDto validarUsuario(String usuario, String password);
	List<CursoDto> cursosDelAlumno(String usuario);
	List<CursoDto> findAllCursos();
	List<AlumnoDto> alumnosDelCurso(String curso);
	boolean matricular(String usuario, int idCurso);
	List<AlumnoDto> findAllAlumnos();
	List<CursoDto> findCursosNoMatriculados(String usuario);
	List<MatriculaDto> consultarMatriculas(Date inicio, Date fin);
	boolean altaAlumno(AlumnoDto a);
	boolean altaCurso(CursoDto c);
}
