package test;

import java.util.ArrayList;
import java.util.List;

import entidad.Director;
import entidad.Empleado;
import entidad.Jefe;
import entidad.Trabajador;

public class MainEmpleado {

	public static void main(String[] args) {
		
		List<Empleado> empleados = new ArrayList<>();
		
		Trabajador trab1 = new Trabajador("Alejandro",900.0,9.0);
		Trabajador trab2 = new Trabajador("Migue",1300.0,7.5);
		Trabajador trab3 = new Trabajador("Antonio",1500.0,4.0);
		
		Jefe jef1 = new Jefe("Javier",2000.0,700.0);
		Jefe jef2 = new Jefe("Pedro",2200.0,300.0);
		
		Director dir1 = new Director("Vicente",3000.0);
		
		dir1.añadirEmpleado(trab1);
		dir1.añadirEmpleado(trab2);
		dir1.añadirEmpleado(jef1);
		
		empleados.add(trab1);
		empleados.add(trab2);
		empleados.add(trab3);
		empleados.add(jef1);
		empleados.add(jef2);
		empleados.add(dir1);
		
		System.out.println(empleados);
		
		for(Empleado empleado: empleados) {
			System.out.println("El salario final de " + empleado.getNombre() + " es : " + empleado.calcularSalarioFinal());
		}
	}

}
