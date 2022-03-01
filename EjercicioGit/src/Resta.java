
public class Resta {
	
	static int acum = 0;
	
	public static int resta(int n, int m) {
		return n - m;
	}
	
	public static int restaAcum(int n) {
		acum -= n;
		return acum;
	}
	
}
