import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioLectura {
    /**
     * 2. Realiza un programa que lea el fichero creado en el ejercicio anterior y
     *    que muestre los números por pantalla.
     * @param args
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("primos.dat"));
            String linea = "";
            while(linea != null){
                linea = br.readLine();
                System.out.println(linea+"\n");
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException error){
            error.printStackTrace();
        }
        
    }
}
