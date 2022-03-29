package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {
	private DaoCoche daoCoche = new DaoCocheMySql();
	
	public int alta(Coche c){
		if(c.getKilometros()>=0) {
			if(c.getMatricula().length() == 7) {
				Coche existe = daoCoche.buscarPorMatricula(c.getMatricula());
				if(existe==null) {
					boolean alta = daoCoche.alta(c);
					if(alta) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 3;
				}
			}else {
				return 2;
			}
		}else {
			return 4;
		}
		
	}
	
	public boolean baja(int id){
		return daoCoche.baja(id);
	}
	
	public int modificar(Coche c){
		if(c.getKilometros()>=0) {
			if(c.getMatricula().length() == 7) {
				Coche existe = daoCoche.buscarPorMatricula(c.getMatricula());
				if(existe==null || existe.getId()==c.getId()) {
					boolean modificar = daoCoche.modificar(c);
					if(modificar) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 3;
				}
			}else {
				return 2;
			}
		}else {
			return 4;
		}
	}
	
	public Coche buscarPorID(int id){
		return daoCoche.buscarPorID(id);
	}
	
	public Coche buscarPorMatricula(String matricula){
		return daoCoche.buscarPorMatricula(matricula);
	}
	
	public List<Coche> buscarPorMarca(String marca){
		return daoCoche.buscarPorMarca(marca);
	}
	
	public List<Coche> buscarPorModelo(String modelo){
		return daoCoche.buscarPorModelo(modelo);
	}
	
	public List<Coche> listar(){
		return daoCoche.listar();
	}
	
}
