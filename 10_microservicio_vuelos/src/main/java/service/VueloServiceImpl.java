package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VueloServiceImpl implements VueloService {

	VuelosDao dao;
	
	public VueloServiceImpl(@Autowired VuelosDao dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<Vuelo> vuelosDisponibles(int plazas) {
		return dao.findByPlazasGreaterThanEqual(plazas);
	}

	@Override
	public void actualizarPlazas(int idVuelo, int plazas) {
		Optional<Vuelo> op = dao.findById(idVuelo);
		if(op.isPresent()) {
			Vuelo v = op.get();
			v.setPlazas(v.getPlazas() - plazas);
			dao.save(v);
		}
	}

}
