package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Hotel;

public interface HotelesDao extends JpaRepository<Hotel, Integer>{

	Optional<Hotel> findByNombre(String nombre);
	
	List<Hotel> findByDisponible(int disponible);
	
}
