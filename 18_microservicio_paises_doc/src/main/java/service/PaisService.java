package service;

import java.util.List;

import model.Pais;

public interface PaisService {
	
	List<String> continentes();
	List<Pais> paisesPorContiente(String continente);
	long poblacionContiente(String continente);

}
