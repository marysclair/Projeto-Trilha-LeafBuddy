package src.categorias;

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
        super(NomeCategorias.SAMAMBAIA.toString(), "Luz indireta", "Bem drenado", "Sombreado e úmido", "Adubos com uma formulação balanceada, como um fertilizante NPK geral, podem ser aplicados, seguindo as instruções de dosagem recomendadas para plantas de interior ou de sombra");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }
}
