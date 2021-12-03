import java.util.Scanner;

/*8. Muestra la tabla de multiplicar hasta el 12 de un número introducido por teclado.*/

public class TablaMultiplicar {

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el número");
        int numero = teclado.nextInt();

        for(int inc = 0; inc <= 12; inc++){
            int producto = numero * inc;
            System.out.println(numero+" * "+inc+" = "+producto);
        }
    }
    
}
