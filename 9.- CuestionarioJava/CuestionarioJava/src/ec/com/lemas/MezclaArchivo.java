package ec.com.lemas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Escribe un programa que guarde en un fichero el contenido de otros dos ficheros, de tal forma que en el
 *  fichero resultante aparezcan las líneas de los primeros dos ficheros mezcladas, es decir, 
 *  la primera línea será del primer fichero, la segunda será del segundo fichero, la tercera será la siguiente del primer fichero, etc. 

Los ficheros se encuentran adjuntos en el examen, el nombre del fichero que tiene la mezcla de los 2 
ficheros antes mencionados lo crearemos con el siguiente nombre RESULTADO_MEZCLA.dat.

Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas pueden tener tamaños diferentes.

Fichero 1
https://drive.google.com/file/d/1Vh8fLSgHK_7TN3YQWG2aMaPaHyIWEA32/view?usp=sharing

Fichero 2
https://drive.google.com/file/d/1O5Q8sHbgKIWpuRH7T6rooaZHJlCJZBwj/view?usp=sharing

 * @author walte
 *
 */
public class MezclaArchivo {

	public static void main(String[] args) {
		try {
			BufferedReader brPlaneta = new BufferedReader(new FileReader("planetas.txt"));
			BufferedReader brFruta = new BufferedReader(new FileReader("frutas.txt"));
			String lineaFruta = "";
			String lineaPlaneta = "";
			List<String> lstMezcla = new ArrayList<>();
			
			while((lineaFruta != null || lineaPlaneta != null)) {
				lineaFruta = brFruta.readLine();
				if(lineaFruta != null) {
					lstMezcla.add(lineaFruta);
				}
				
				lineaPlaneta = brPlaneta.readLine();
				if(lineaPlaneta != null) {
					lstMezcla.add(lineaPlaneta);
				}
			}
			
			brPlaneta.close();
			brFruta.close();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("RESULTADO_MEZCLA.dat"));
			for(String texto : lstMezcla) {
				bw.write(texto+"\n");
			}
			bw.close();
			System.out.println("Fin de ejecución");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
