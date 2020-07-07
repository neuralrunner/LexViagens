package codes.neuralkatana.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

import codes.neuralkatana.R;
import codes.neuralkatana.model.Pacote;
import codes.neuralkatana.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String PAGAMENTO = "PAGAMENTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(PAGAMENTO);
        final Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        mostraPreco(pacote);

        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        preco.setText(MoedaUtil.formataBigDecimalParaReal(pacote.getPreco(),MoedaUtil.BRASIL));
    }
}