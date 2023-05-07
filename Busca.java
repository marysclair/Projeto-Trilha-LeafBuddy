// import java.util.ArrayList;

public class Busca {
    private String criterio;

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public Plantas buscarPorNomePopular(Plantas plantas){
        Plantas resultadoDaBusca = new Plantas();
        for (Planta planta : plantas.getPlantas()) {
            if (planta.getNomePopular().equals(this.criterio)) {
                resultadoDaBusca.adicionarPlanta(planta);
            }
        }
        return resultadoDaBusca;
    }
    
    public Plantas buscarPorCategoria(Plantas plantas){
        Plantas resultadoDaBusca = new Plantas();
        for (Planta planta : plantas.getPlantas()) {
            if (planta.getCategoria().getNome().equals(criterio.toUpperCase())) {
                resultadoDaBusca.adicionarPlanta(planta);
            }
        }
        return resultadoDaBusca;
    }

    public Planta buscarPorID(Plantas plantas, int id){
        Planta resultadoDaBusca = null;
        for (Planta planta : plantas.getPlantas()) {
            if (planta.getId()==id) {
                resultadoDaBusca = planta;
            }
        }
        return resultadoDaBusca;
    }

    
}
