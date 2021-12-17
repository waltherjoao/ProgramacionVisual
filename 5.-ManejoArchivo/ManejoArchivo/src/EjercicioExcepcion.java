/** 
 * Determinar si un animal puede reproducirse
 * Condicion para reproducirse deben ser de diferente sexo, en el caso de ser del mismo sexo
 * se debe propagar una excepción personalizada.
 */

public class EjercicioExcepcion {
    public static void main(String[] args) {
        try{
            Gato garfield = new Gato("macho");
            Gato silvestre = new Gato("macho");
            Gato gertudris = new Gato("hembra");
            gertudris.maulla();
            //garfield.aparearse(silvestre);
            silvestre.aparearse(gertudris);
        } catch (ExcepcionApariamiento error){
            System.out.println(error.getMessage());
        }
    }
}
