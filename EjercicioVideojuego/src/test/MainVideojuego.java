package test;

import modelo.entidad.Torneo;
import modelo.entidad.arma.*;
import modelo.entidad.personaje.*;

public class MainVideojuego {

	public static void main(String[] args) {
		Espada espada = new Espada(4);
		Arco arco = new Arco(2);
		Hechizo hech = new Hechizo(5);
		Rezo rezo = new Rezo(2);
		
		Guerrero gue1 = new Guerrero("Link", arco, 20, 3, 2);
		Guerrero gue2 = new Guerrero("Ganondorf", espada, 30, 1, 3);
		Mago mago1 = new Mago("Kamek", hech, 20, 1, 2);
		Curandero cur1 = new Curandero("Zelda", rezo, 25, 5, 4);
		
		Torneo torneo = new Torneo();
		torneo.añadirParticipante(gue1);
		torneo.añadirParticipante(gue2);
		torneo.añadirParticipante(mago1);
		torneo.añadirParticipante(cur1);
		
		torneo.comenzarTorneo();
		
	}

}
