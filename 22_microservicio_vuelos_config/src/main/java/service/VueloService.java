package service;

import java.util.List;

import model.Vuelo;

public interface VueloService {
	
	List<Vuelo> vuelosDisponibles(int plazas);
	boolean actualizarPlazas(int idVuelo, int plazas);
	
}
