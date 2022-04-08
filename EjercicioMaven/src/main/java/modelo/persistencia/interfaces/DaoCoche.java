package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;

public interface DaoCoche {
	boolean alta(Coche c);
	boolean baja(int id);
	boolean modificar(Coche c);
	Coche buscarPorID(int id);
	Coche buscarPorMatricula(String matricula);
	List<Coche> buscarPorMarca(String marca);
	List<Coche> buscarPorModelo(String modelo);
	List<Coche> listar();
}
