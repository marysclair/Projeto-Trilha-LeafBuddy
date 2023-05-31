public class Cacto extends Categoria implements PlantaComFlor{
    
    @Override
    public int calcularFrequenciaRega() {
        String estacao = FrequenciaRega.estacaoAtual();
        int diasRega;
        if (estacao=="outono") diasRega = 14;
        else if(estacao=="primavera") diasRega = 10;
        else if(estacao=="verao") diasRega = 6;
        else diasRega = 21;
        return diasRega;
    }

    public Cacto() {
        super(NomeCategorias.CACTO.toString(), "Luz direta/Sol direto", "Arenoso e bem drenado", "Quente e seco", "Um adubo específico para cactos e suculentas, com uma formulação balanceada e baixa concentração de nitrogênio, pode ser usado. Adubos granulados de liberação lenta são uma opção comum");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }

    @Override
    public void getPeriodoFlorada() {
        if((FrequenciaRega.estacaoAtual()=="primavera"||FrequenciaRega.estacaoAtual()=="verao")){
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
