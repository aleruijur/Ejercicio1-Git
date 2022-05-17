package service;

import java.util.List;

import dtos.ReservaDto;
import model.Reserva;

public interface ReservaService {
	
	List<Reserva> reservas();
	boolean reservar(ReservaDto dto);
	
}
