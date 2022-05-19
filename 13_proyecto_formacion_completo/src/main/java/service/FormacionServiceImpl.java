package service;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {

	CursosDao cursosDao;
	
	AlumnosDao alumnosDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}

	@Override
	public Alumno validarUsuario(String usuario, String password) {
		try{
			return alumnosDao.findByUsuarioAndPassword(usuario, password);
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public List<Curso> cursosDelAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> findAllCursos() {
		return cursosDao.findAll();
	}
	
	@Override
	public List<Alumno> findAllAlumnos() {
		return alumnosDao.findAll();
	}

	@Override
	public List<Alumno> alumnosDelCurso(String curso) {
		return alumnosDao.findByCurso(curso);
	}

	@Override
	public boolean matricular(String usuario, int idCurso) {
		Curso curso = cursosDao.findById(idCurso).orElse(null);
		Alumno alumno = alumnosDao.findById(usuario).orElse(null);
		if(curso!=null&&alumno!=null) {
			alumno.getCursos().add(curso);
			alumnosDao.save(alumno);
			return true;
		}
		return false;
	}

	@Override
	public List<Curso> findCursosNoMatriculados(String usuario) {
		return cursosDao.findCursosNoMatriculados(usuario);
	}

	@Override
	public List<Curso> consultarMatriculas(Date inicio, Date fin) {
		return cursosDao.findByFechaInicioBetween(inicio, fin);
	}

	@Override
	public boolean altaAlumno(Alumno a) {
		Alumno alumno = alumnosDao.findById(a.getUsuario()).orElse(null);
		if(alumno == null){
			alumnosDao.save(a);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean altaCurso(Curso c) {
		Curso curso = cursosDao.findByNombre(c.getNombre()).orElse(null);
		if(curso == null){
			cursosDao.save(c);
			return true;
		}else {
			return false;
		}
	}

}
