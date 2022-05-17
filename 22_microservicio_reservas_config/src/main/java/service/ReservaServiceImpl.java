package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import converters.ConversorEntityDto;
import dao.ReservasDao;
import dtos.ReservaDto;
import model.Reserva;

@Service
public class ReservaServiceImpl implements ReservaService {

	ReservasDao dao;
	@Autowired
	ConversorEntityDto conversor;
	
	RestTemplate template;
	String urlBase = "http://servicio-vuelos/vuelos/";
	
	public ReservaServiceImpl(@Autowired ReservasDao dao, @Autowired RestTemplate template) {
		super();
		this.dao = dao;
		this.template = template;
	}

	@Override
	public List<Reserva> reservas() {
		return dao.findAll();
	}

	@Override
	public boolean reservar(ReservaDto dto) {
		ResponseEntity<String> res = template.exchange(urlBase + dto.getVuelo() + "/" + dto.getPlazas(), HttpMethod.PUT, null, String.class);
		if(res.getBody().equals("true")) {
			Reserva r = conversor.dtoToReserva(dto);
			dao.save(r);
			return true;
		}else{
			return false;
		}
	}

}
