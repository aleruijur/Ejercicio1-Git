
public class Suma {
	
	static int acum = 0;
	
	public static int suma(int n, int m) {
		return n + m;
	}
	
	public static int sumaAcum(int n) {
		acum += n;
		return acum;
	}
	
}
