package main;

import java.util.Scanner;

public class MainLambda {

	public static void main(String[] args) {
		System.out.println("Introduce 3 números:");
		
		Runnable hilo = () -> {
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			
			boolean esPrimo = true;
        
	        for(int i=2;i<a/2;i++) {
	            if(a%i==0) {
	            	esPrimo = false;
	            	break;
	            }
	        }
		
	        System.out.println("El número " + a + (esPrimo?" es primo":" no es primo"));
	     };

		for(int i = 0; i < 3; i++) {
			Thread t = new Thread(hilo);
			t.start();
		}
	}

}
