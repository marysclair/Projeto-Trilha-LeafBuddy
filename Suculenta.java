public class Suculenta extends Categoria implements PlantaComFlor{
    private boolean temFlor;
    
    public boolean isTemFlor() {
        return temFlor;
    }

    public void setTemFlor(boolean temFlor) {
        this.temFlor = temFlor;
    }

    
    @Override
    public int calcularFrequenciaRega() {
        String estacao = FrequenciaRega.estacaoAtual();
        int diasRega;
        if (estacao=="outono") diasRega = 10;
        else if(estacao=="primavera") diasRega = 6;
        else if(estacao=="verao") diasRega = 4;
        else diasRega = 14;
        return diasRega;
    }

    public Suculenta() {
        super(NomeCategorias.SUCULENTA.toString(), "Luz direta", "Arenoso e bem drenado", "Quente e seco", "Um adubo específico para cactos e suculentas pode ser adequado para elas. É importante evitar adubos ricos em nitrogênio, pois isso pode estimular o crescimento excessivo e resultar em plantas menos compactas");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }

    public Suculenta(boolean temFlor) {
        super(NomeCategorias.SUCULENTA.toString(), "Luz direta", "Arenoso e bem drenado", "Quente e seco", "Um adubo específico para cactos e suculentas pode ser adequado para elas. É importante evitar adubos ricos em nitrogênio, pois isso pode estimular o crescimento excessivo e resultar em plantas menos compactas");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
        setTemFlor(temFlor);
    }

    @Override
    public void getPeriodoFlorada() { 
        if(this.temFlor&&(FrequenciaRega.estacaoAtual()=="primavera"||FrequenciaRega.estacaoAtual()=="verao")){
            System.out.println("Está no período de floração da sua planta! Tenha atenção.");
        }
    }

    @Override
    public void listarInformacoes() {
        super.listarInformacoes();
        if(temFlor){
            System.out.println("-Com flor");
            getPeriodoFlorada();
        }
    }
}
