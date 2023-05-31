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
        super(NomeCategorias.CACTO.toString(), "Luz direta/Sol direto", "Arenoso e bem drenado", "Quente e seco");
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
