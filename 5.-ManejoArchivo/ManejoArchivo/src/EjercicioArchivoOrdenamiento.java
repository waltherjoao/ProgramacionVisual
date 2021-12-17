import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EjercicioArchivoOrdenamiento {
    /**
     * 4. Realiza un programa que sea capaz de ordenar alfabéticamente las palabras
     *    contenidas en un fichero de texto. El nombre del fichero que contiene las
     *    palabras se debe pasar como argumento en la línea de comandos. El nombre
     *    del fichero resultado debe ser el mismo que el original añadiendo la
     *    coletilla <code>sort</code>, por ejemplo <code>palabras_sort.txt</code>.
     *    Suponemos que cada palabra ocupa una línea.
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("nombre.txt"));
            String linea = "";
            List<String> nombresLst = new ArrayList<>();
            while(linea != null){
                linea = br.readLine();
                if(linea != null){
                    nombresLst.add(linea);
                }
            }
            br.close();
            //nombresLst.removeIf(Objects::isNull);
            Collections.sort(nombresLst);
            BufferedWriter bw = new BufferedWriter(new FileWriter("nombre_sort.txt"));
            for (String nombreOrdenado : nombresLst) {
                bw.write(nombreOrdenado+"\n");
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
