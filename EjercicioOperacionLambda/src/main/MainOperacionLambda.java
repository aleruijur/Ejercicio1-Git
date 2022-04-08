package main;

@FunctionalInterface 
interface InterfazOperacion <T>{
	public T operacion(T a, T b);
}

public class MainOperacionLambda {

	public static void main(String[] args) {
		
		// Para Tipo Integer
		Integer a = 2;
		Integer b = 3;
		
		InterfazOperacion<Integer> sumaInteger = (n1, n2) -> n1 + n2;
		Integer res = sumaInteger.operacion(a, b);
		System.out.println("Suma entera: " + res);
		
		InterfazOperacion<Integer> restaInteger = (n1, n2) -> n1 - n2;
		res = restaInteger.operacion(a, b);
		System.out.println("Resta entera: " + res);
		
		InterfazOperacion<Integer> multInteger = (n1, n2) -> n1 * n2;
		res = multInteger.operacion(a, b);
		System.out.println("Multiplicación entera: " + res);
		
		InterfazOperacion<Integer> divInteger = (n1, n2) -> n1 / n2;
		res = divInteger.operacion(a, b);
		System.out.println("División entera: " + res);
		
		InterfazOperacion<Integer> potInteger = (n1, n2) -> (int) Math.pow(n1.doubleValue(), n2.doubleValue());
		res = potInteger.operacion(a, b);
		System.out.println("Potencia entera: " + res);
		
		System.out.println();
		// Para Tipo Double
		Double c = 2.4;
		Double d = 3.8;
		
		InterfazOperacion<Double> sumaDouble = (n1, n2) -> n1 + n2;
		Double res2 = sumaDouble.operacion(c, d);
		System.out.println("Suma decimal: " + res2);
		
		InterfazOperacion<Double> restaDouble = (n1, n2) -> n1 - n2;
		res2 = restaDouble.operacion(c, d);
		System.out.println("Resta decimal: " + res2);
		
		InterfazOperacion<Double> multDouble = (n1, n2) -> n1 * n2;
		res2 = multDouble.operacion(c, d);
		System.out.println("Multiplicación decimal: " + res2);
		
		InterfazOperacion<Double> divDouble = (n1, n2) -> n1 / n2;
		res2 = divDouble.operacion(c, d);
		System.out.println("División decimal: " + res2);
		
		InterfazOperacion<Double> potDouble = (n1, n2) -> Math.pow(n1, n2);
		res2 = potDouble.operacion(c, d);
		System.out.println("Potencia decimal: " + res2);
	}

}