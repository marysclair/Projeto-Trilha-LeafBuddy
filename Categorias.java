public class Categorias{
    private final static int QTDD = 9;

    enum NomeCategorias {
        CACTO(1), 
        SUCULENTA(2), 
        SAMAMBAIA(3),
        TREPADEIRA(4), 
        FOLHAGEM(5), 
        ARBUSTO(6), 
        FLOR(7), 
        BROMELIA(8), 
        ORQUIDEA(9);

        private int valor;

        NomeCategorias(int valor){
            this.valor = valor;
        }
        public int getValor(){
            return valor;
        }
    }

    public Categoria preencherCategoria(int valor){
        Categoria categoria = new Categoria();
        FrequenciaRega frequenciaRega = new FrequenciaRega();
        String estacao = frequenciaRega.estacaoAtual();
        if(valor>9&&valor<1) System.out.println("Valor inválido");
        else {
            switch(valor){
                case 1: 
                    categoria.setNome(NomeCategorias.CACTO.toString());
                    categoria.setClimaIdeal("Quente e seco");
                    categoria.setLuminosidadeIdeal("Luz direta/Sol direto");
                    categoria.setSoloIdeal("Arenoso e bem drenado");
                    if (estacao=="outono") frequenciaRega.setDias(14);
                    else if(estacao=="primavera") frequenciaRega.setDias(10);
                    else if(estacao=="verao") frequenciaRega.setDias(6);
                    else frequenciaRega.setDias(21);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
                case 2:
                    categoria.setNome(NomeCategorias.SUCULENTA.toString());
                    categoria.setClimaIdeal("Quente e seco");
                    categoria.setLuminosidadeIdeal("Luz direta");
                    categoria.setSoloIdeal("Arenoso e bem drenado");
                    if (estacao=="outono") frequenciaRega.setDias(10);
                    else if(estacao=="primavera") frequenciaRega.setDias(6);
                    else if(estacao=="verao") frequenciaRega.setDias(4);
                    else frequenciaRega.setDias(14);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
                case 3:
                    categoria.setNome(NomeCategorias.SAMAMBAIA.toString());
                    categoria.setClimaIdeal("Sombreado e úmido");
                    categoria.setLuminosidadeIdeal("Luz indireta");
                    categoria.setSoloIdeal("Bem drenado");
                    if (estacao=="outono") frequenciaRega.setDias(3);
                    else if(estacao=="primavera") frequenciaRega.setDias(3);
                    else if(estacao=="verao") frequenciaRega.setDias(2);
                    else frequenciaRega.setDias(5);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
                case 4:
                    categoria.setNome(NomeCategorias.TREPADEIRA.toString());
                    categoria.setClimaIdeal("Tropical e subtropical");
                    categoria.setLuminosidadeIdeal("Luz indireta e meia sombra");
                    categoria.setSoloIdeal("Bem drenado e rico em matéria orgânica");
                    if (estacao=="outono") frequenciaRega.setDias(3);
                    else if(estacao=="primavera") frequenciaRega.setDias(3);
                    else if(estacao=="verao") frequenciaRega.setDias(2);
                    else frequenciaRega.setDias(6);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
                case 5:
                    categoria.setNome(NomeCategorias.FOLHAGEM.toString());
                    categoria.setClimaIdeal("Temperatura moderada e alta umidade");
                    categoria.setLuminosidadeIdeal("Luz indireta/luz brilhante");
                    categoria.setSoloIdeal("Bem drenado e rico em nutrientes");
                    if (estacao=="outono") frequenciaRega.setDias(3);
                    else if(estacao=="primavera") frequenciaRega.setDias(2);
                    else if(estacao=="verao") frequenciaRega.setDias(1);
                    else frequenciaRega.setDias(5);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
                case 6:
                    categoria.setNome(NomeCategorias.ARBUSTO.toString());
                    categoria.setClimaIdeal("Temperatura moderada e alta umidade");
                    categoria.setLuminosidadeIdeal("Luz indireta e sombra parcial/luz brilhante");
                    categoria.setSoloIdeal("Bem drenado e rico em nutrientes");
                    if (estacao=="outono") frequenciaRega.setDias(3);
                    else if(estacao=="primavera") frequenciaRega.setDias(2);
                    else if(estacao=="verao") frequenciaRega.setDias(1);
                    else frequenciaRega.setDias(4);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
                case 7:
                    categoria.setNome(NomeCategorias.FLOR.toString());
                    categoria.setClimaIdeal("Temperatura moderada");
                    categoria.setLuminosidadeIdeal("Luz indireta");
                    categoria.setSoloIdeal("Bem drenado, rico em matéria orgânica e com boa retenção de umidade");
                    if (estacao=="outono") frequenciaRega.setDias(4);
                    else if(estacao=="primavera") frequenciaRega.setDias(4);
                    else if(estacao=="verao") frequenciaRega.setDias(3);
                    else frequenciaRega.setDias(6);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
                case 8:
                    categoria.setNome(NomeCategorias.BROMELIA.toString());
                    categoria.setClimaIdeal("Quente e úmido");
                    categoria.setLuminosidadeIdeal("Luz indireta/sombra parcial");
                    categoria.setSoloIdeal("Bem drenado e com boa retenção de umidade");
                    if (estacao=="outono") frequenciaRega.setDias(7);
                    else if(estacao=="primavera") frequenciaRega.setDias(3);
                    else if(estacao=="verao") frequenciaRega.setDias(3);
                    else frequenciaRega.setDias(14);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
                case 9:
                    categoria.setNome(NomeCategorias.ORQUIDEA.toString());
                    categoria.setClimaIdeal("Quente e úmido");
                    categoria.setLuminosidadeIdeal("Luz brilhante e difusa");
                    categoria.setSoloIdeal("Misturas de substratos bem drenados e com boa ventilação para as raízes");
                    if (estacao=="outono") frequenciaRega.setDias(7);
                    else if(estacao=="primavera") frequenciaRega.setDias(5);
                    else if(estacao=="verao") frequenciaRega.setDias(5);
                    else frequenciaRega.setDias(10);
                    categoria.setDiasRega(frequenciaRega.getDias());
                    break;
            }
        }
        return categoria;
    }

    public void imprimirNomeCategorias(){
        for(NomeCategorias nomeCategorias : NomeCategorias.values()){
            System.out.println("[" + nomeCategorias.getValor() + "]- " + nomeCategorias.toString());
        }
    }

    public void imprimirCategorias(){
        for (int i = 1; i <= QTDD; i++) {
            System.out.println("------------------------------------------------------------");
            Categoria categoria = preencherCategoria(i);
            categoria.listarInformacoes();
            System.out.println("------------------------------------------------------------");
            System.out.println();
        }
    }
}