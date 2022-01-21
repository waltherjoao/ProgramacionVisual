package ec.com.lemas;

import java.util.HashMap;
import java.util.Scanner;

public class Examen2 {

	public static void main(String[] args) {

		boolean ingreso = true;

		HashMap<String, String> mapDiccionario = new HashMap<>();

		mapDiccionario.put("ordenador", "computer");

		mapDiccionario.put("gato", "cat");

		mapDiccionario.put("rojo", "red");

		mapDiccionario.put("árbol", "tree");

		mapDiccionario.put("pingüino", "penguin");

		mapDiccionario.put("sol", "sun");

		mapDiccionario.put("agua", "water");

		mapDiccionario.put("viento", "wind");

		mapDiccionario.put("siesta", "siesta");

		mapDiccionario.put("arriba", "up");

		mapDiccionario.put("ratón", "mouse");

		mapDiccionario.put("estadio", "arena");

		mapDiccionario.put("calumnia", "aspersion");

		mapDiccionario.put("aguacate", "avocado");

		mapDiccionario.put("cuerpo", "body");

		mapDiccionario.put("concurso", "contest");

		mapDiccionario.put("cena", "dinner");

		mapDiccionario.put("salida", "exit");

		mapDiccionario.put("lenteja", "lentil");

		mapDiccionario.put("cacerola", "pan");

		mapDiccionario.put("pastel", "pie");

		mapDiccionario.put("membrillo", "quince");

		System.out.println("Diccionario ESP-ING ");

		do {

			System.out.println("Ingrese palabra : ");

			Scanner Palabra = new Scanner(System.in);

			String palabra = Palabra.nextLine();

			if (mapDiccionario.containsKey(palabra)) {

				System.out.println("Translation is: " + mapDiccionario.get(palabra));

				System.out.println("Desea consultar otra palabra? S/N");

				Scanner SiNo = new Scanner(System.in);

				char opcion = SiNo.next().charAt(0);

				if (Character.toUpperCase(opcion) == 'N')

					ingreso = false;

			}

		} while (ingreso);

	}

}