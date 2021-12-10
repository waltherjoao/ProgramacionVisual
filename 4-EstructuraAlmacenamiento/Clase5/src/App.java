

public class App {
    public static void main(String[] args) throws Exception {
        //int[] numero = {1,2,3};

        int[] numero = new int[5];
        numero[0] = 1;
        numero[1] = 2;
        numero[2] = 3;
        numero[3] = 9;
        numero[4] = 8;

        System.out.println(numero.length);
        //Printear el valor que se encuentra en la posición #2
        System.out.println("El valor que se encuentra en la posición #2 "+numero[1]);
        //Printear el valor que se encuentra en el indice del arreglo #2
        numero[2] = 34657;
        System.out.println("El valor que se encuentra en el indice #2 "+numero[2]);
        System.out.print("[");
        for(int i = 0; i < numero.length; i++){
            System.out.print(numero[i]+",");
        }
        System.out.print("]");
    }
}
