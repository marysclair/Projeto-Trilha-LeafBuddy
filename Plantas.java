import java.io.Serializable;
import java.util.ArrayList;
// import java.util.Scanner;
import java.util.Scanner;

public class Plantas implements Serializable{
    private ArrayList<Planta> plantas = new ArrayList<>();
    private static final long serialVersionUID = 2880921618237199882L;


    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public boolean taVazia(){
        if (plantas.isEmpty())
            return true;
        else
            return false;
    }

    public Planta criarPlanta(Scanner inserir){
        Categorias categorias = new Categorias();
        Interacao interacao = new Interacao();
        Planta planta = null;
        int valor = interacao.interfaceCategoria(categorias, inserir);
        Categoria categoria = categorias.preencherCategoria(valor);
        if(categoria!=null){
            planta = interacao.lerPlanta(inserir);
            planta.setCategoria(categoria);
            System.out.println();
            System.out.println("Prontinho! Confira se os dados estão corretos:");
            System.out.println("------------------------------------------------------------");
            planta.mostrarInformacoes();
            System.out.println("------------------------------------------------------------");
            System.out.println();
            System.out.println("--------------------------CATEGORIA-------------------------");
            planta.getCategoria().listarInformacoes();
            System.out.println("------------------------------------------------------------");
            System.out.println();
        }
        return planta;
    }

    public void adicionarPlanta(Planta planta){
        this.plantas.add(planta);
    }

    public void removerPlanta(Planta planta){
        if (planta==null) {
            System.out.println();
            System.out.println("---Id inválido---");
            System.out.println();
        }
        else this.plantas.remove(planta);
    }


    public void listarInformacoesGerais(){
        if(taVazia())
            System.out.println("Não existe plantas cadastradas ainda no sistema.");
        else{
            System.out.println();
            for (Planta planta : plantas) {
                System.out.println("------------------------------------------------------------");
                planta.mostrarInformacoes();
                System.out.println("------------------------------------------------------------");
            }
        }
        System.out.println();
    }

    public void listarInformacoesCuidadosRecente(){
        if(taVazia())
            System.out.println("Não existe plantas cadastradas ainda no sistema.");
        else{
            System.out.println();
            for (Planta planta : plantas) {
                System.out.println("------------------------------------------------------------");
                System.out.println("-Nome: " + planta.getNomePopular());
                planta.mostrarUltimoCuidado();
                System.out.println("------------------------------------------------------------");
            }
            System.out.println();
        }
    }

    public void listarInformacoesCuidados(){
        if(taVazia())
            System.out.println("Não existe plantas cadastradas ainda no sistema.");
        else{
            System.out.println();
            for (Planta planta : plantas) {
                System.out.println("------------------------------------------------------------");
                System.out.println("-Nome: " + planta.getNomePopular());
                System.out.println();
                planta.mostrarCuidados();
                System.out.println("------------------------------------------------------------");
            }
            System.out.println();
        }
    }

    public void listarPlantasFavoritas(){
        boolean vazia = false;
        System.out.println();
            for (Planta planta : plantas) {
                if(planta.isFavorita()==true){
                    vazia = true;
                    System.out.println("------------------------------------------------------------");
                    planta.mostrarInformacoes();
                    System.out.println("------------------------------------------------------------");
                }
            }
            System.out.println();
        if(vazia==false){
            System.out.println("Não existe plantas favoritas ainda no sistema.");
        }
    }
}
