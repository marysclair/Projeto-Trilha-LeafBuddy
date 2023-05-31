public class Orquidea extends Categoria{
    @Override
    public int calcularFrequenciaRega() {
        String estacao = FrequenciaRega.estacaoAtual();
        int diasRega;
        if (estacao=="outono") diasRega = 7;
        else if(estacao=="primavera"||estacao=="verao") diasRega = 5;
        else diasRega = 10;
        return diasRega;
    }

    public Orquidea() {
        super(NomeCategorias.ORQUIDEA.toString(), "Luz brilhante e difusa", "Misturas de substratos bem drenados e com boa ventilação para as raízes", "Quente e úmido");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }
}
