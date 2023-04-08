import java.util.Scanner;

public class PlantasTeste {
    public static void main(String[] args){
        try (Scanner inserir = new Scanner(System.in)) {
            Plantas[] plantas = new Plantas[10];
            int i=0, opcao, cont=0;
            do{
                System.out.println("-----------------CATALOGO DE PLANTAS-------------------");
                System.out.println("-[1] Cadastrar uma nova planta");
                System.out.println("-[2] Procurar uma planta cadastrada no sistema");
                System.out.println("-[3] Excluir uma planta cadastrada no sistema");
                System.out.println("-[4] Listar todas as plantas cadastradas no sistema");
                System.out.println("-[0] opcao do sistema");
                System.out.println("-------Informe a opcao desejada: ");
                opcao = inserir.nextInt();
                if(opcao==1){
                    plantas[i] = new Plantas();
                    System.out.println("INSIRA O NOME: ");
                    plantas[i].insereNome();
                    System.out.println(plantas[i].nome);
                    System.out.println("INSIRA A CLASSIFICACAO: ");
                    plantas[i].insereClassificacao();
                    System.out.println("INSIRA A DESCRICAO: ");
                    plantas[i].insereDescricao();
                    cont++;
                }
                else if(opcao==4){
                    for(int k=0; k<cont; k++){
                        System.out.println("Nome: " + plantas[k].nome);
                        System.out.println("Classificao: " + plantas[k].classificacao);
                        System.out.println("Descricao: " + plantas[k].descricao);
                    }
                }
                i++;
            }while(opcao!=0);
        }
    }
}
