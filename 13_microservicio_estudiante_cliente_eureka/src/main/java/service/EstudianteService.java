package service;

import java.util.List;

import model.Estudiante;

public interface EstudianteService {

	List<Estudiante> buscarPorPuntuacionMinima(double puntuacion);
	void insetar(Estudiante p);
}
