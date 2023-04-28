import java.io.File;
// import java.time.LocalDate;

public class Cuidados {
    private String dataUltimaRega;
    private String dataUltimaAdubacao;
    private String descricao;
    private File foto;
    
    public String getDataUltimaRega() {
        return dataUltimaRega;
    }
    public void setDataUltimaRega(String dataUltimaRega) {
        this.dataUltimaRega = dataUltimaRega;
    }
    
    public String getDataUltimaAdubacao() {
        return dataUltimaAdubacao;
    }
    public void setDataUltimaAdubacao(String dataUltimaAdubacao) {
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
        System.out.println("-Data da última rega: " + this.dataUltimaRega);
        System.out.println("-Descrição: " + this.descricao);
    }
}
