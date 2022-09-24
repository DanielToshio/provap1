package br.unigran.provap1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

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
        acoes();

    }

    private void acoes() {
        listagem.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView,
                                                   View view, int i, long l) {
                        new AlertDialog.Builder(view.getContext())
                                .setMessage("Deseja realmente remover")
                                .setPositiveButton("Confirmar",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface,
                                                                int i) {
                                                
                                            }
                                        })
                                .setNegativeButton("cancelar",null)
                                .create().show();
                        return false;
                    }
                });

    }

    public void salvar(View view){
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setKm(km.getText().toString());
        abastecimento.setDiaabastecido(diaabastecido.getText().toString());
        abastecimento.setQtdabastecida(qtdabastecida.getText().toString());
        abastecimento.setValor(valor.getText().toString());


        Snackbar.make(this,view,"ertrt", BaseTransientBottomBar.LENGTH_SHORT).
//                setAction(R.string.app_name, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                }).
        show();
        Toast.makeText(this,"Salvo com sucesso",Toast.LENGTH_SHORT).show();
    }
}

