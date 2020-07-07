package codes.neuralkatana.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import codes.neuralkatana.R;
import codes.neuralkatana.model.Pacote;
import codes.neuralkatana.util.DiasUtil;
import codes.neuralkatana.util.DrawableUtil;
import codes.neuralkatana.util.FormataDataUtil;
import codes.neuralkatana.util.MoedaUtil;

import static codes.neuralkatana.ui.activity.PacotesActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle("RESUMO DA COMPRA");

        Intent intent = getIntent();

        if (intent.hasExtra(CHAVE_PACOTE)) {
            pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos();
        }
    }

    private void inicializaCampos() {
        mostraImagem(pacote);
        mostraLocal(pacote);
        mostraDataFormatada(pacote);
        mostraPreco(pacote);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ResumoCompraActivity.this, ListaPacotesActivity.class);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.final_texto_preco);
        preco.setText(MoedaUtil.formataBigDecimalParaReal(pacote.getPreco(), MoedaUtil.BRASIL));
    }

    private void mostraDataFormatada(Pacote pacote) {
        TextView data = findViewById(R.id.final_texto_data);
        String dataFormatadaDaViagem = FormataDataUtil.formataData(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.final_texto_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.final_image_local);
        imagem.setImageResource(DrawableUtil.retornaImagemDrawable(this, pacote.getImagem()));
    }


}