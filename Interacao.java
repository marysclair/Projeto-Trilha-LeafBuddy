import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Interacao {

    public static Planta lerPlanta(Scanner inserir){
        System.out.println();
        System.out.println("------------------CADASTRE SUA PLANTA-------------------");
        System.out.println("Essa é a pagina para cadastrar sua planta no sistema.");
        System.out.println("Preencha com atenção. Ok?");
        System.out.println();
        System.out.println("No campo de nome, recomendamos que coloque o nome popular da planta");
        System.out.println("Ou qualquer outro que você preferir. Sua planta irá ganhar um ID especial.");
        System.out.println();
        inserir.nextLine();
        System.out.println("-Informe o nome: ");
        String nome = inserir.nextLine();
        System.out.println("-Insira a data que você obteve a planta (dd/mm/yyyy): ");
        String data = inserir.nextLine();
        Planta planta = new Planta(new Random().nextInt(150), nome, data);
        System.out.println();
        return planta;
    }

    public static Rega lerRega(Scanner inserir){
        System.out.println();
        inserir.nextLine();
        System.out.println("-Informe a data da última rega (dd/MM/yyyy): ");
        String dataUltRega = inserir.nextLine();
        System.out.println("-Informe a descrição que você queira registrar do cuidado:");
        String descricao = inserir.nextLine();
        Rega cuidado = new Rega(dataUltRega, descricao);
        return cuidado;
    }

    public static Adubacao lerAdubacao(Scanner inserir){
        System.out.println();
        inserir.nextLine();
        System.out.println("-Informe a data da última adubação (dd/MM/yyyy): ");
        String dataUltAdub = inserir.nextLine();
        System.out.println("-Informe o adubo que você utilizou: ");
        String adubo = inserir.nextLine();
        System.out.println("-Informe a descrição que você queira registrar do cuidado:");
        String descricao = inserir.nextLine();
        Adubacao cuidado = new Adubacao(dataUltAdub, adubo, descricao);
        return cuidado;
    }

    public static int escolherCategoria(Scanner inserir){
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("Você escolheu cadastrar uma nova planta no sistema.");
        System.out.println();
        System.out.println("-Esse sistema cataloga as plantas das seguintes categorias: ");
        Categorias.imprimirNomeCategorias();
        System.out.println("-Qual categoria de planta você gostaria de cadastrar? ");
        int categoria = -1;
        try{
            System.out.println("-Informe a opção desejada: ");
            categoria = inserir.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Digite um número inteiro");
        }
        return categoria;
    }

    public static int menu(Scanner inserir){
        System.out.println("-------------------CATALOGO DE PLANTAS----------------------");
        System.out.println();
        System.out.println();
        System.out.println("[1]- Plantas cadastradas");
        System.out.println("[2]- Categorias");
        System.out.println("[3]- Histórico de cuidados");
        System.out.println("[4]- Lista personalizada de plantas");
        System.out.println("[0]- SAIR");
        System.out.println("-------Informe a opcao desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }

    public static int paginaPlantasCadastradas(Scanner inserir){
        System.out.println("[1]- Cadastrar novas plantas no sistema");
        System.out.println("[2]- Listar informações gerais");
        System.out.println("[3]- Remover uma planta");
        System.out.println("[4]- Buscar uma planta");
        System.out.println("[0]- Voltar");
        System.out.println("-Informe a opção desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }

    public static int paginaCuidados(Scanner inserir){
        System.out.println("[1]- Listar as informações de últimos cuidados de todas as plantas");
        System.out.println("[2]- Listar as informações de cuidados de todas as plantas");
        System.out.println("[3]- Acrescentar um novo registro de cuidados a uma planta");
        System.out.println("[0]- Voltar");
        System.out.println("-Informe a opção desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }

    public static int paginaFavoritas(Scanner inserir){
        System.out.println("[1]- Listar informações gerais");
        System.out.println("[2]- Listar as informações de últimos cuidados");
        System.out.println("[3]- Acrescentar uma nova planta");
        System.out.println("[4]- Remover uma planta");
        System.out.println("[0]- Voltar");
        System.out.println("-Informe a opção desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }

    public static String paginaPlantaComFlor(Scanner inserir){
        System.out.println("A sua planta tem flor? [s/n]");
        String opcao = inserir.next();
        return opcao;
    }

    public static Planta cadastrarCuidado(Scanner inserir, Planta resultadoBusca){
        System.out.println();
        System.out.println("------------------CADASTRE OS CUIDADOS-------------------");
        System.out.println("Essa é a pagina para cadastrar os cuidados da sua planta.");
        System.out.println("Preencha com atenção. Ok?");
        System.out.println();
        System.out.println("[1]- Cadastrar dados sobre a rega");
        System.out.println("[2]- Cadastrar dados sobre a adubação");
        System.out.println("-Informe a opção desejada: ");
        int opcao = inserir.nextInt();
        System.out.println();
        switch (opcao) {
            case 1:
                Rega cuidadoRega = Interacao.lerRega(inserir); 
                resultadoBusca.adicionarCuidado(cuidadoRega);
                break;
            case 2:
                Adubacao cuidadoAdub = Interacao.lerAdubacao(inserir); 
                resultadoBusca.adicionarCuidado(cuidadoAdub);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        return resultadoBusca;
    }

    public static int paginaCategoria(Scanner inserir){
        System.out.println("------------------------------------------------------------");
        System.out.println("Você escolheu a pagina referente às categorias de plantas suportadas pelo sistema.");
        System.out.println();
        System.out.println("[1]- Listar os nomes das categorias");
        System.out.println("[2]- Listar todas as categorias e suas informações");
        System.out.println("[3]- Buscar informação de uma categoria");
        System.out.println("[4]- Agrupar plantas por categoria");
        System.out.println("[0]- Voltar");
        System.out.println("-Informe a opção desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }
}
