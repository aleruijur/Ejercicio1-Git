package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	public List<Pagina> buscar(String tema);
	public void insertar(Pagina pagina);
}
