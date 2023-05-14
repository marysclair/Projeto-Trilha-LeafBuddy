import java.util.Random;
import java.util.Scanner;

public class Interacao {

    public Planta lerPlanta(Scanner inserir){
        System.out.println();
        System.out.println("------------------CADASTRE SUA PLANTA-------------------");
        System.out.println("Essa é a interface para cadastrar sua planta no sistema.");
        System.out.println("Preencha com atenção. Ok?");
        System.out.println();
        System.out.println("No campo de nome, recomendamos que coloque o nome popular da planta");
        System.out.println("Ou qualquer outro que você preferir. Sua planta irá ganhar um ID especial.");
        System.out.println();
        inserir.nextLine();
        System.out.println("-Informe o nome: ");
        String nome = inserir.nextLine();
        System.out.println("-Insira a idade (EM MESES): ");
        int idade = inserir.nextInt();
        Planta planta = new Planta(new Random().nextInt(150), nome, idade);
        System.out.println();
        return planta;
    }

    public Rega lerRega(Scanner inserir){
        System.out.println();
        inserir.nextLine();
        System.out.println("-Informe a data da última rega (dd/MM/yyyy): ");
        String dataUltRega = inserir.nextLine();
        System.out.println("-Informe a descrição que você queira registrar do cuidado:");
        String descricao = inserir.nextLine();
        Rega cuidado = new Rega(dataUltRega, descricao);
        return cuidado;
    }

    public Adubacao lerAdubacao(Scanner inserir){
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

    public int interfaceCategoria(Categorias categorias, Scanner inserir){
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("Você escolheu cadastrar uma nova planta no sistema.");
        System.out.println();
        System.out.println("-Esse sistema cataloga as plantas das seguintes categorias: ");
        categorias.imprimirNomeCategorias();
        System.out.println("-Qual categoria de planta você gostaria de cadastrar? ");
        System.out.println("-Informe a opção desejada: ");
        int categoria = inserir.nextInt();
        return categoria;
    }

    public int menu(Scanner inserir){
        System.out.println("-------------------CATALOGO DE PLANTAS----------------------");
        System.out.println("[1]- Plantas cadastradas");
        System.out.println("[2]- Categorias");
        System.out.println("[3]- Histórico de cuidados");
        System.out.println("[4]- Lista personalizada de plantas");
        System.out.println("[0]- SAIR");
        System.out.println("-------Informe a opcao desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }

    public int interfacePlantasCadastradas(Scanner inserir){
        System.out.println("[1]- Cadastrar novas plantas no sistema");
        System.out.println("[2]- Listar informações gerais");
        System.out.println("[3]- Remover uma planta");
        System.out.println("[4]- Buscar uma planta");
        System.out.println("-Informe a opção desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }

    public int interfaceCuidados(Scanner inserir){
        System.out.println("[1]- Listar as informações de últimos cuidados de todas as plantas");
        System.out.println("[2]- Listar as informações de cuidados de todas as plantas");
        System.out.println("[3]- Acrescentar um novo registro de cuidados a uma planta");
        System.out.println("-Informe a opção desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }

    public int interfaceFavoritas(Scanner inserir){
        System.out.println("[1]- Listar informações gerais");
        System.out.println("[2]- Listar as informações de últimos cuidados");
        System.out.println("[3]- Acrescentar uma nova planta");
        System.out.println("[4]- Remover uma planta");
        System.out.println("-Informe a opção desejada: ");
        int opcao = inserir.nextInt();
        return opcao;
    }
}
