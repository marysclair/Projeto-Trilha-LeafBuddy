package src;
import java.util.Scanner;

import src.categorias.Categoria;
import src.categorias.Categorias;
import src.utilitarias.Busca;
import src.utilitarias.Interacao;
import src.utilitarias.Serializa;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException, InterruptedException{
        System.setProperty("file.encoding", "UTF-8");
        int opcao, opcao2, id;
        String nome;
        Plantas plantas = Serializa.lerPlantasDeArquivoBinario();
        Scanner inserir = new Scanner(System.in);
            do{
                if (System.getProperty("os.name").contains("Windows"))  new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else    Runtime.getRuntime().exec("clear");
                plantas.getQtddPlantasParaRegar();
                System.out.println();
                opcao = Interacao.menu(inserir);
                System.out.println();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                if(opcao==1){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu a pagina para gerenciar as plantas do sistema.");
                    do{
                        System.out.println();
                        opcao2 = Interacao.paginaPlantasCadastradas(inserir);
                        Busca buscar = new Busca();
                        System.out.println();
                        switch (opcao2) {
                            case 1:
                                Planta planta = plantas.criarPlanta(inserir);
                                if(planta!=null){
                                    
                                    plantas.adicionarPlanta(planta);
                                    Serializa.salvarArquivoSerializado(plantas);
                                    System.out.println("Planta cadastrada com sucesso! :)");
                                }
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
                                id = Main.paginaBuscarId(inserir, plantas);
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
                                id = Main.paginaBuscarId(inserir, plantas);
                                buscar.setCriterio(id);
                                Planta resultadoBusca2 = buscar.buscarPorID(plantas);
                                System.out.println();
                                if(resultadoBusca2==null) System.out.println("----ID inválido----");
                                else {
                                    System.out.println("------------------------------------------------------------");
                                    resultadoBusca2.mostrarInformacoes();
                                    System.out.println("------------------------------------------------------------");
                                }
                                break;
                            case 0:
                                System.out.println();
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                            }
                    }while(opcao2!=0);
                    System.out.println();
                }
                else if(opcao==2){
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu a pagina referente às categorias de plantas suportadas pelo sistema.");
                    do{
                        System.out.println();
                        opcao2 = Interacao.paginaCategoria(inserir);
                        System.out.println();
                        switch (opcao2) {
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
                            System.out.println("Para buscar informações de uma categoria específica, é necessário informar o código da categoria. ");
                            Categorias.imprimirNomeCategorias();
                            System.out.println("Informe o código da categoria: ");
                            opcao = inserir.nextInt();
                            Categoria categoria = Categorias.criarCategoria(opcao, 0, inserir);
                            if(categoria!=null){
                                System.out.println();
                                categoria.listarInformacoes();
                                System.out.println();
                                }
                            else
                                System.out.println("Código inválido!");
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
                        case 0:
                            System.out.println();
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    }while(opcao2!=0);
                }
                else if(opcao==3){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu histórico de cuidados.");
                    do{
                        System.out.println();
                        opcao2 = Interacao.paginaCuidados(inserir);
                        switch (opcao2) {
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
                            id = Main.paginaBuscarId(inserir, plantas);
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
                        case 0:
                            System.out.println();
                            break;
                        default:
                            System.out.println();
                            System.out.println("Opção inválida!");
                            break;
                        }
                    }while(opcao2!=0);
                }
                else if(opcao==4){
                    Busca buscar = new Busca();
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você escolheu lista personalizada de plantas.");
                    do{
                        System.out.println();
                        opcao2 = Interacao.paginaFavoritas(inserir);
                        System.out.println();
                        switch(opcao2){
                        case 1:
                            plantas.listarPlantasFavoritas();
                            break;
                        case 2:
                            plantas.listarInformacoesCuidadosRecentePlantasFavoritas();
                            break;
                        case 3:
                            id = Main.paginaBuscarId(inserir, plantas);
                            buscar.setCriterio(id);
                            Planta resultadoBusca1 = buscar.buscarPorID(plantas);
                            System.out.println();
                            if(resultadoBusca1==null) System.out.println("---ID inválido---");
                            else{
                                if(resultadoBusca1.isFavorita()!=true){
                                    resultadoBusca1.setFavorita(true);
                                    Serializa.salvarArquivoSerializado(plantas);
                                    System.out.println("-Planta adicionada com sucesso na lista!");
                                }
                                else    System.out.println("-Planta já existe na lista.");
                            }
                            break;
                        case 4:
                            id = Main.paginaBuscarId(inserir, plantas);
                            buscar.setCriterio(id);
                            Planta resultadoBusca2 = buscar.buscarPorID(plantas);
                            System.out.println();
                            if(resultadoBusca2==null) System.out.println("---ID inválido---");
                            else{
                                if(resultadoBusca2.isFavorita()==true){
                                    resultadoBusca2.setFavorita(false);
                                    Serializa.salvarArquivoSerializado(plantas);
                                    System.out.println("-Planta removida com sucesso na lista!");
                                }
                                else    System.out.println("-Planta não existe na lista.");
                            }
                            break;
                        case 0:
                            System.out.println();
                            break;
                        default:
                            System.out.println();
                            System.out.println("Opção inválida!");
                            break;
                    }
                    }while(opcao2!=0);
                }
                else if(opcao==0){
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("--------------------PROGRAMA ENCERRADO----------------------");
                    System.out.println("------------------------------------------------------------");
                }
                else{
                    System.out.println("Opção inválida");
                }
                System.out.println();
                inserir.nextLine();
                inserir.nextLine();
            }while(opcao!=0);
    }

    public static int paginaBuscarId(Scanner inserir, Plantas plantas){
        System.out.println("Para isso, é necessário saber o ID da planta. ");
        plantas.listarNomeEId();
        System.out.println("-Informe o ID: ");
        int id = inserir.nextInt();
        return id;
    }
}
