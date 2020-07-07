package codes.neuralkatana.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import codes.neuralkatana.R;
import codes.neuralkatana.model.Pacote;
import codes.neuralkatana.util.MoedaUtil;

import static codes.neuralkatana.ui.activity.PacotesActivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String PAGAMENTO = "PAGAMENTO";
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(PAGAMENTO);
        //final Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        Intent intent = getIntent();

        if (intent.hasExtra(CHAVE_PACOTE)) {
            pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos();
        }

    }

    private void inicializaCampos() {
        mostraPreco(pacote);
        finalizarCompraBotao();
    }

    private void finalizarCompraBotao() {
        Button finalizarCompra = findViewById(R.id.pagamento_botao_finalizar_compra);
        finalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoDaCompra();
            }
        });
    }

    private void vaiParaResumoDaCompra() {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        preco.setText(MoedaUtil.formataBigDecimalParaReal(pacote.getPreco(), MoedaUtil.BRASIL));
    }
}