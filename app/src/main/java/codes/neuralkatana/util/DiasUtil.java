package codes.neuralkatana.util;

public class DiasUtil {

    public static final String SINGULAR = " dia";
    public static final String PLURAL = " dias";
    public static final String NON_LISTADO = "Não Listado";

    //pega o número de dias e retorna um string dos mesmos para o Binding do Texto
    public static String retornaDiasEmTexto(int dias) {
        if (dias == 1) {
            return dias + SINGULAR;
        } else if (dias > 1) {
            return dias + PLURAL;
        } else {
            return NON_LISTADO;
        }
    }
}
