package test;

import java.util.Scanner;

import hilos.CalculoPrimo;

public class MainHilos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce 3 números:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		CalculoPrimo c1 = new CalculoPrimo(a);
		CalculoPrimo c2 = new CalculoPrimo(b);
		CalculoPrimo c3 = new CalculoPrimo(c);
		
		c1.start();
		c2.start();
		c3.start();
	}

}
