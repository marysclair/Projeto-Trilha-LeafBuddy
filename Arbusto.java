public class Arbusto extends Categoria implements PlantaComFlor{
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
        if (estacao=="outono") diasRega = 3;
        else if(estacao=="primavera") diasRega = 2;
        else if(estacao=="verao") diasRega = 1;
        else diasRega = 4;
        return diasRega;
    }

    public Arbusto() {
        super(NomeCategorias.ARBUSTO.toString(), "Luz indireta e sombra parcial/luz brilhante", "Bem drenado e rico em nutrientes", "Temperatura moderada e alta umidade", "Um adubo específico para cactos e suculentas, com uma formulação balanceada e baixa concentração de nitrogênio, pode ser usado. Adubos granulados de liberação lenta são uma opção comum");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }

    public Arbusto(boolean temFlor) {
        super(NomeCategorias.ARBUSTO.toString(), "Luz indireta e sombra parcial/luz brilhante", "Bem drenado e rico em nutrientes", "Temperatura moderada e alta umidade", "Um adubo específico para cactos e suculentas, com uma formulação balanceada e baixa concentração de nitrogênio, pode ser usado. Adubos granulados de liberação lenta são uma opção comum");
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
        System.out.println("-Com flor");
        getPeriodoFlorada();
    }
}
