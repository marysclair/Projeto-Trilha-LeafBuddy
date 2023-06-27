package src.cuidados;

public class Rega extends Cuidado {

    public Rega(String data, String descricao){
        super(data, descricao);
    }

    @Override
    public void listarCuidados(){
        System.out.println("-Data da última rega: " + getData());
        System.out.println("-Descrição: " + getDescricao());
    }
}
