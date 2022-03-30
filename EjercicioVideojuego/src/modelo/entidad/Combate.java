package modelo.entidad;

import modelo.entidad.personaje.Personaje;

public class Combate {

	private Personaje combatiente1;
	private Personaje combatiente2;
	
	public Combate(Personaje combatiente1, Personaje combatiente2) {
		super();
		this.combatiente1 = combatiente1;
		this.combatiente2 = combatiente2;
	}
	
	public Personaje batalla() {
		int numTurno = 1;
		while(combatiente1.getVida()>0 && combatiente2.getVida()>0) {
			System.out.println("Turno " + numTurno);
			combatiente1.atacar(combatiente2);
			if(combatiente2.getVida()<=0) break;
			combatiente2.atacar(combatiente1);
			numTurno++;
		}
		
		if(combatiente1.getVida()<=0) {
			System.out.println("El " + combatiente2 + " ha ganado!");
			return combatiente2;
		}else {
			System.out.println("El " + combatiente1 + " ha ganado!");
			return combatiente1;
		}
		
	}
	
	public Personaje getCombatiente1() {
		return combatiente1;
	}
	public void setCombatiente1(Personaje combatiente1) {
		this.combatiente1 = combatiente1;
	}
	public Personaje getCombatiente2() {
		return combatiente2;
	}
	public void setCombatiente2(Personaje combatiente2) {
		this.combatiente2 = combatiente2;
	}
}
