package com.lemas.poo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ctrl+shift+o
public class Clase4 {

	String valor = "joao";
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		System.out.println("Cual es tu apellido");
		try {
			String apellido = br.readLine();
			
			int a = 3/0;
			
			if(apellido.isEmpty()) {
				System.out.println("El apellido no puede ser vacio");
			} else if(apellido.contains("ai")) {
				System.out.println("El apellido contiene la letra ai");
			} 
			else {
				System.out.println("Mi apellido es "+apellido.toUpperCase()+" min  "+apellido.toLowerCase()+
													" - "+apellido.substring(1, 3).toUpperCase().concat("-GYE"));
				
				System.out.println(apellido.substring(1, 3).toUpperCase()+"-GYE");
			}
			
			if(apellido.equals("gaibor")) {
				System.out.println("Si es el apellido esperado");
			}
			
			if(apellido.equalsIgnoreCase("gaibor")) {
				System.out.println("Si es el apellido esperado sin validar may/min");
			}
			
			if(apellido.endsWith("o")) {
				System.out.println("El apellido comienza con O");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Entro por aquí");
			e.printStackTrace();
		}
	}

}
