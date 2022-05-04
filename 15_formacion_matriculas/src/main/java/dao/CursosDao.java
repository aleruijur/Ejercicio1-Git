package dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosDao extends JpaRepository<Curso,Integer>{
	
	@Query("select c from Curso c join c.matriculas m where m.alumno.usuario=?1")
	List<Curso> findByAlumno(String usuario);
	
	@Query("select c from Curso c where c.idCurso not in (select c.idCurso from Curso c join c.matriculas m where m.alumno.usuario=?1)")
	List<Curso> findCursosNoMatriculados(String usuario);
	
	List<Curso> findByFechaInicioBetween(Date inicio, Date fin);
	
	Optional<Curso> findByNombre(String nombre);
}
