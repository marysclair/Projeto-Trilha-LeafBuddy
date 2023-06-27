package src;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import src.categorias.Categoria;
import src.categorias.FrequenciaRega;
import src.cuidados.Cuidado;
import src.cuidados.Rega;

public class Planta implements Serializable{
    private int id;
    private String nomePopular;
    private LocalDate data;
    private Categoria categoria;
    private boolean favorita;
    private boolean regada;
    private ArrayList<Cuidado> historicoDeCuidados = new ArrayList<>();
    
    public Planta(int id, String nomePopular, String data){
        setId(id);
        setNomePopular(nomePopular);
        setData(data);
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
    
    public LocalDate getData() {
        return data;
    }
    
    public void setData(String data) {
        if (!data.isEmpty()) {       
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataUltimaReDate = LocalDate.parse(data, formatter);
                this.data = dataUltimaReDate;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida");
            }
        }
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
        Collections.sort(this.historicoDeCuidados, Comparator.comparing(Cuidado::getData));
    }
    public void removerCuidado(Cuidado cuidado) {
        this.historicoDeCuidados.remove(cuidado);
    }

    public int getIdade(){
        Period periodo = Period.between(getData(), LocalDate.now());
        int idadeMeses = periodo.getYears() * 12 + periodo.getMonths();
        return idadeMeses;
    }

    public boolean isRegada() {
        return regada;
    }

    public void setRegada(boolean regada) {
        this.regada = regada;
    }
    
    public void mostrarInformacoes(){
        System.out.println("-ID: " + this.id);
        System.out.println("-Nome: " + this.nomePopular);
        System.out.println("-Idade: " + getIdade() + " meses");
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
                setRegada(FrequenciaRega.eParaRegar(categoria, ultimaRega)); 
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
                setRegada(FrequenciaRega.eParaRegar(categoria, ultimaRega)); 
            }
        }
    }
}