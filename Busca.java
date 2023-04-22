import java.util.ArrayList;

public class Busca {
    private String criterio;

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public ArrayList<Planta> buscarPorNomePopular(Plantas plantas){
        ArrayList<Planta> resultadoDaBusca = new ArrayList<>();
        for (Planta planta : plantas.getPlantas()) {
            if (planta.getNomePopular().equals(this.criterio)) {
                resultadoDaBusca.add(planta);
            }
        }
        return resultadoDaBusca;
    }
    
    public ArrayList<Planta> buscarPorCategoria(Plantas plantas){
        ArrayList<Planta> resultadoDaBusca = new ArrayList<>();
        for (Planta planta : plantas.getPlantas()) {
            if (planta.getCategoria().getNome().equals(this.criterio)) {
                resultadoDaBusca.add(planta);
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
