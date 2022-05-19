package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.EscuelaService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class EscuelaServiceTest {
	
	@Autowired
	EscuelaService service;
	
	@Test
	void testAlumnosCurso(){
		assertEquals(4,service.alumnosCurso("java").size());
	}
	
	@Test
	void testAlumnosCursoDuracion(){
		assertEquals(3,service.alumnosCursoDuracion(90).size());
	}
	
	@Test
	void testCursoMatriculadoAlumno(){
		assertEquals("python",service.cursoMatriculadoAlumno("3333C").getDenominacion());
	}
	
	@Test
	void testAlumnosSenior(){
		assertEquals(2,service.alumnosSenior(40).size());
	}
	
	@Test
	void testEdadMediaCurso(){
		assertEquals(40.25,service.edadMediaCurso("python"));
	}
	
	@Test
	void testPrecioCurso(){
		assertEquals(200,service.precioCurso("tercero@gmail.com"));
	}

}
