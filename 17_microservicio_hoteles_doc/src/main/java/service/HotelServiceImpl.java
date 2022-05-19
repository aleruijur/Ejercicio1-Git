package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	HotelesDao dao;
	
	public HotelServiceImpl(@Autowired HotelesDao dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<Hotel> hotelesDisponibles() {
		return dao.findByDisponible(1);
	}

	@Override
	public Hotel hotelPorNombre(String nombre) {
		Optional<Hotel> op = dao.findByNombre(nombre);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}

}
