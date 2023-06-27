package src.cuidados;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Cuidado implements Serializable{
    private LocalDate data;
    private String descricao;
    
    public Cuidado(String data, String descricao){
        setData(data);
        setDescricao(descricao);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(String data) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataUltimaReDate = LocalDate.parse(data, formatter);
            this.data = dataUltimaReDate;
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida");
          }
    }
    
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if(descricao.isEmpty()) this.descricao = "Usuário não preencheu";
        else this.descricao = descricao;
    }
   
    public abstract void listarCuidados();
}
