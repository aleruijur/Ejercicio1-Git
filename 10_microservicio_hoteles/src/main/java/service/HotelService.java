package service;

import java.util.List;

import model.Hotel;

public interface HotelService {
	
	List<Hotel> hotelesDisponibles();
	Hotel hotelPorNombre(String nombre);
	
}
