package src.categorias;

import src.PlantaComFlor;

public class Trepadeira extends Categoria implements PlantaComFlor{
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
        if (estacao=="outono"||estacao=="primavera") diasRega = 3;
        else if(estacao=="verao") diasRega = 2;
        else diasRega = 6;
        return diasRega;
    }

    public Trepadeira() {
        super(NomeCategorias.TREPADEIRA.toString(), "Luz indireta e meia sombra", "Bem drenado e rico em matéria orgânica", "Tropical e subtropical", "Adubos com uma formulação equilibrada, como um fertilizante NPK (nitrogênio, fósforo e potássio) de uso geral, podem ser apropriados");
        int diasRega = calcularFrequenciaRega();
        setDiasRega(diasRega);
    }

    public Trepadeira(boolean temFlor) {
        super(NomeCategorias.TREPADEIRA.toString(), "Luz indireta e meia sombra", "Bem drenado e rico em matéria orgânica", "Tropical e subtropical", "Adubos com uma formulação equilibrada, como um fertilizante NPK (nitrogênio, fósforo e potássio) de uso geral, podem ser apropriados");
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
        if(temFlor){
            System.out.println("-Com flor");
            getPeriodoFlorada();
        }
    }
}
