import java.util.Scanner;

/*
 * Escribe un programa que diga si un número introducido por teclado
 *     es o no primo. Un número primo es aquel que sólo es divisible entre
 *     él mismo y la unidad.*/
public class NumeroPrimo {
    //1,2,3,5,7,11,13,17
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el número");
        String caracter = teclado.nextLine();

        while(!caracter.matches("[0-9]*")){
            System.out.println("Ingrese un número, no un caracter por favor....");
            caracter = teclado.nextLine();
        }
        int numero = Integer.valueOf(caracter);
        boolean esPrimo = true;
       // i = i+1;
        for(int i= 2; i < numero; i++){
            if((numero% i)== 0){
                esPrimo = false;
            }
        }

        if(esPrimo){
            System.out.println("El número introducido es primo.");
        } else {
            System.out.println("El número introducido NO es primo.");
        }
    }
}
