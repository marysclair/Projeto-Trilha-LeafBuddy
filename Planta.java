import java.io.Serializable;
import java.util.ArrayList;

public class Planta implements Serializable{
    private int id;
    private String nomePopular;
    private int idade;
    private Categoria categoria;
    private boolean favorita;
    private ArrayList<Cuidado> historicoDeCuidados = new ArrayList<>();
    
    public Planta(int id, String nomePopular, int idade){
        setId(id);
        setNomePopular(nomePopular);
        setIdade(idade);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomePopular() {
        return nomePopular;
    }
    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }
    
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public boolean isFavorita() {
        return favorita;
    }
    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public ArrayList<Cuidado> getHistoricoDeCuidados() {
        return historicoDeCuidados;
    }
    public void adicionarCuidado(Cuidado cuidado) {
        this.historicoDeCuidados.add(cuidado);
    }
    public void removerCuidado(Cuidado cuidado) {
        this.historicoDeCuidados.remove(cuidado);
    }

    public void mostrarInformacoes(){
        System.out.println("-ID: " + this.id);
        System.out.println("-Nome: " + this.nomePopular);
        System.out.println("-Idade: " + this.idade);
        System.out.println("-Categoria: " + this.categoria.getNome());
    }

    public void mostrarCuidados(){
        if(historicoDeCuidados.isEmpty())
        System.out.println("Não possui registros de cuidados ainda. ");
        else{
            for(Cuidado cuidado: historicoDeCuidados){
                cuidado.listarCuidados();
                System.out.println();
            }
            if (historicoDeCuidados.get(historicoDeCuidados.size()-1) instanceof Rega) {
                Rega ultimaRega = (Rega) historicoDeCuidados.get(historicoDeCuidados.size()-1);
                FrequenciaRega frequenciaRega = new FrequenciaRega();
                frequenciaRega.eParaRegar(categoria, ultimaRega);   
            }
        }
    }

    public void mostrarUltimoCuidado(){
        if(historicoDeCuidados.isEmpty()) 
        System.out.println("Não possui registros de cuidados ainda. ");
        else{
            historicoDeCuidados.get(historicoDeCuidados.size()-1).listarCuidados();
            if (historicoDeCuidados.get(historicoDeCuidados.size()-1) instanceof Rega) {
                Rega ultimaRega = (Rega) historicoDeCuidados.get(historicoDeCuidados.size()-1);
                FrequenciaRega frequenciaRega = new FrequenciaRega();
                frequenciaRega.eParaRegar(categoria, ultimaRega);   
            }
        }
    }
}