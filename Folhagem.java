public class Folhagem extends Categoria {
    @Override
    public int calcularFrequenciaRega() {
        String estacao = FrequenciaRega.estacaoAtual();
        int diasRega;
        if (estacao=="outono") diasRega = 3;
        else if(estacao=="primavera") diasRega = 2;
        else if(estacao=="verao") diasRega = 1;
        else diasRega = 5;
        return diasRega;
    }

    public Folhagem() {
        super(NomeCategorias.FOLHAGEM.toString(), "Luz indireta/luz brilhante", "Bem drenado e rico em nutrientes", "Temperatura moderada e alta umidade");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }
}
