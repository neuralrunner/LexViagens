package codes.neuralkatana.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String FORMATO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";
    public static final Locale BRASIL = new Locale("pt", "BR");

    //pega um valor de BigDecimal e retorna em um valor de String formatado
    public static String formataBigDecimalParaReal(BigDecimal preco, Locale localidadeDaMoeda) {
        return NumberFormat.getCurrencyInstance(localidadeDaMoeda)
                .format(preco)
                .replace(FORMATO, FORMATO_COM_ESPACO);
    }
}
