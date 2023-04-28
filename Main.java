import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int opcao;
        Plantas plantas = new Plantas();
        Categorias categorias = new Categorias();
        Interacao interacao = new Interacao();
        Scanner inserir = new Scanner(System.in);
            do{
                System.out.println("-----------------CATALOGO DE PLANTAS-------------------");
                System.out.println("-[1] Cadastrar uma nova planta");
                System.out.println("-[2] Filtrar por Categoria/Nome Popular");
                System.out.println("-[3] Remover uma planta cadastrada");
                System.out.println("-[4] Listar informações das plantas cadastradas");
                System.out.println("-[5] Histórico de cuidados");
                System.out.println("-[0] opcao do sistema");
                System.out.println("-------Informe a opcao desejada: ");
                opcao = inserir.nextInt();

                if(opcao==1){
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Você escolheu cadastrar uma nova planta no sistema.");
                    System.out.println();
                    System.out.println("-Esse sistema cataloga as plantas das seguintes categorias: ");
                    categorias.imprimirCategorias();
                    System.out.println("-Qual categoria de planta você gostaria de cadastrar? ");
                    int categoria = inserir.nextInt();
                    plantas.adicionarPlanta(categoria, categorias);
                }
                else if(opcao==2){
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Você escolheu filtrar as plantas por Categoria/Nome Popular.");
                    System.out.println();
                    System.out.println("-De qual forma você gostaria de filtrar? ");
                    System.out.println("[1]- Categoria");
                    System.out.println("[2]- Nome Popular");
                    opcao = inserir.nextInt();
                    Busca buscar = new Busca();
                    System.out.println("Informe: ");
                    String nome = inserir.nextLine();
                    buscar.setCriterio(nome);
                    ArrayList<Planta> resultadoDaBusca = new ArrayList<>();
                    switch (opcao) {
                        case 1:
                            resultadoDaBusca = buscar.buscarPorCategoria(plantas); 
                            for (Planta planta : resultadoDaBusca) {
                                planta.mostrarInformacoes();
                            }
                            break;
                        case 2:
                            resultadoDaBusca = buscar.buscarPorNomePopular(plantas);
                            for (Planta planta : resultadoDaBusca) {
                                planta.mostrarInformacoes();
                            }
                            break;
                        default:
                            break;
                    }
                }
                else if(opcao==4){
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Você escolheu listar informações das plantas cadastradas.");
                    System.out.println();
                    if(plantas.taVazia())
                        System.out.println("Não existe plantas cadastradas ainda no sistema.");
                    else
                        plantas.listarInformacoesGerais();
                    System.out.println("");
                }
                else if(opcao==5){
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Você escolheu histórico de cuidados.");
                    System.out.println();
                    System.out.println("[1]- Listar as informações de cuidados mais recentes de todas as plantas");
                    System.out.println("[2]- Listar as informações de cuidados de todas as plantas");
                    System.out.println("[3]- Acrescentar um novo registro de cuidados a uma planta");
                    opcao = inserir.nextInt();
                    switch (opcao) {
                        case 1:
                            plantas.listarInformacoesCuidadosRecente();
                            break;
                        case 2:
                            plantas.listarInformacoesCuidados();
                            break;
                        case 3:
                            Busca buscar = new Busca();
                            System.out.println("Para adicionar um novo registro de cuidados, vamos ter que buscar a planta específica para isso.");
                            System.out.println("Para isso, é necessário saber o ID da planta. ");
                            int id = inserir.nextInt();
                            Planta resultadoBusca = buscar.buscarPorID(plantas, id);
                            if(resultadoBusca==null) System.out.println("ID INVÁLIDO");
                            else {
                                Cuidados cuidados = interacao.lerCuidados();
                                resultadoBusca.mostrarInformacoes();
                                resultadoBusca.adicionarCuidado(cuidados);
                                resultadoBusca.mostrarUltimoCuidado();
                            }
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                }
                else if(opcao==0){
                    System.out.println("PROGRAMA ENCERRADO.");
                }
                System.out.println();
            }while(opcao!=0);
    }
}
