import java.io.File;
import java.time.LocalDate;

public class Cuidados {
    private LocalDate dataUltimaRega;
    private LocalDate dataUltimaAdubacao;
    private String descricao;
    private File foto;
    
    public LocalDate getDataUltimaRega() {
        return dataUltimaRega;
    }
    public void setDataUltimaRega(LocalDate dataUltimaRega) {
        this.dataUltimaRega = dataUltimaRega;
    }
    
    public LocalDate getDataUltimaAdubacao() {
        return dataUltimaAdubacao;
    }
    public void setDataUltimaAdubacao(LocalDate dataUltimaAdubacao) {
        this.dataUltimaAdubacao = dataUltimaAdubacao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public File getFoto() {
        return foto;
    }
    public void setFoto(File foto) {
        this.foto = foto;
    }
    
    void listarCuidados(){
        System.out.println("-Data da última adubação: " + this.dataUltimaAdubacao);
        System.out.println("-Data da última rega: " + this.dataUltimaAdubacao);
        System.out.println("-Descrição: " + this.dataUltimaAdubacao);
    }
}
