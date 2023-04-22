import java.util.ArrayList;
import java.util.Scanner;

public class Plantas {
    private ArrayList<Planta> plantas = new ArrayList<>();

    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public void adicionarPlanta(Categoria categoria){
        Planta planta = new Planta();
        try (Scanner inserir = new Scanner(System.in)) {
            System.out.println("-Insira nome: ");
            String nome = inserir.nextLine();
            inserir.nextLine();
            System.out.println("-Insira idade: ");
            int idade = inserir.nextInt();
            inserir.nextLine();
            planta.setNomePopular(nome);
            planta.setIdade(idade);
            planta.adicionarCuidado(null);
            categoria.adicionarPlanta(planta);
            planta.setCategoria(categoria);
            this.plantas.add(planta);
        }
    }


    public void listarInformacoesGerais(){
        for (Planta planta : plantas) {
            System.out.println("----------------------------------");
            planta.mostrarInformacoes();
            System.out.println("----------------------------------");
        }
    }

    public void listarInformacoesCuidados(){
        for (Planta planta : plantas) {
            System.out.println("----------------------------------");
            System.out.println("-Nome: " + planta.getNomePopular());
            planta.mostrarCuidados();
            System.out.println("----------------------------------");
        }
    }

}
