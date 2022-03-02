
public class main {

	public static void main(String[] args) {

		System.out.println("Pruebas de las clases suma y resta:");
		
		int res1 = Suma.suma(2, 3);
		System.out.println(res1);
		int res2 = Suma.sumaAcum(3);
		System.out.println(res2);
		int res3 = Suma.sumaAcum(2);
		System.out.println(res3);
		
		int res4 = Resta.resta(4, 1);
		System.out.println(res4);
		int res5 = Resta.restaAcum(3);
		System.out.println(res5);
		int res6 = Resta.restaAcum(-5);
		System.out.println(res6);
	}

}
