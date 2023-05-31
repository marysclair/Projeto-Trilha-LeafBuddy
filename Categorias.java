import java.lang.reflect.Method;
import java.util.Scanner;

public class Categorias{
    public static void imprimirNomeCategorias(){
        for(NomeCategorias nomeCategorias : NomeCategorias.values()){
            System.out.println("[" + nomeCategorias.getValor() + "]- " + nomeCategorias.toString());
        }
    }

    public static void imprimirCategorias(){
        Class<Categoria> categoriaClass = Categoria.class;
        Class<?>[] subclasses = categoriaClass.getDeclaredClasses();

        for (Class<?> subclass : subclasses) {
            try {
                Method listarInformacoesMethod = subclass.getMethod("listarInformacoes");
                listarInformacoesMethod.invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

    public static Categoria criarCategoria(int valor, Scanner inserir){
        Categoria categoria = null;
        switch (valor) {
            case 1:
                categoria = new Cacto();
                break;
            case 2:
                if(Interacao.interfacePlantaComFlor(inserir).equalsIgnoreCase("s"))
                    categoria = new Suculenta(true);
                else
                    categoria = new Suculenta();
                break;
            case 3:
                categoria = new Samambaia();
                break;
            case 4:
                if(Interacao.interfacePlantaComFlor(inserir).equalsIgnoreCase("s"))
                    categoria = new Trepadeira(true);
                else
                    categoria = new Trepadeira();
                break;
            case 5:
                categoria = new Folhagem();
                break;
            case 6:
                if(Interacao.interfacePlantaComFlor(inserir).equalsIgnoreCase("s"))
                    categoria = new Arbusto(true);
                else
                    categoria = new Arbusto();
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