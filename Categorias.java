public class Categorias{
    
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
        switch(valor){
            case 1: 
                categoria.setNome(NomeCategorias.CACTO.toString());
                categoria.setClimaIdeal("Quente e seco");
                categoria.setLuminosidadeIdeal("Luz direta/Sol direto");
                categoria.setSoloIdeal("Arenoso e bem drenado");
                break;
            case 2:
                categoria.setNome(NomeCategorias.SUCULENTA.toString());
                categoria.setClimaIdeal("Quente e seco");
                categoria.setLuminosidadeIdeal("Luz direta");
                categoria.setSoloIdeal("Arenoso e bem drenado");
                break;
            case 3:
                categoria.setNome(NomeCategorias.SAMAMBAIA.toString());
                categoria.setClimaIdeal("Sombreado e úmido");
                categoria.setLuminosidadeIdeal("Luz indireta");
                categoria.setSoloIdeal("Bem drenado");
                break;
            case 4:
                categoria.setNome(NomeCategorias.TREPADEIRA.toString());
                categoria.setClimaIdeal("Tropical e subtropical");
                categoria.setLuminosidadeIdeal("Luz indireta e meia sombra");
                categoria.setSoloIdeal("Bem drenado e rico em matéria orgânica");
                break;
            case 5:
                categoria.setNome(NomeCategorias.FOLHAGEM.toString());
                categoria.setClimaIdeal("Temperatura moderada e alta umidade");
                categoria.setLuminosidadeIdeal("Luz indireta/luz brilhante");
                categoria.setSoloIdeal("Bem drenado e rico em nutrientes");
                break;
            case 6:
                categoria.setNome(NomeCategorias.ARBUSTO.toString());
                categoria.setClimaIdeal("Temperatura moderada e alta umidade");
                categoria.setLuminosidadeIdeal("Luz indireta e sombra parcial/luz brilhante");
                categoria.setSoloIdeal("Bem drenado e rico em nutrientes");
                break;
        }
        return categoria;
    }

    public void imprimirCategorias(){
        for(NomeCategorias nomeCategorias : NomeCategorias.values()){
            System.out.println(nomeCategorias.toString() + " - [" + nomeCategorias.getValor() + "]");
        }
    }
}