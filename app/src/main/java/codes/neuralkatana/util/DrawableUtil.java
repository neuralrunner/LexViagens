package codes.neuralkatana.util;

import android.content.Context;

public class DrawableUtil {

    public static final String DRAWABLE = "drawable";

    public static int retornaImagemDrawable(Context context, String drawableEmTexto) {
        //Pega o ID da Imagem
        return context.getResources()
                .getIdentifier(drawableEmTexto, DRAWABLE, context.getPackageName());
    }
}
