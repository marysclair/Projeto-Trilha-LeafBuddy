import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.setProperty("file.encoding", "UTF-8");
        int opcao;
        String nome;
        Serializar serializar = new Serializar();
        Plantas plantas = serializar.lerPlantasDeArquivoBinario();
        Interacao interacao = new Interacao();
        Scanner inserir = new Scanner(System.in);
            do{
                opcao = interacao.menu();

                if(opcao==1){
                    Planta planta = plantas.criarPlanta();
                    plantas.adicionarPlanta(planta);
                    serializar.salvarArquivoSerializado(plantas);
                    System.out.println("Planta cadastrada com sucesso! :)");
                    System.out.println();
                }
                else if(opcao==2){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu filtrar as plantas por Categoria/Nome Popular.");
                    System.out.println();
                    System.out.println("-De qual forma você gostaria de filtrar? ");
                    System.out.println("[1]- Categoria");
                    System.out.println("[2]- Nome Popular");
                    System.out.println("-Informe a opção desejada: ");
                    opcao = inserir.nextInt();
                    System.out.println();
                    System.out.println("Informe o filtro: ");
                    inserir.nextLine();
                    nome = inserir.nextLine();
                    Busca buscar = new Busca();
                    buscar.setCriterio(nome);
                    Plantas resultadoDaBusca = new Plantas();
                    switch (opcao) {
                        case 1:
                            resultadoDaBusca = buscar.buscarPorCategoria(plantas); 
                            if(resultadoDaBusca.taVazia())      System.out.println("Categoria inválida");
                            else    resultadoDaBusca.listarInformacoesGerais();
                            break;
                        case 2:
                            resultadoDaBusca = buscar.buscarPorNomePopular(plantas);
                            if(resultadoDaBusca.taVazia())      System.out.println("Nome popular inválido");
                            else    resultadoDaBusca.listarInformacoesGerais();
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                }
                else if(opcao==3){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu remover uma planta do sistema.");
                    System.out.println();
                    Busca buscar = new Busca();
                            System.out.println("Para remover uma planta do sistema, vamos ter que buscar a planta específica para isso.");
                            System.out.println("Para isso, é necessário saber o ID da planta. ");
                            System.out.println("-Informe a opção desejada: ");
                            int id = inserir.nextInt();
                            Planta resultadoBusca = buscar.buscarPorID(plantas, id);
                            System.out.println();
                            if(resultadoBusca==null) System.out.println("----ID inválido----");
                            else {
                                plantas.removerPlanta(resultadoBusca);
                                System.out.println("Planta removida com sucesso! :)");
                                serializar.salvarArquivoSerializado(plantas);
                                System.out.println();
                                System.out.println("P.S.: Espero que ela não tenha morrido...");
                            }
                            
                }
                else if(opcao==4){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu listar informações das plantas cadastradas.");
                    System.out.println();
                    plantas.listarInformacoesGerais();
                    System.out.println("");
                }
                else if(opcao==5){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu histórico de cuidados.");
                    System.out.println();
                    opcao = interacao.interfaceCuidados();
                    switch (opcao) {
                        case 1:
                            plantas.listarInformacoesCuidadosRecente();
                            break;
                        case 2:
                            plantas.listarInformacoesCuidados();
                            break;
                        case 3:
                            System.out.println();
                            Busca buscar = new Busca();
                            System.out.println("Para adicionar um novo registro de cuidados, vamos ter que buscar a planta específica para isso.");
                            System.out.println("Para isso, é necessário saber o ID da planta. ");
                            System.out.println("-Informe a opção desejada: ");
                            int id = inserir.nextInt();
                            Planta resultadoBusca = buscar.buscarPorID(plantas, id);
                            System.out.println();
                            if(resultadoBusca==null) System.out.println("---ID inválido---");
                            else {
                                Cuidados cuidados = interacao.lerCuidados();
                                resultadoBusca.adicionarCuidado(cuidados);
                                System.out.println("Prontinho! Confira se os dados estão corretos:");
                                System.out.println("------------------------------------------------------------");
                                resultadoBusca.mostrarUltimoCuidado();
                                System.out.println("------------------------------------------------------------");
                                serializar.salvarArquivoSerializado(plantas);
                            }
                            break;
                        default:
                            System.out.println();
                            System.out.println("Opção inválida!");
                            break;
                    }
                }
                else if(opcao==6){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu lista personalizada de plantas.");
                    System.out.println();
                    opcao = interacao.interfaceFavoritas();
                    switch(opcao){
                        case 1:
                            plantas.listarPlantasFavoritas();
                            break;
                        case 3:
                            System.out.println("Para isso, é necessário saber o ID da planta. ");
                            System.out.println("-Informe a opção desejada: ");
                            Busca buscar = new Busca();
                            int id = inserir.nextInt();
                            Planta resultadoBusca = buscar.buscarPorID(plantas, id);
                            resultadoBusca.setFavorita(true);
                            serializar.salvarArquivoSerializado(plantas);
                            break;
                    }
                }
                else if(opcao==0){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("PROGRAMA ENCERRADO");
                }
                System.out.println();
            }while(opcao!=0);
    }
}
