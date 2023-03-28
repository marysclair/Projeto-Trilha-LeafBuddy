public class CatalagoPlantas{
    public static void main(String[] args){
        String especie;
        String genero;
        String classificacao;
        double tamanhoMaximo;
        double tamanhoMinimo;
        double tamanho;

        especie = "Aloe Vera";
        genero = "Aloe";
        classificacao = "Suculenta";
        tamanhoMaximo = 2;
        tamanhoMinimo = 0.6;
        tamanho = 1;

        System.out.println("------------------------------------------------------");
        System.out.println("Espécie: " + especie);
        System.out.println("Gênero: " + genero);
        System.out.println("Classificação: " + classificacao);
        System.out.println("Tamanho mínimo: " + tamanhoMinimo + " (m) e tamanho máximo: " + tamanhoMaximo + " (m)");
        System.out.println("Tamanho atual: " + tamanho + " (m)");
        System.out.println("O tamanho está entre a média? " + (tamanhoMinimo <= tamanho && tamanho <= tamanhoMaximo));
        System.out.println("------------------------------------------------------");
    }
    
}