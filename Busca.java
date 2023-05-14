// import java.util.ArrayList;

public class Busca {
    private String criterio;

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }
    
    public void setCriterio(int criterio) {
        setCriterio(Integer.toString(criterio));
    }
    
    public Plantas buscarPlantasPorCategoria(Plantas plantas){
        Plantas resultadoDaBusca = new Plantas();
        for (Planta planta : plantas.getPlantas()) {
            if (planta.getCategoria().getNome().equals(criterio.toUpperCase())) {
                resultadoDaBusca.adicionarPlanta(planta);
            }
        }
        return resultadoDaBusca;
    }

    // public Categoria buscarCategoria(String categoria){
    //     Categorias categorias = new Categorias();

    // }

    public Planta buscarPorID(Plantas plantas){
        Planta resultadoDaBusca = null;
        for (Planta planta : plantas.getPlantas()) {
            if (planta.getId()==Integer.parseInt(criterio)) {
                resultadoDaBusca = planta;
            }
        }
        return resultadoDaBusca;
    }

    
}
