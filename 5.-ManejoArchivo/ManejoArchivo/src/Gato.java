public class Gato {
    private String color;
    private String raza;
    private String sexo;

    public Gato(String _sexo){
        this.sexo = _sexo;
    }

    public void maulla(){
        System.out.println("miau...");
    }

    public void aparearse(Gato pareja) throws ExcepcionApariamiento{
        if(this.sexo.equals(pareja.sexo)){
            throw new ExcepcionApariamiento();
        }
        System.out.println("Si se puede aparear");
    }
}
