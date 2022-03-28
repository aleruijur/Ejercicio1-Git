package entidad;

public class Jefe extends Empleado{

	private Double incentivos;
	
	public Jefe(String nombre, Double salarioBase, Double incentivos) {
		super(nombre, salarioBase);
		this.incentivos = incentivos;
	}

	@Override
	public Double calcularSalarioFinal() {
		return this.getSalarioBase() + this.incentivos;
	}

	public Double getIncentivos() {
		return incentivos;
	}

	public void setIncentivos(Double incentivos) {
		this.incentivos = incentivos;
	}

	@Override
	public String toString() {
		return "Jefe [nombre=" + this.getNombre() + ", salarioBase=" + this.getSalarioBase() + ", incentivos=" + incentivos + "]";
	}
	
}
