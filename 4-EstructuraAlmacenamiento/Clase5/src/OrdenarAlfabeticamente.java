import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Realiza un programa que reciba por teclado apellidos
 * ordenarlos alfabeticamente.
 * 
 * Perez, Rodriguez, Garcia, Alvarado
 * 
 * Alvarado, Garcia, Perez, Rodriguez
 */
public class OrdenarAlfabeticamente {


    public static void main(String[] args) throws Exception {
        int salir = 0;
        String opcion = null;
        System.out.println(opcion);
        List<String> lstResultado = new ArrayList<>();
        do{
            Scanner teclas = new Scanner(System.in);
            System.out.println("Que desea hacer:");
            System.out.println("1. Ingresar Apellidos");
            System.out.println("2. Mostrar listado ordenado alfabeticamente");
            opcion = teclas.nextLine();
            switch(opcion){
                case "1":
                    String texto = leerPorTeclado();
                    lstResultado.add(texto);
                    break;
                case "2":
                    System.out.println(lstResultado);
                    Collections.sort(lstResultado);
                    System.out.println(lstResultado);
                    Collections.sort(lstResultado, Collections.reverseOrder());
                    System.out.println(lstResultado);
                    //mostrarListado();
                    salir = 1;
                    break;
                default:
                    System.out.println("Opción incorrecta!!!!! digite nuevamente, por favor!");
            }
        } while(salir == 0);

    }

    private static String leerPorTeclado() {
        System.out.println("Ingresa el apellido");
        Scanner teclaApellido = new Scanner(System.in);
        return teclaApellido.nextLine();
    }
}
