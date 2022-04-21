package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public boolean insertar(Alumno a) {
		if(buscarPorNombre(a.getNombre())==null){
			String query = "insert into alumnos(nombre, curso, nota) values (?,?,?)";
			template.update(query,a.getNombre(),a.getCurso(),a.getNota());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Alumno> buscarPorCurso(String curso) {
		String query = "select * from alumnos where curso=?";
		return template.query(query, 
				(rs,f)-> new Alumno(rs.getInt("idAlumno"),rs.getString("nombre"),rs.getString("curso"),rs.getInt("nota")), 
				curso);
	}

	@Override
	public Alumno buscarPorNombre(String nombre) {
		String query = "select * from alumnos where nombre=?";
		List<Alumno> list = template.query(query, 
				(rs,f)-> new Alumno(rs.getInt("idAlumno"),rs.getString("nombre"),rs.getString("curso"),rs.getInt("nota")), 
				nombre);
		return list.size()>0 ? list.get(0) : null;
	}

	@Override
	public List<String> listaCursos() {
		String query = "select distinct curso from alumnos";
		return template.query(query, 
				(rs,f)-> rs.getString("curso"));
	}

}
