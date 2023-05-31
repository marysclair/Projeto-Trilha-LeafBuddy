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
        super(NomeCategorias.ORQUIDEA.toString(), "Luz brilhante e difusa", "Misturas de substratos bem drenados e com boa ventilação para as raízes", "Quente e úmido", "Recomenda-se o uso de um adubo especializado para orquídeas, que seja solúvel em água e tenha uma formulação equilibrada. Adubos específicos para orquídeas estão disponíveis em diferentes formas, como líquidos, em pó ou bastões, e devem ser aplicados de acordo com as instruções do fabricante");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }
}
