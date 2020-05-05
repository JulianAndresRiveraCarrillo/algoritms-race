package ui;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("INgrese un numero");
		
		int n = sc.nextInt();
		
		int resultado = 0;
		
		for (int i = 0; i < n; i++) {
			resultado = (int)(Math.random()*n+1);
			System.out.println(resultado);
		}
		
		
		
	}

}
