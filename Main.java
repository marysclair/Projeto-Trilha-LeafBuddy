import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.setProperty("file.encoding", "UTF-8");
        int opcao, id;
        String nome;
        Plantas plantas = Serializa.lerPlantasDeArquivoBinario();
        Scanner inserir = new Scanner(System.in);
            do{
                opcao = Interacao.menu(inserir);
                System.out.println();
                if(opcao==1){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu a interface para gerenciar as plantas do sistema.");
                    System.out.println();
                    opcao = Interacao.interfacePlantasCadastradas(inserir);
                    Busca buscar = new Busca();
                    System.out.println();
                    switch (opcao) {
                        case 1:
                            Planta planta = plantas.criarPlanta(inserir);
                            plantas.adicionarPlanta(planta);
                            Serializa.salvarArquivoSerializado(plantas);
                            System.out.println("Planta cadastrada com sucesso! :)");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Você escolheu listar informações das plantas cadastradas.");
                            System.out.println();
                            plantas.listarInformacoesGerais();
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Você escolheu remover uma planta do sistema.");
                            System.out.println();
                            System.out.println("Para remover uma planta do sistema, vamos ter que buscar a planta específica para isso.");
                            System.out.println("Para isso, é necessário saber o ID da planta. ");
                            System.out.println("-Informe o ID: ");
                            id = inserir.nextInt();
                            buscar.setCriterio(id);
                            Planta resultadoBusca1 = buscar.buscarPorID(plantas);
                            System.out.println();
                            if(resultadoBusca1==null) System.out.println("----ID inválido----");
                            else {
                                plantas.removerPlanta(resultadoBusca1);
                                System.out.println("Planta removida com sucesso! :)");
                                Serializa.salvarArquivoSerializado(plantas);
                                System.out.println();
                                System.out.println("P.S.: Espero que ela não tenha morrido...");
                            }
                            break;
                        case 4:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Você escolheu buscar uma planta do sistema.");
                            System.out.println();
                            id = Main.interfaceBuscarId(inserir);
                            buscar.setCriterio(id);
                            Planta resultadoBusca2 = buscar.buscarPorID(plantas);
                            System.out.println();
                            if(resultadoBusca2==null) System.out.println("----ID inválido----");
                            else {
                                resultadoBusca2.mostrarInformacoes();
                            }
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                        }
                    System.out.println();
                }
                else if(opcao==2){
                    System.out.println();
                    opcao = Interacao.interfaceCategoria(inserir);
                    System.out.println();
                    switch (opcao) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            Categorias.imprimirNomeCategorias();
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            Categorias.imprimirCategorias();
                            break;
                        case 3:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Para buscar informações de uma categoria específica, informe o código da categoria: ");
                            opcao = inserir.nextInt();
                            Categoria categoria = Categorias.criarCategoria(opcao, inserir);
                            categoria.listarInformacoes();
                            break;
                        case 4:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Para agrupar por categoria, informe o nome da categoria: ");
                            inserir.nextLine();
                            nome = inserir.nextLine();
                            Busca buscar = new Busca();
                            Plantas resultadoDaBusca = new Plantas();
                            buscar.setCriterio(nome);
                            resultadoDaBusca = buscar.buscarPlantasPorCategoria(plantas); 
                            if(resultadoDaBusca.taVazia())      System.out.println("Categoria inválida/Nenhuma planta cadastrada nessa categoria");
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
                    System.out.println("Você escolheu histórico de cuidados.");
                    System.out.println();
                    opcao = Interacao.interfaceCuidados(inserir);
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
                            id = Main.interfaceBuscarId(inserir);
                            buscar.setCriterio(id);
                            Planta resultadoBusca = buscar.buscarPorID(plantas);
                            System.out.println();
                            if(resultadoBusca==null) System.out.println("---ID inválido---");
                            else {
                                Interacao.cadastrarCuidado(inserir, resultadoBusca);
                                System.out.println("Prontinho! Confira se os dados estão corretos:");
                                System.out.println("------------------------------------------------------------");
                                resultadoBusca.mostrarUltimoCuidado();
                                System.out.println("------------------------------------------------------------");
                                Serializa.salvarArquivoSerializado(plantas);
                            }
                            break;
                        default:
                            System.out.println();
                            System.out.println("Opção inválida!");
                            break;
                        }
                }
                else if(opcao==4){
                    Busca buscar = new Busca();
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu lista personalizada de plantas.");
                    System.out.println();
                    opcao = Interacao.interfaceFavoritas(inserir);
                    System.out.println();
                    switch(opcao){
                        case 1:
                            plantas.listarPlantasFavoritas();
                            break;
                        case 2:
                            plantas.listarInformacoesCuidadosRecente();
                        case 3:
                            id = Main.interfaceBuscarId(inserir);
                            buscar.setCriterio(id);
                            Planta resultadoBusca1 = buscar.buscarPorID(plantas);
                            System.out.println();
                            if(resultadoBusca1==null) System.out.println("---ID inválido---");
                            else{
                                resultadoBusca1.setFavorita(true);
                                Serializa.salvarArquivoSerializado(plantas);
                            }
                            System.out.println("-Planta adicionada com sucesso na lista!");
                            break;
                        case 4:
                            id = Main.interfaceBuscarId(inserir);
                            buscar.setCriterio(id);
                            Planta resultadoBusca2 = buscar.buscarPorID(plantas);
                            if(resultadoBusca2==null) System.out.println("---ID inválido---");
                            else{
                                resultadoBusca2.setFavorita(false);
                                Serializa.salvarArquivoSerializado(plantas);
                            }
                            break;
                    }
                }
                else if(opcao==0){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("PROGRAMA ENCERRADO");
                }
                else{
                    System.out.println("Opção inválida");
                }
                System.out.println();
            }while(opcao!=0);
    }

    public static int interfaceBuscarId(Scanner inserir){
        System.out.println("Para isso, é necessário saber o ID da planta. ");
        System.out.println("-Informe o ID: ");
        int id = inserir.nextInt();
        return id;
    }
}
