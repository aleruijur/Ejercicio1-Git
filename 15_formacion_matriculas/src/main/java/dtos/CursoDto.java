package dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CursoDto {
	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaInicio;
	
}
