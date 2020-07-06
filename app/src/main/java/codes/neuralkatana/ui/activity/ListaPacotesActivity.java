package codes.neuralkatana.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import codes.neuralkatana.R;
import codes.neuralkatana.dao.PacoteDAO;
import codes.neuralkatana.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    private static final PacoteDAO dao = new PacoteDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(R.string.pacotes);
        configuraLista();

        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        startActivity(intent);
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(dao.lista(),this));
    }
}