package src.cuidados;

public class Adubacao extends Cuidado {
    private String adubo;
    
    public Adubacao(String data, String adubo, String descricao){
        super(data, descricao);
        setAdubo(adubo);
    }

    public String getAdubo() {
        return adubo;
    }

    public void setAdubo(String adubo) {
        this.adubo = adubo;
    }

    @Override
    public void listarCuidados(){
        System.out.println("-Data da última adubação: " + getData());
        System.out.println("-Adubo utilizado: " + getAdubo());
        System.out.println("-Descrição: " + getDescricao());
    }
}
