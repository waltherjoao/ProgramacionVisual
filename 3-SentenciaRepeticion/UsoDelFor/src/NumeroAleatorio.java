/*
 * Escribe un programa que muestre 20 notas generadas al azar. Las notas deben aparecer de la
 *     forma: suspenso, suficiente, bien, notable o sobresaliente. Al final aparecerá el número de
 *     suspensos, el número de suficientes, el número de bienes, etc.*/
public class NumeroAleatorio {
    public static void main(String[] args) throws Exception {
//0.9*5=4.5
        int notas;
        int suspenso = 0; //0
        int suficiente = 0;  //1
        int bien = 0;  //2
        int notable = 0;  //3
        int sobresaliente = 0;  //4
        //5+(4*2)
        for(int i= 0; i < 20; i++){
            notas = (int) (Math.random() * 5);
            switch(notas) {
                case 0:
                    System.out.println("Suspenso   ");
                    suspenso++;
                    break;
                case 1:
                    System.out.println("suficiente   ");
                    suficiente++;
                    break;
                case 2:
                    System.out.println("bien   ");
                    bien++;
                    break;
                case 3:
                    System.out.println("notable   ");
                    notable++;
                    break;
                case 4:
                    System.out.println("sobresaliente   ");
                    sobresaliente++;
                    break;
                default:
                    System.out.println("no cumple la condición   ");
            }
        }
        System.out.println("# de suspensos:  "+suspenso);
        System.out.println("# de suficientes:  "+suficiente);
        System.out.println("# de bien:  "+bien);
        System.out.println("# de notables:  "+notable);
        System.out.println("# de sobresaliente:  "+sobresaliente);
    }
}
