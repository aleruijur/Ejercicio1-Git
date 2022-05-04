package service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.AlumnosDao;
import dao.CursosDao;
import dao.MatriculasDao;
import dtos.AlumnoDto;
import dtos.CursoDto;
import dtos.MatriculaDto;
import model.Alumno;
import model.Curso;
import model.Matricula;
import model.MatriculaPk;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Autowired
	ConversorEntityDto conversor;

	CursosDao cursosDao;
	
	AlumnosDao alumnosDao;
	
	MatriculasDao matriculasDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao, @Autowired MatriculasDao matriculasDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
		this.matriculasDao = matriculasDao;
	}

	@Override
	public AlumnoDto validarUsuario(String usuario, String password) {
		try{
			return conversor.alumnoToDto(alumnosDao.findByUsuarioAndPassword(usuario, password));
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public List<CursoDto> cursosDelAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> findAllCursos() {
		return cursosDao.findAll()
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<AlumnoDto> findAllAlumnos() {
		return alumnosDao.findAll()
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDto> alumnosDelCurso(String curso) {
		return alumnosDao.findByCurso(curso)
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public boolean matricular(String usuario, int idCurso) {
		Curso curso = cursosDao.findById(idCurso).orElse(null);
		Alumno alumno = alumnosDao.findById(usuario).orElse(null);
		if(curso!=null&&alumno!=null) {
			matriculasDao.save(new Matricula(new MatriculaPk(usuario,idCurso),0,curso,alumno));
			return true;
		}
		return false;
	}

	@Override
	public List<CursoDto> findCursosNoMatriculados(String usuario) {
		return cursosDao.findCursosNoMatriculados(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<MatriculaDto> consultarMatriculas(Date inicio, Date fin) {
		return matriculasDao.findMatriculasFecha(inicio, fin)
				.stream()
				.map(m->conversor.matriculaToDto(m))
				.collect(Collectors.toList());
	}

	@Override
	public boolean altaAlumno(AlumnoDto a) {
		Alumno alumno = alumnosDao.findById(a.getUsuario()).orElse(null);
		if(alumno == null){
			alumnosDao.save(conversor.dtoToAlumno(a));
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean altaCurso(CursoDto c) {
		Curso curso = cursosDao.findByNombre(c.getNombre()).orElse(null);
		if(curso == null){
			cursosDao.save(conversor.dtoToCurso(c));
			return true;
		}else {
			return false;
		}
	}

}
