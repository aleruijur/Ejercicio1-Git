package modelo.entidad.personaje;

import modelo.entidad.arma.Arma;
import modelo.entidad.arma.Hechizo;

public class Mago extends Personaje{

	private Integer inteligencia;

	public Mago(String nombre, Arma arma, Integer vida, Integer velocidad, Integer inteligencia) {
		super(nombre, arma, vida, velocidad);
		this.inteligencia = inteligencia;
	}

	@Override
	public void atacar(Personaje p) {
		Integer daño = this.getArma().usar();
		if(this.getArma() instanceof Hechizo) {
			daño = daño + this.inteligencia;
		}
		p.herir(daño);
		System.out.println("El mago " + this.getNombre() + " inflinje " + daño + " puntos de daño a " + p.getNombre());
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

}
