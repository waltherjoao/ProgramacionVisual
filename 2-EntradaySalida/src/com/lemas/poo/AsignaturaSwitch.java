package com.lemas.poo;

import java.util.Scanner;

public class AsignaturaSwitch {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingresa el día por favor");
		String dia = teclado.nextLine();
		dia = dia.toLowerCase();
		switch (dia) {
			case "lunes":
			case "martes":
				System.out.println("Redes");
				break;
			case "miercoles":
				System.out.println("Base de datos");
				break;
			case "jueves":
				System.out.println("Programación");
				break;
			case "viernes":
				System.out.println("ingles");
				break;
			default:
				System.out.println("Error no puede determinar la busqueda");
		}
		System.out.println("--FIN DEL PROCESO--");
	}

}
