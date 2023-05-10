import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class FrequenciaRega implements Serializable{
    private int dias;

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String estacaoAtual(){
        LocalDate dataAtual = LocalDate.now();
        int diaDoAno = dataAtual.getDayOfYear();

        String estacao;
        if (diaDoAno >= 80 && diaDoAno < 173) {
            estacao = "outono";
        } else if (diaDoAno >= 173 && diaDoAno < 266) {
            estacao = "inverno";
        } else if (diaDoAno >= 266 && diaDoAno < 355) {
            estacao = "primavera";
        } else {
            estacao = "verao";
        }
        return estacao;
    }

    public void eParaRegar(Categoria categoria, ArrayList<Cuidado> historicoDeCuidados){
        int diasRega = categoria.getDiasRega();
        LocalDate dataUltimaRega = historicoDeCuidados.get(historicoDeCuidados.size()-1).getDataUltimaRega();
        LocalDate dataProximaRega = dataUltimaRega.plusDays(diasRega);
        long dias = ChronoUnit.DAYS.between(dataUltimaRega, dataProximaRega);
        System.out.println();
        System.out.println("Faltam " + dias  + " dias para a próxima rega");
        if(dataUltimaRega.plusDays(diasRega).isBefore(LocalDate.now())||dataUltimaRega.plusDays(diasRega).isEqual(LocalDate.now())){
            System.out.println("--É dia de regar sua planta!--");
            System.out.println();
        }
        System.out.println("Mas se lembre que para saber se é o dia certo para regar sua");
        System.out.println("planta, preste atenção na umidade do solo antes de tudo.");
    }

}
