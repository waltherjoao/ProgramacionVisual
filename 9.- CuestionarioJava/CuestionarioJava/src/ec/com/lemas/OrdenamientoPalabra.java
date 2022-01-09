package ec.com.lemas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Realiza un programa que sea capaz de ordenar alfabéticamente las palabras contenidas en un 
 * fichero de texto palabras.txt. El nombre del fichero resultado debe ser el mismo que el original 
 * añadiendo la coletilla _ordenada, por ejemplo palabras_ordenada.txt. 
 * Suponemos que cada palabra ocupa una línea
 *
 * @author Lemas
 */

public class OrdenamientoPalabra {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("E://ArchivoJava//palabras.txt"));
			String linea = "";
			List<String> lstFichero = new ArrayList<>();
			while(linea != null){
                linea = br.readLine();
                if(linea != null) {
                	lstFichero.add(linea);
                }
            }
			br.close();
			Collections.sort(lstFichero);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("palabras_ordenada.dat"));
			for(String nombre : lstFichero) {
				bw.write(nombre+"\n");
			}
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
