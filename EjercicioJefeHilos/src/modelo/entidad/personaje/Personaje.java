package modelo.entidad.personaje;

import modelo.entidad.arma.Arma;
import modelo.entidad.Fortaleza;

public abstract class Personaje extends Thread{
	
	private String nombre;
	private Arma arma;
	private Integer vida;
	private Integer velocidad;
	private Fortaleza fortaleza;
	
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
	
	@Override
	public void run() {
		fortaleza.combatirJefe(this);
	}

	public Fortaleza getFortaleza() {
		return fortaleza;
	}

	public void setFortaleza(Fortaleza fortaleza) {
		this.fortaleza = fortaleza;
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
