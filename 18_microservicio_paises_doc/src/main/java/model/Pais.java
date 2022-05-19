package model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pais {

	@JsonAlias(value="name")
	private String nombre;
	private String capital;
	@JsonAlias(value="region")
	private String continente;
	@JsonAlias(value="population")
	private long poblacion;
	@JsonAlias(value="flag")
	private String bandera;
	
}
