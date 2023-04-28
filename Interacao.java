// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class Interacao {
    
    public void lerDados(Planta planta){
        Scanner inserir = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------CADASTRE SUA PLANTA-------------------");
        System.out.println("Essa é a interface para cadastrar sua planta no sistema.");
        System.out.println("Preencha com atenção. Ok?");
        System.out.println();
        System.out.println("Se você não souber o nome popular da sua planta, não se preocupe!");
        System.out.println("Pode usar o nome da própria categoria. Sua planta irá ganhar um ID especial.");
        System.out.println();
        System.out.println("-Informe o nome popular: ");
        String nome = inserir.nextLine();
        System.out.println("-Insira a idade (EM MESES): ");
        int idade = inserir.nextInt();
        planta.setNomePopular(nome);
        planta.setId(new Random().nextInt());
        planta.setIdade(idade);
        System.out.println();
    }

    public Cuidados lerCuidados(){
        Cuidados cuidados = new Cuidados();
        Scanner inserir = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------CADASTRE OS CUIDADOS-------------------");
        System.out.println("Essa é a interface para cadastrar os cuidados da sua planta.");
        System.out.println("Preencha com atenção. Ok?");
        System.out.println();
        System.out.println("-Informe a data da última rega (dd/MM/yyyy): ");
        String dataUltRega = inserir.nextLine();
        System.out.println("-Informe a data da última adubação (dd/MM/yyyy): ");
        String dataUltAdub = inserir.nextLine();
        System.out.println("-Deseja informar alguma descrição? ");
        String descricao = inserir.nextLine();
        cuidados.setDataUltimaRega(dataUltRega);
        cuidados.setDataUltimaAdubacao(dataUltAdub);
        cuidados.setDescricao(descricao);
        return cuidados;
    }
}
