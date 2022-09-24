package br.unigran.provap1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText km;
    EditText qtdabastecida;
    EditText diaabastecido;
    EditText valor;
    List<Abastecimento> dados;
    ListView listagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //mapeia campos tela
        km=findViewById(R.id.kmId);
        qtdabastecida=findViewById(R.id.qtdabastecidaId);
        diaabastecido=findViewById(R.id.diaabastecidoID);
        valor=findViewById(R.id.valorId);
        dados= new ArrayList();//aloca lista;
        listagem=findViewById(R.id.listaId);

        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dados);
        listagem.setAdapter(adapter);

    }
}

