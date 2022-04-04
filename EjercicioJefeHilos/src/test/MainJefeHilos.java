package test;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Fortaleza;
import modelo.entidad.arma.*;
import modelo.entidad.personaje.*;

public class MainJefeHilos {

	public static void main(String[] args) {
		Espada espada = new Espada(4);
		Arco arco = new Arco(2);
		Hechizo hech = new Hechizo(5);
		Rezo rezo = new Rezo(2);
		
		Guerrero gue1 = new Guerrero("Link", arco, 20, 3, 2);
		Guerrero gue2 = new Guerrero("Ganondorf", espada, 30, 1, 3);
		Mago mago1 = new Mago("Kamek", hech, 20, 1, 2);
		Curandero cur1 = new Curandero("Zelda", rezo, 25, 5, 4);
		
		Hechizo fuego = new Hechizo(5);
		Mago dragon = new Mago("Dragón", fuego, 60, 0, 1);
		Fortaleza fort = new Fortaleza(dragon);
		
		List<Personaje> personajes = new ArrayList<>();
		personajes.add(gue1);
		personajes.add(gue2);
		personajes.add(mago1);
		personajes.add(cur1);
		
		for(Personaje p: personajes) {
			p.setFortaleza(fort);
			p.start();
		}
		
	}

}
