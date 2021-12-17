import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EjercicioArchivos {
    /**
     * 1. Escribe un programa que guarde en un fichero con nombre 
     *    primos.dat los números primos que hay entre 1 y 500.
     * 
     * número primo.- Número entero que solamente es divisible por él mismo 
     * (positivo y negativo) y por la unidad (positiva y negativa).
     * @param args
     */
    public static void main(String[] args) {
        try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("primos.dat"));
            for(int i = 1; i <= 500; i++){
                if(esPrimo(i)){
                    bw.write(i+"\n");
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static boolean esPrimo(int valor){
        for(int i = 2; i < valor; i++){
            if((valor%i) == 0){
                return false;
            }
        }
        return true;
    }
}
