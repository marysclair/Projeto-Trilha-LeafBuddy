public class Bromelia extends Categoria{
    @Override
    public int calcularFrequenciaRega() {
        String estacao = FrequenciaRega.estacaoAtual();
        int diasRega;
        if (estacao=="outono") diasRega = 7;
        else if(estacao=="primavera"||estacao=="verao") diasRega = 3;
        else diasRega = 14;
        return diasRega;
    }

    public Bromelia() {
        super(NomeCategorias.BROMELIA.toString(), "Luz indireta/sombra parcial", "Bem drenado e com boa retenção de umidade", "Quente e úmido", "Adubos líquidos com formulação equilibrada, projetados para plantas epífitas ou bromélias, podem ser utilizados. Esses adubos costumam ter uma concentração mais baixa de nutrientes");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }
}
