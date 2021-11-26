package com.lema.primeraclase;

/*
 * Clase Principal
 *
 * @author: Walther Joao Gaibor <mailto:wgaibor@teclemas.edu.ec>
 * @version 1.0
 * @since 11/11/2021
 */
 
public class HolaMundo {
	
	String nombre = "Joao";
	int cantidad = 2;

	/*
	 * Método principal o de arranque de un programa java.
	 *
	 * @author: Walther Joao Gaibor <mailto:wgaibor@teclemas.edu.ec>
	 * @version 1.0
	 * @since 11/11/2021
	 */
	public static void main(final String[] args) {
		// Variable de tipo String que se emplea para la salida por la consola.
		// nombre = "Joao";
		// Salida por consola
		// System.out.println("Hola mundo "+nombre);
		System.out.println("bienvenido");
		final Suma walther = new Suma(2, 7);
		final Suma joao = new Suma(5, 9);
		final Suma objeto2 = new Suma(8, -3);
		final Suma eduardo = new Suma();
		final Suma gabriel = new Suma(47);
		System.out.println("Objeto Eduardo " + eduardo.suma());
		System.out.println("Objeto Gabriel " + gabriel.suma());
		final Resta walther1 = new Resta();
		System.out.println("La suma del objeto walther es   " + walther.suma());
		System.out.println("La suma del objeto joao es   " + joao.suma());
		// joao.valorConstante();
		System.out.println(
				"El resultado de la operación es" + (walther.resultado() * joao.resultado() - walther1.resultado()));

		final Double valor = 2.99999999999;
		int cantidad = 6;
		final Long cantidadMayor = 5L;
		final String producto = "cámara";
		final boolean isExiste = true;
		cantidad %= 2;
		System.out.println("Cantidad mayor " + cantidad);

		System.out.println("Esto es \n un salto \n de línea");
	}

	int sumaPrueba() {
		return 5;
	}

	public static int suma() {
		final String apellido = "gaibor";
		return 1 + 1;
	}
	
	public void pruebasConstante() {
		cantidad = 5;
		nombre = "Walher";
	}


}
