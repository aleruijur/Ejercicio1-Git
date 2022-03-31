package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.personaje.Personaje;

public class Torneo {
	
	private List<Personaje> participantes;
	
	
	
	public Torneo() {
		super();
		this.participantes = new ArrayList<>();
	}

	public void añadirParticipante(Personaje p) {
		this.participantes.add(p);
	}
	
	public Personaje comenzarTorneo() {
		System.out.println("Comienza el torneo entre " + participantes);
		while(participantes.size()>1) {
			List<Personaje> ganadores = new ArrayList<>();
			for(int i=0;i<participantes.size();i+=2) {
				Personaje ganador = eliminatoria(participantes.get(i),participantes.get(i+1));
				ganadores.add(ganador);
			}
			participantes = ganadores;
		}
		System.out.println("<<<El ganador del torneo es " + participantes.get(0) + "!!!>>>");
		return participantes.get(0);
	}
	
	private Personaje eliminatoria(Personaje combatiente1, Personaje combatiente2) {
		Combate comb = new Combate(combatiente1, combatiente2);
		Personaje ganador = comb.batalla();
		return ganador;
	}

	public List<Personaje> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Personaje> participantes) {
		this.participantes = participantes;
	}
	
}
