package com.lemas.poo;

import java.util.Scanner;

public class Clase3 {

	public static void main(String[] args) {
		Scanner entradaTeclado = new Scanner(System.in);
		System.out.println("Ingresar nombre:");
		String nombre = entradaTeclado.nextLine();
		System.out.println("Mi nombre es  "+nombre);
		System.out.println("Que edad tienes");
		int edad = entradaTeclado.nextInt();
		System.out.println(1+edad);
	}

}
