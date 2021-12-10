import java.util.ArrayList;
import java.util.List;

public class Colecciones {
    public static void main(String[] args) throws Exception {
        
        List<Integer> numero = new ArrayList<>();
        numero.add(1);
        numero.add(2);
        numero.add(3);
        numero.add(4);
        numero.add(5);
        numero.add(7);
        System.out.println("Mostrar tamaño lista  "+numero.size());
        //Printear el valor que se encuentra en la posición #2
        System.out.println("El valor que se encuentra en la posición #2 "+numero.get(1));
        //Printear el valor que se encuentra en el indice del arreglo #2
        numero.set(2, 4534645);
        System.out.println("El valor que se encuentra en la posición #2 "+numero.get(2));
        System.out.print(numero);
        /*for (Integer numeroAntes : numero) {
            if(numeroAntes == 9)
                System.out.println("Si existe el número 2");
            else
                System.out.println("No existe el número");
        }*/
        boolean existeNumero = numero.contains(7);
        System.out.println("");
        if(existeNumero){
            System.out.println("Si existe el número  "+existeNumero);
        } else {
            System.out.println("No existe el número   "+existeNumero);
        }

        /*System.out.println("Expresiones lambda ");
        numero.forEach((final Integer numeroLamba) -> System.out.print(numeroLamba));

        numero.remove(numero.get(2));
        System.out.println("Despues de eliminar un valor de la lista");
        for (Integer numeroRefactorizado : numero) {
            System.out.print(numeroRefactorizado+",");
        }*/
    }
}
