package vista;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class MainCoche {

	public static void main(String[] args) {
		System.out.println("Bienvenidos a nuestra aplicación de coches con BBDD");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestorCoche gc = new GestorCoche();
		
		do {
			menu();
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Introduzca los datos del coche (matricula/marca/modelo/kilometros)");
				String matricula = sc.next();
				String marca = sc.next();
				String modelo = sc.next();
				Double kilometros = sc.nextDouble();
				Coche c = new Coche();
				c.setMatricula(matricula);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKilometros(kilometros);
				
				int alta = gc.alta(c);
				if(alta == 0) {
					System.out.println("Coche dado de alta");
				}else if(alta == 1) {
					System.out.println("Error de conexión con la BBDD");
				}else if(alta == 2){
					System.out.println("La matrícula debe tener 7 caracteres");
				}else if(alta == 3){
					System.out.println("La matrícula ya existe");
				}else if(alta == 4){
					System.out.println("Los kilómetros no pueden ser negativos");
				}
				break;
			case 2:
				System.out.println("Introduzca el id");
				
				boolean baja = gc.baja(sc.nextInt());
				if(baja) {
					System.out.println("Coche eliminado");
				}else if(baja) {
					System.out.println("Error de conexión con la BBDD");
				}
				break;
			case 3:
				System.out.println("Introduzca el id");
				
				c = gc.buscarPorID(sc.nextInt());
				if(c==null) {
					System.out.println("No se encuentra el coche");
					break;
				}
				
				System.out.println("Introduzca los datos a modificar (matricula/marca/modelo/kilometros)");
				matricula = sc.next();
				marca = sc.next();
				modelo = sc.next();
				kilometros = sc.nextDouble();
			
				c.setMatricula(matricula);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKilometros(kilometros);
				
				int modificar = gc.modificar(c);
				if(modificar == 0) {
					System.out.println("Coche modificado");
				}else if(modificar == 1) {
					System.out.println("Error de conexión con la BBDD");
				}else if(modificar == 2){
					System.out.println("La matrícula debe tener 7 caracteres");
				}else if(modificar == 3){
					System.out.println("La matrícula ya existe");
				}else if(modificar == 4){
					System.out.println("Los kilómetros no pueden ser negativos");
				}
				break;
			case 4:
				System.out.println("Introduzca el id");
				
				c = gc.buscarPorID(sc.nextInt());
				if(c!=null) {
					System.out.println(c);
				}else{
					System.out.println("No se encuentra el coche");
				}
				break;
			case 5:
				System.out.println("Introduzca la matrícula");
				
				c = gc.buscarPorMatricula(sc.next());
				if(c!=null) {
					System.out.println(c);
				}else{
					System.out.println("No se encuentra el coche");
				}
				break;
			case 6:
				System.out.println("Introduzca la marca");
				
				List<Coche> cs = gc.buscarPorMarca(sc.next());
				if(cs.size() > 0) {
					System.out.println(cs);
				}else{
					System.out.println("No se encuentra ningún coche");
				}
				break;
			case 7:
				System.out.println("Introduzca el modelo");
				
				cs =  gc.buscarPorModelo(sc.next());
				if(cs.size() > 0) {
					System.out.println(cs);
				}else{
					System.out.println("No se encuentra ningún coche");
				}
				break;
			case 8:
				cs =  gc.listar();
				if(cs.size() > 0) {
					System.out.println(cs);
				}else{
					System.out.println("No se encuentra ningún coche");
				}
				break;
			case 0:
				fin = true;
				break;
			}
		}while(!fin);
		
		System.out.println("Fin de programa");

	}

	private static void menu() {
		System.out.println("Elija una opción:");
		System.out.println("1- Alta de coche");
		System.out.println("2- Eliminar coche");
		System.out.println("3- Modificar coche");
		System.out.println("4- Buscar coche por id");
		System.out.println("5- Buscar coche por matricula");
		System.out.println("6- Buscar coches por marca");
		System.out.println("7- Buscar coches por modelo");
		System.out.println("8- Listar coches");
		System.out.println("0- Salir del programa");
	}

}
