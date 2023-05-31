public class Flor extends Categoria {
    @Override
    public int calcularFrequenciaRega() {
        String estacao = FrequenciaRega.estacaoAtual();
        int diasRega;
        if (estacao=="outono"||estacao=="primavera") diasRega = 4;
        else if(estacao=="verao") diasRega = 3;
        else diasRega = 6;
        return diasRega;
    }

    public Flor() {
        super(NomeCategorias.FLOR.toString(), "Luz indireta", "Bem drenado, rico em matéria orgânica e com boa retenção de umidade", "Temperatura moderada", "Adubos solúveis em água, formulados para flores, geralmente contêm nutrientes essenciais para promover a floração saudável");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }
}
