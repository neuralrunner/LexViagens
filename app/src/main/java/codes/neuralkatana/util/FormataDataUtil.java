package codes.neuralkatana.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import codes.neuralkatana.model.Pacote;

public class FormataDataUtil {
    public static String formataData(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
        String dataFormatadaIda = formatoBrasileiro.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBrasileiro.format(dataVolta.getTime());
        return dataFormatadaIda +
                " - " + dataFormatadaVolta +
                " de " + dataVolta.get(Calendar.YEAR);
    }
}
