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
		System.out.println("___ Inicio del combate entre " + combatiente1 + " y " + combatiente2 + " ___");
		int numTurno = 1;
		
		//El combatiente con mayor velocidad será el que ataque primero en cada turno
		if(combatiente2.getVelocidad()>combatiente1.getVelocidad()) {
			Personaje temporal = combatiente1;
			combatiente1 = combatiente2;
			combatiente2 = temporal;
		}
		
		while(combatiente1.getVida()>0 && combatiente2.getVida()>0) {
			System.out.println("-- Turno " + numTurno + ": " + combatiente1 + " PV = " + combatiente1.getVida() 
				+ " | " + combatiente2 + " PV = " +  + combatiente2.getVida() + " --");
			combatiente1.atacar(combatiente2);
			if(combatiente2.getVida()<=0) break;
			combatiente2.atacar(combatiente1);
			numTurno++;
		}
		
		if(combatiente1.getVida()<=0) {
			System.out.println("<<<El " + combatiente2 + " ha ganado!>>>");
			System.out.println();
			return combatiente2;
		}else {
			System.out.println("<<<El " + combatiente1 + " ha ganado!>>>");
			System.out.println();
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
