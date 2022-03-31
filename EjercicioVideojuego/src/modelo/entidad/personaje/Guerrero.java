package modelo.entidad.personaje;

import modelo.entidad.arma.Arco;
import modelo.entidad.arma.Arma;
import modelo.entidad.arma.Espada;

public class Guerrero extends Personaje{
	
	private Integer fuerza;
	
	public Guerrero(String nombre, Arma arma, Integer vida, Integer velocidad, Integer fuerza) {
		super(nombre, arma, vida, velocidad);
		this.fuerza = fuerza;
	}

	@Override
	public void atacar(Personaje p) {
		Integer daño = this.getArma().usar();
		if(this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
			daño = daño + this.fuerza;
		}
		p.herir(daño);
		System.out.println("El guerrero " + this.getNombre() + " inflinje " + daño + " puntos de daño a " + p.getNombre());
	}
	
	public Integer getFuerza() {
		return fuerza;
	}

	public void setFuerza(Integer fuerza) {
		this.fuerza = fuerza;
	}

}
