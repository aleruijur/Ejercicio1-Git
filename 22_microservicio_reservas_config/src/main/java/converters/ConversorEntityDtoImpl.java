package converters;

import org.springframework.stereotype.Component;

import dtos.ReservaDto;
import model.Reserva;

@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto{

	@Override
	public Reserva dtoToReserva(ReservaDto dto) {
		return new Reserva(dto.getNombre(),dto.getDni(),dto.getHotel(),dto.getVuelo());
	}

}
