import java.io.Serializable;
// import java.util.ArrayList;

public abstract class Categoria implements Serializable{
    private String nome;
    
    private String luminosidadeIdeal;
    private String soloIdeal;
    private String climaIdeal;
    private int diasRega;
    private String adubo;

    
    public Categoria(String nome, String luminosidadeIdeal, String soloIdeal, String climaIdeal, String adubo) {
        setNome(nome);
        setLuminosidadeIdeal(luminosidadeIdeal);
        setSoloIdeal(soloIdeal);
        setClimaIdeal(climaIdeal);
        setAdubo(adubo);
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getLuminosidadeIdeal() {
        return luminosidadeIdeal;
    }
    public void setLuminosidadeIdeal(String luminosidadeIdeal) {
        this.luminosidadeIdeal = luminosidadeIdeal;
    }
    
    public String getSoloIdeal() {
        return soloIdeal;
    }
    public void setSoloIdeal(String soloIdeal) {
        this.soloIdeal = soloIdeal;
    }
    
    public String getClimaIdeal() {
        return climaIdeal;
    }
    public void setClimaIdeal(String climaIdeal) {
        this.climaIdeal = climaIdeal;
    }

    public int getDiasRega() {
        return diasRega;
    }
    public void setDiasRega(int diasRega) {
        this.diasRega = diasRega;
    }

    public String getAdubo() {
        return adubo;
    }
    public void setAdubo(String adubo) {
        this.adubo = adubo;
    }
    public void listarInformacoes(){
        System.out.println("-Nome: " + this.nome);
        System.out.println("-Solo ideal: " + this.soloIdeal);
        System.out.println("-Luminosidade ideal: " + this.luminosidadeIdeal);
        System.out.println("-Clima ideal: " + this.climaIdeal);
        System.out.println("-Frequência da rega: " + this.diasRega);
        System.out.println("-Adubo indicado: " + this.adubo);
    }
    
    public abstract int calcularFrequenciaRega();
    
}
