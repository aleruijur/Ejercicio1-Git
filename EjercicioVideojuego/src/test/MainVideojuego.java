package test;

import modelo.entidad.Combate;
import modelo.entidad.arma.Arco;
import modelo.entidad.arma.Espada;
import modelo.entidad.personaje.Guerrero;

public class MainVideojuego {

	public static void main(String[] args) {
		Espada espada = new Espada(5);
		Arco arco = new Arco(3);
		
		Guerrero gue1 = new Guerrero("Link", arco, 20, 3);
		Guerrero gue2 = new Guerrero("Ganondorf", espada, 30, 10);
		
		Combate comb = new Combate(gue1, gue2);

		comb.batalla();
	}

}
