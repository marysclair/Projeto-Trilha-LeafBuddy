import java.util.Scanner;

public class Categorias{
    public static void imprimirNomeCategorias(){
        for(NomeCategorias nomeCategorias : NomeCategorias.values()){
            System.out.println("[" + nomeCategorias.getValor() + "]- " + nomeCategorias.toString());
        }
    }

    public static void imprimirCategorias(){
        Categoria categoria = null;
        for (int i = 1; i <= 9; i++) {
            categoria = criarCategoria(i, 0, new Scanner(System.in));
            System.out.println();
            categoria.listarInformacoes();
            System.out.println();
        }
    }

    public static Categoria criarCategoria(int valor, int opcao, Scanner inserir){
        Categoria categoria = null;
        switch (valor) {
            case 1:
                categoria = new Cacto();
                break;
            case 2:
                if(opcao==1){
                    if(Interacao.interfacePlantaComFlor(inserir).equalsIgnoreCase("s"))
                        categoria = new Suculenta(true);
                    else
                        categoria = new Suculenta();
                } else categoria = new Suculenta();
                break;
            case 3:
                categoria = new Samambaia();
                break;
            case 4:
                if(opcao==1){
                    if(Interacao.interfacePlantaComFlor(inserir).equalsIgnoreCase("s"))
                        categoria = new Trepadeira(true);
                    else
                        categoria = new Trepadeira();
                } else categoria = new Trepadeira();
                break;
            case 5:
                categoria = new Folhagem();
                break;
            case 6:
                if(opcao==1){
                    if(Interacao.interfacePlantaComFlor(inserir).equalsIgnoreCase("s"))
                        categoria = new Arbusto(true);
                    else
                        categoria = new Arbusto();
                } else categoria = new Arbusto();
                break;
            case 7:
                categoria = new Flor();
                break;
            case 8:
                categoria = new Bromelia();
                break;
            case 9:
                categoria = new Orquidea();
                break;
            default:
                System.out.println("Categoria inválida!");
                break;
            }
        return categoria;
    }
}