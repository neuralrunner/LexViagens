package codes.neuralkatana.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import codes.neuralkatana.util.DiasUtil;
import codes.neuralkatana.util.DrawableUtil;
import codes.neuralkatana.util.MoedaUtil;
import codes.neuralkatana.R;
import codes.neuralkatana.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;


    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return 0;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = pacotes.get(posicao);
        dataBiding(viewCriada, pacote);
        return viewCriada;
    }

    //Databinding para criação da Lista
    private void dataBiding(View viewCriada, Pacote pacote) {
        //Cria as Referências
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);

        //Realiza o Databinding
        local.setText(pacote.getLocal());
        imagem.setImageResource(DrawableUtil.retornaImagemDrawable(context, pacote.getImagem()));
        dias.setText(DiasUtil.retornaDiasEmTexto(pacote.getDias()));
        preco.setText(MoedaUtil.formataBigDecimalParaReal(pacote.getPreco(), MoedaUtil.BRASIL));
    }

}
