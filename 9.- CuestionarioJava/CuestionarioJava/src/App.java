import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Implementa el control de acceso al área restringida de un programa. 
 * Se debe pedir un nombre de usuario y una contraseña.
 *  Si el usuario introduce los datos correctamente, 
 * el programa dirá "Ha accedido al área restringida". 
 * El usuario tendrá un máximo de 3 oportunidades. 
 * Si se agotan las oportunidades el programa dirá "Lo siento, no tiene acceso al área restringida". 
 * Los nombres de usuario con sus correspondientes contraseñas deben estar almacenados en una estructura de la clase HasMap. 
 * para ello existiran los siguientes usuarios:

"admin"   ===> "224477"
"maria"   ===> "ztf99"
"pepe"    ===> "zxcvb"

 */
public class App {

    public static void main(String[] args) throws Exception {
        

        boolean ingresa = false;
        int oportunidades = 3;

        HashMap<String, String> mapearLogin = new HashMap<>();

        mapearLogin.put("admin", "224477");
        mapearLogin.put("maria", "ztf99");
        mapearLogin.put("pepe", "zxcvb");

        System.out.println("Por favor, introduzca nombre de usuario y "
          + "contraseña para acceder al área restringida.\nDispone de "
          + "3 intentos.");

          do{
            System.out.println("usuario:");
            Scanner teclas = new Scanner(System.in);
            String usuario = teclas.nextLine();
            System.out.println("contraseña:");
            Scanner teclasContra = new Scanner(System.in);
            String contrasenia = teclasContra.nextLine();

            if(mapearLogin.containsKey(usuario)){
                if(mapearLogin.get(usuario).equalsIgnoreCase(contrasenia)){
                    System.out.println("Ha accedido al área restringida");
                    ingresa = true;
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            } else {
                System.out.println("El usuario ingresado no existe");
            }

            oportunidades--;
            if(!ingresa){
                System.out.println("Le quedan " + (oportunidades) + " oportunidades");
            }
            
          } while((!ingresa) && (oportunidades > 0));

          if(!ingresa){
              System.out.println("Lo siento, no tiene acceso al área restringida");
          }
    }
}
