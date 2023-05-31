import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FrequenciaRega implements Serializable{
    public static String estacaoAtual(){
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

    public static void eParaRegar(Categoria categoria, Rega cuidado){
        int diasRega = categoria.getDiasRega();
        LocalDate dataUltimaRega = cuidado.getData();
        LocalDate dataProximaRega = dataUltimaRega.plusDays(diasRega);
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), dataProximaRega);
        System.out.println();
        if (dias>0) {
            System.out.println("Faltam " + dias  + " dia(s) para a próxima rega");
        }
        if(dataUltimaRega.plusDays(diasRega).isBefore(LocalDate.now())||dataUltimaRega.plusDays(diasRega).isEqual(LocalDate.now())){
            System.out.println("--É dia de regar sua planta!--");
            System.out.println();
        }
        System.out.println("Mas se lembre que para saber se é o dia certo para regar sua");
        System.out.println("planta, preste atenção na umidade do solo antes de tudo.");
    }

}
