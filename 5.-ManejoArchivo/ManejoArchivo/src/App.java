public class App {
    public static void main(String[] args) {
        //texto   tex
        
        try {
            if(true){
                throw new Exception("Provoque el error");
            }
            int _resultado = sumar(5,20);
            System.out.println("La suma es   "+_resultado);
            //int resultado = 1/0;
            String texto = null;
            texto.substring(0, 3);
            System.out.println("Fin de ejecución");
            
        } catch (ArithmeticException aritmetico){
            System.out.println("Problemas de división   [Causa]   "+aritmetico.getMessage());
        } catch(NullPointerException palabras){
            System.out.println("PROBLEMAS DE TEXTO NULO    [Causa]   "+palabras.getMessage());
        } catch (Exception error) {
            System.out.println("Existe un error general   [Causa]   "+error.getMessage());
        } finally {
            System.out.println("--TERMINO LA EJECUCIÓN--");
        }
        
    }

    public static int sumar(int valor1, int valor2){
        return valor1+valor2;
    }
}
