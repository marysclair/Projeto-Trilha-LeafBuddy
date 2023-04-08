import java.util.Scanner;

public class Plantas{
    Scanner inserir = new Scanner(System.in);
    String nome;
    String classificacao;
    String descricao;
    String luz;
    String umidade;
    String cor;
    double tamanho;
    void insereNome(){
        nome = inserir.next();
    }
    void insereClassificacao(){
        classificacao = inserir.next();
        // return classificacao;
    }
    void insereDescricao(){
        descricao = inserir.nextLine();
        // return descricao;
    }
    String insereLuz(){
        luz = inserir.next();
        return luz;
    }
    String insereUmidade(){
        umidade = inserir.next();
        return umidade;
    }
    String insereCor(){
        cor = inserir.next();
        return cor;
    }
    double insereTamanho(){
        tamanho = inserir.nextDouble();
        return tamanho;
    }
}