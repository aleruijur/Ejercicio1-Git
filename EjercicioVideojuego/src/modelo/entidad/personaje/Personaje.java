package modelo.entidad.personaje;

import modelo.entidad.arma.Arma;

public abstract class Personaje {
	
	private String nombre;
	private Arma arma;
	private Integer vida;
	private Integer velocidad;
	
	public Personaje(String nombre, Arma arma, Integer vida, Integer velocidad) {
		super();
		this.nombre = nombre;
		this.arma = arma;
		this.vida = vida;
		this.velocidad = velocidad;
	}
	
	public abstract void atacar(Personaje p);
	
	public void herir(Integer daño) {
		this.setVida(this.getVida() - daño);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public Integer getVida() {
		return vida;
	}
	public void setVida(Integer vida) {
		this.vida = vida;
	}
	
	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

	
}
