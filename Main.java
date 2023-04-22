import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner inserir = new Scanner(System.in);
            int opcao;
            Plantas plantas = new Plantas();

            Categoria[] categorias = new Categoria[10];
            for(int i=0; i<10; i++){
                categorias[i] = new Categoria();
                switch(i){
                    case 0:
                        categorias[i].setNome("cacto");
                        categorias[i].setSoloIdeal("poroso");
                        categorias[i].setUmidadeSoloIdeal("quase seco");
                        categorias[i].setLuminosidadeIdeal("muito sol");
                        break;
                    case 1:
                        categorias[i].setNome("suculenta");
                        categorias[i].setSoloIdeal("poroso");
                        categorias[i].setUmidadeSoloIdeal("quase seco");
                        categorias[i].setLuminosidadeIdeal("muito sol");
                        break;
                }
            }

            do{
                System.out.println("-----------------CATALOGO DE PLANTAS-------------------");
                System.out.println("-[1] Cadastrar uma nova planta");
                // System.out.println("-[2] Procurar uma planta cadastrada no sistema");
                // System.out.println("-[3] Excluir uma planta cadastrada no sistema");
                System.out.println("-[4] Listar todas as plantas cadastradas no sistema");
                System.out.println("-[0] opcao do sistema");
                System.out.println("-------Informe a opcao desejada: ");
                opcao = inserir.nextInt();
                inserir.nextLine();

                if(opcao==1){
                    System.out.println("-ESSE SISTEMA CATALOGA PLANTAS DAS SEGUINTES CATEGORIAS: ");
                    System.out.println("1- Cacto");
                    System.out.println("2- Suculentas");
                    System.out.println("3- Arbustos");
                    System.out.println("4- Flores tropicais");
                    System.out.println("-Qual categoria de planta você gostaria de cadastrar? ");
                    int categoria = inserir.nextInt();
                    inserir.nextLine();
                    switch(categoria){
                        case 1:
                            plantas.adicionarPlanta(categorias[categoria-1]);
                            break;
                    }
                    System.out.println("--Planta cadastrada");
                }
                else if(opcao==4){
                    plantas.listarInformacoesGerais();
                }
            }while(opcao!=0);
    }
}
