package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.ProductoService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class ProductoServiceTest {
	
	@Autowired
	ProductoService service;
	
	@Test
	void testProducto(){
		assertEquals(10.2,service.buscarPorId(3).getPrecio());
		assertNull(service.buscarPorId(3000));
	}
	
	@Test
	void testMedia(){
		assertEquals(1.3,service.precioMedioSeccion("escolar"));
	}

}
