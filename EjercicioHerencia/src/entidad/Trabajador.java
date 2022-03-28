package entidad;

public class Trabajador extends Empleado{

	private Double valoracion;
	
	public Trabajador(String nombre, Double salarioBase, Double valoracion) {
		super(nombre, salarioBase);
		this.setValoracion(valoracion);
	}

	@Override
	public Double calcularSalarioFinal() {
		Double extra = 0.0;
		if(this.valoracion >= 5 && this.valoracion <7) {
			extra = 50.0;
		}else if(this.valoracion >= 7 && this.valoracion <9){
			extra = 100.0;
		}else if(this.valoracion >= 9){
			extra = 200.0;
		}
		
		return this.getSalarioBase() + extra;
	}

	public Double getValoracion() {
		return valoracion;
	}

	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Trabajador [nombre=" + this.getNombre() + ", salarioBase=" + this.getSalarioBase() + ", valoracion=" + valoracion + "]";
	}

}
