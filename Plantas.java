import java.util.ArrayList;
// import java.util.Scanner;

public class Plantas {
    private ArrayList<Planta> plantas = new ArrayList<>();

    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public boolean taVazia(){
        if (plantas.isEmpty())
            return true;
        else
            return false;
    }

    public void adicionarPlanta(int valor, Categorias categorias){
        Planta planta = new Planta();
        Interacao interacao = new Interacao();
        Categoria categoria = categorias.preencherCategoria(valor);
        interacao.lerDados(planta);
        planta.setCategoria(categoria);
        System.out.println();
        System.out.println("Prontinho! Confira se os dados estão corretos:");
        System.out.println("-----------------------------------------------");
        planta.mostrarInformacoes();
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println("-------------------CATEGORIA-------------------");
        planta.getCategoria().listarInformacoes();
        System.out.println("-----------------------------------------------");
        System.out.println();
        this.plantas.add(planta);
        System.out.println("Planta cadastrada com sucesso! :)");
        System.out.println();
    }


    public void listarInformacoesGerais(){
        System.out.println();
        for (Planta planta : plantas) {
            System.out.println("----------------------------------");
            planta.mostrarInformacoes();
            System.out.println("----------------------------------");
        }
        System.out.println();
    }

    public void listarInformacoesCuidadosRecente(){
        System.out.println();
        for (Planta planta : plantas) {
            System.out.println("----------------------------------");
            System.out.println("-Nome: " + planta.getNomePopular());
            planta.mostrarUltimoCuidado();
            System.out.println("----------------------------------");
        }
        System.out.println();
    }

    public void listarInformacoesCuidados(){
        System.out.println();
        for (Planta planta : plantas) {
            System.out.println("----------------------------------");
            System.out.println("-Nome: " + planta.getNomePopular());
            planta.mostrarCuidados();
            System.out.println("----------------------------------");
        }
        System.out.println();
    }

}
