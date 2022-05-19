package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
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
	
	@Test
	void testMatricular(){
		int numCursos = service.cursosDelAlumno("aaa").size();
		service.matricular("aaa",3);
		assertEquals(numCursos+1,service.cursosDelAlumno("aaa").size());
	}

}
