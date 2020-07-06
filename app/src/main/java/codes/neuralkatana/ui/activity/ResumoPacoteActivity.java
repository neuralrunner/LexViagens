package codes.neuralkatana.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import codes.neuralkatana.R;
import codes.neuralkatana.model.Pacote;
import codes.neuralkatana.ui.adapter.ListaPacotesAdapter;
import codes.neuralkatana.util.DiasUtil;
import codes.neuralkatana.util.DrawableUtil;
import codes.neuralkatana.util.FormataDataUtil;
import codes.neuralkatana.util.MoedaUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("RESUMO DO PACOTE");
        final Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraDataFormatada(pacote);
    }

    private void mostraDataFormatada(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = FormataDataUtil.formataData(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        preco.setText(MoedaUtil.formataBigDecimalParaReal(pacote.getPreco(), MoedaUtil.BRASIL));
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        dias.setText(DiasUtil.retornaDiasEmTexto(pacote.getDias()));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        imagem.setImageResource(DrawableUtil.retornaImagemDrawable(this,pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}