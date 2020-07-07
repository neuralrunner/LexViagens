package codes.neuralkatana.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import codes.neuralkatana.R;
import codes.neuralkatana.model.Pacote;
import codes.neuralkatana.util.DiasUtil;
import codes.neuralkatana.util.DrawableUtil;
import codes.neuralkatana.util.FormataDataUtil;
import codes.neuralkatana.util.MoedaUtil;

import static codes.neuralkatana.ui.activity.PacotesActivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("RESUMO DO PACOTE");

        Intent intent = getIntent();

        if (intent.hasExtra(CHAVE_PACOTE)) {
            pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos();
        }
    }

    private void inicializaCampos() {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraDataFormatada(pacote);
        realizaPagamentoBotao();
    }

    private void realizaPagamentoBotao() {
        Button realizarPagamento = findViewById(R.id.resumo_pacote_botao_realizar_pagamento);
        realizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamento();
            }
        });
    }

    private void vaiParaPagamento() {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
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
        imagem.setImageResource(DrawableUtil.retornaImagemDrawable(this, pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }


}