package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Pagina;

@Service
public class BuscadorServiceImpl implements BuscadorService{

	ArrayList<Pagina> paginas=new ArrayList<>();
	public BuscadorServiceImpl() {
		paginas.add(new Pagina("http://www.fnac.es","libros","Libros y más cosas"));
		paginas.add(new Pagina("http://www.gamer.es","juegos","Juegos on-line"));
		paginas.add(new Pagina("http://www.casadellibro.es","libros","La Web de los libros"));
		paginas.add(new Pagina("http://www.mydisc.es","musica","Música de todo tipo"));
		paginas.add(new Pagina("http://www.radio.es","musica","Música de actualidad"));
	}
	
	@Override
	public List<Pagina> buscar(String tema) {
		return paginas.stream().filter(p->p.getTematica().equals(tema)).collect(Collectors.toList());
	}

	@Override
	public void insertar(Pagina pagina) {
		paginas.add(pagina);
	}

}
