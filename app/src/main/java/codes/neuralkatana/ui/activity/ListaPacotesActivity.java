package codes.neuralkatana.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import codes.neuralkatana.R;
import codes.neuralkatana.dao.PacoteDAO;
import codes.neuralkatana.model.Pacote;
import codes.neuralkatana.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    private static final PacoteDAO dao = new PacoteDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(dao.lista(),this));
    }
}