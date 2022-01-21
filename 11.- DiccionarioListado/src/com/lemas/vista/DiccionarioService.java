package com.lemas.vista;

import com.lemas.entidad.Palabra;

public class DiccionarioService {
	
	public Palabra guardarPalabra(Palabra palabra) {
		if(palabra.getPalabraEspaniol().isEmpty() && palabra.getPalabraIngles().isEmpty()) {
			return null;
		} else {
			return palabra;
		}
		
		
	}

}
