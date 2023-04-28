import java.util.ArrayList;
import java.util.Scanner;

public class Planta{
    Scanner inserir = new Scanner(System.in);
    private int id;
    private String nomePopular;
    private int idade;
    private Categoria categoria;
    private ArrayList<Cuidados> historicoDeCuidados = new ArrayList<>();
    
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
    
    public ArrayList<Cuidados> getHistoricoDeCuidados() {
        return historicoDeCuidados;
    }
    public void adicionarCuidado(Cuidados cuidados) {
        this.historicoDeCuidados.add(cuidados);
    }
    public void removerCuidado(Cuidados cuidados) {
        this.historicoDeCuidados.remove(cuidados);
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
            for(Cuidados cuidado: historicoDeCuidados){
                cuidado.listarCuidados();
            }
        }
    }

    public void mostrarUltimoCuidado(){
        if(historicoDeCuidados.isEmpty()) 
            System.out.println("Não possui registros de cuidados ainda. ");
        else
            historicoDeCuidados.get(historicoDeCuidados.size()-1).listarCuidados();
    }
}