package modelo.entidad;

import modelo.entidad.personaje.Personaje;

public class Fortaleza {
	
	private Personaje jefe;
	
	public Fortaleza(Personaje jefe) {
		super();
		this.jefe = jefe;
	}

	public synchronized void combatirJefe(Personaje p) {
		if(jefe.getVida() > 0) {
			System.out.println(p + " entra al combate con el jefe " + jefe);
			Combate comb = new Combate(p, jefe);
			comb.batalla();
			if(jefe.getVida() > 0) {
				System.out.println(p + " no ha podido vencer al jefe");
			}else {
				System.out.println(p + " ha vencido al jefe!!! Viva!!!");
			}
		}else{
			System.out.println(p + " ha llegado tarde, ya han vencido al jefe ...");
		}
		
		System.out.println();
	}

	public Personaje getJefe() {
		return jefe;
	}

	public void setJefe(Personaje jefe) {
		this.jefe = jefe;
	}
	
}
