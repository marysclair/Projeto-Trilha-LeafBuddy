import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Cuidados implements Serializable{
    private LocalDate dataUltimaRega;
    private LocalDate dataUltimaAdubacao;
    private String descricao;
    private File foto;
    
    public LocalDate getDataUltimaRega() {
        return dataUltimaRega;
    }
    public void setDataUltimaRega(String dataUltimaRega) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataUltimaReDate = LocalDate.parse(dataUltimaRega, formatter);
            this.dataUltimaRega = dataUltimaReDate;
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida");
          }
    }
    
    public LocalDate getDataUltimaAdubacao() {
        return dataUltimaAdubacao;
    }

    public void setDataUltimaAdubacao(String dataUltimaAdubacao) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataUltimaAdDate = LocalDate.parse(dataUltimaAdubacao, formatter);
            this.dataUltimaAdubacao = dataUltimaAdDate;
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida");
        }
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if(descricao==null) this.descricao = "Usuário não preencheu";
        else this.descricao = descricao;
    }

    public File getFoto() {
        return foto;
    }
    public void setFoto(File foto) {
        this.foto = foto;
    }
    
    void listarCuidados(){
        System.out.println("-Data da última adubação: " + this.dataUltimaAdubacao);
        System.out.println("-Data da última rega: " + this.dataUltimaRega);
        System.out.println("-Descrição: " + this.descricao);
    }
}
