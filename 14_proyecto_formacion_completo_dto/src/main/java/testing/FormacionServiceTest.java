package testing;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import model.Curso;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class FormacionServiceTest {
	
	@Autowired
	FormacionService service;
	
	@Test
	void testValidarUsuarios(){
		assertEquals("tomates",service.validarUsuario("admin","a").getNombre());
	}
	
	@Test
	void testCursosDelAlumno(){
		assertEquals(4,service.cursosDelAlumno("admin").size());
	}
	
	@Test
	void testFindAllCursos(){
		assertEquals(18,service.findAllCursos().size());
	}
	
	@Test
	void testAlumnosDelCurso(){
		assertEquals(8,service.alumnosDelCurso("java 10").size());
	}
	
//	@Test
//	void testMatricular(){
//		int numCursos = service.cursosDelAlumno("aaa").size();
//		service.matricular("aaa",3);
//		assertEquals(numCursos+1,service.cursosDelAlumno("aaa").size());
//	}
	
	@Test
	void testFindCursosNoMatriculados(){
		assertEquals(15,service.findCursosNoMatriculados("uno").size());
	}
	
	@Test
	void testConsultarMatriculas(){
		Calendar c1 = Calendar.getInstance();
		c1.set(2021, 1, 1);
		Calendar c2 = Calendar.getInstance();
		c2.set(2022, 1, 1);
		assertEquals(4,service.consultarMatriculas(c1.getTime(),c2.getTime()).size());
	}
	
//	@Test
//	void testAltaAlumno(){
//		Alumno a = new Alumno("ale","1234","Alejandro","ale@gmail.com",21);
//		assertTrue(service.altaAlumno(a));
//	}
//	
//	@Test
//	void testAltaCurso(){
//		Curso c = new Curso("cursoTest",60,"20/08/2022",21);
//		c.set
//		assertTrue(service.altaCurso(c));
//	}

}
