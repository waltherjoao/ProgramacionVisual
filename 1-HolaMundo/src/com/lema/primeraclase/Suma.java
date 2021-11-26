package com.lema.primeraclase;

public class Suma {
	
	int valor1;
	int valor2;
	int valor3;

	public Suma(int numero1, int numero2) {
		this.valor1 = numero1;
		this.valor2 = numero2;
		this.valor3 = 9;
	}
	
	public Suma() {
		this.valor3 = 9;
	}
	
	public Suma(int parametro1) {
		this.valor2 = parametro1;
	}

	public int resultado() {
		valorConstante();
		return HolaMundo.suma();
	}
	
	public int suma() {
		return valor1+valor2+valor3;
	}
	
	private int valorConstante() {
		return 2;
	}
}
