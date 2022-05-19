package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	RestTemplate template;
	String urlBase = "http://servicio-alumnos/crud";
	
	public EstudianteServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public void insetar(Estudiante e) {
		template.postForLocation(urlBase+"/Alumno", e);
	}

	@Override
	public List<Estudiante> buscarPorPuntuacionMinima(double puntuacion) {
		Estudiante[] es = template.getForObject(urlBase+"/Alumnos", Estudiante[].class);
		return Arrays.stream(es)
				.filter(e->e.getPuntuacion()>puntuacion)
				.collect(Collectors.toList());
	}

}
