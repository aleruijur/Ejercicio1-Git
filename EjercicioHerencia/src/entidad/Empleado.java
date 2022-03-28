package entidad;

public abstract class Empleado {
	
	private String nombre;
	private Double salarioBase;
	
	public Empleado(String nombre, Double salarioBase) {
		this.nombre = nombre;
		this.salarioBase = salarioBase;
	}
	
	public abstract Double calcularSalarioFinal();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
}
