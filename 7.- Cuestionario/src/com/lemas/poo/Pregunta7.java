package com.lemas.poo;

public class Pregunta7 {

	public static void main(String[] args) {
		Mamifero h = new Caballo();
		Ganado c= new Caballo();
		c.comer(h);
	}

}

class Mamifero{
	void comer(Mamifero m) {
		System.out.println("Mamifero come comida");
	}
}

class Ganado extends Mamifero{
	void comer  (Ganado c) {
		System.out.println("Ganado come heno");
	}
}

class Caballo extends Ganado{
	void comer(Caballo h) {
		System.out.println("Caballo come heno");
	}
}
