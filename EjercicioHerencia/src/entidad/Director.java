package entidad;

import java.util.HashSet;
import java.util.Set;

public class Director extends Empleado{

	private Set<Empleado> empleados;
	
	public Director(String nombre, Double salarioBase) {
		super(nombre, salarioBase);
		this.empleados = new HashSet<>();
	}

	@Override
	public Double calcularSalarioFinal() {
		return this.getSalarioBase() + this.empleados.size()*100;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void añadirEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}

	@Override
	public String toString() {
		return "Director [nombre=" + this.getNombre() + ", salarioBase=" + this.getSalarioBase() + ", empleados=" + empleados + "]";
	}
	
}
