public class Samambaia extends Categoria {
    @Override
    public int calcularFrequenciaRega() {
        String estacao = FrequenciaRega.estacaoAtual();
        int diasRega;
        if (estacao=="outono"||estacao=="primavera") diasRega = 3;
        else if(estacao=="verao") diasRega = 2;
        else diasRega = 5;
        return diasRega;
    }

    public Samambaia() {
        super(NomeCategorias.SAMAMBAIA.toString(), "Luz indireta", "Bem drenado", "Sombreado e úmido");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }
}
