package modelo.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.entidad.Coche;

public class GestorCocheTest {
	
	@Test
	public void buscarPorIdTest() {
		int id = 2;
		String matriculaEsperada = "121212A";
		String marcaEsperada = "opel";
		String modeloEsperada = "kalos";
		Double kilometrosEsperada = 1500.5;
		
		GestorCoche gc = new GestorCoche();
		Coche c = gc.buscarPorID(id);
		
		assertEquals(matriculaEsperada, c.getMatricula());
		assertEquals(marcaEsperada, c.getMarca());
		assertEquals(modeloEsperada, c.getModelo());
		assertEquals(kilometrosEsperada, c.getKilometros());
	}
	
}
