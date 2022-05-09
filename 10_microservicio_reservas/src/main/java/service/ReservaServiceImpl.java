package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import converters.ConversorEntityDto;
import dao.ReservasDao;
import dtos.ReservaDto;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservaServiceImpl implements ReservaService {

	ReservasDao dao;
	@Autowired
	ConversorEntityDto conversor;
	
	RestTemplate template;
	String urlBase = "http://localhost:8001/vuelos/";
	
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
		Vuelo[] vuelos = template.getForObject(urlBase + "disponibles/{plazas}" , Vuelo[].class, dto.getPlazas());
		List<Integer> ids = Arrays.stream(vuelos)
				.map(v->v.getIdVuelo())
				.collect(Collectors.toList());
		if(ids.contains(dto.getVuelo())) {
			Reserva r = conversor.dtoToReserva(dto);
			dao.save(r);
			template.put(urlBase + r.getVuelo() + "/" + dto.getPlazas(), null);
			return true;
		}else{
			return false;
		}
	}

}
