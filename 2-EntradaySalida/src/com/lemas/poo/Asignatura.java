package com.lemas.poo;

import java.util.Scanner;

public class Asignatura {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingresa el día por favor");

		String dia = teclado.nextLine();
		if(dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes")) 
			System.out.println("Redes");
		 else if(dia.equalsIgnoreCase("miercoles")) 
			System.out.println("Base de datos");
		 else if(dia.equalsIgnoreCase("jueves")) 
			System.out.println("Programación");
		 else if(dia.equalsIgnoreCase("viernes")) 
			System.out.println("ingles");
		 else 
			System.out.println("Error no puede determinar la busqueda");
		
	}

}
