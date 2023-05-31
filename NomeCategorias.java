public enum NomeCategorias {
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