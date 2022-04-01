package hilos;

public class CalculoPrimo extends Thread{
	
	private int numero;
	
	public CalculoPrimo(int numero) {
		super();
		this.numero = numero;
	}

	@Override
	public void run() {
        boolean esPrimo = true;
        
        for(int i=2;i<numero/2;i++) {
            if(numero%i==0) {
            	esPrimo = false;
            	break;
            }
        }
		
		System.out.println("El número " + numero + (esPrimo?" es primo":" no es primo"));
    }

}
