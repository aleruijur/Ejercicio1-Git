package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import model.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	AlumnosDao alumnosDao;
	
	public AlumnosServiceImpl(@Autowired AlumnosDao alumnosDao) {
		super();
		this.alumnosDao = alumnosDao;
	}

	@Override
	public void altaAlumno(Alumno alumno) {
		alumnosDao.save(alumno);
	}

	@Override
	public Alumno buscarAlumno(int idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarAlumno(int idAlumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarAlumno(int idAlumno, String curso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Alumno> todosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> cursos() {
		// TODO Auto-generated method stub
		return null;
	}

}
