package br.unigran.provap1;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

import bancodedados.AbasteceDB;
import bancodedados.DBHelper;


public class MainActivity extends AppCompatActivity {

    private EditText nmr1;
    private EditText nmr2;
    private TextView resultado;

    public double valor1, valor2;

    EditText km;
    EditText qtdabastecida;
    EditText diaabastecido;
    EditText valor;
    List<Abastecimento> dados;
    ListView listagem;
    DBHelper db;
    AbasteceDB abasteceDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nmr1 = findViewById(R.id.kmId);
        nmr2 = findViewById(R.id.qtdabastecidaId);
        resultado = findViewById(R.id.textView2);


        db = new DBHelper(this);
        km=findViewById(R.id.kmId);
        qtdabastecida=findViewById(R.id.qtdabastecidaId);
        diaabastecido=findViewById(R.id.diaabastecidoID);
        valor=findViewById(R.id.valorId);
        dados= new ArrayList();//aloca lista;
        listagem=findViewById(R.id.listaId);
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dados);
        listagem.setAdapter(adapter);
        abasteceDB=new AbasteceDB(db);
        abasteceDB.lista(dados);//lista inicial
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
    public boolean verificar() {
        String s1 = km.getText().toString();
        String s2 = qtdabastecida.getText().toString();
        String s3 = diaabastecido.getText().toString();
        String s4 = valor.getText().toString();
        if ((s1.equals(null) || s2.equals(null) || s3.equals(null)|| s4.equals(null))
                || (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals(""))) {
            Toast.makeText(this, "Preencha os campos", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            valor1 = Double.parseDouble(nmr1.getText().toString());
            valor2 = Double.parseDouble(nmr2.getText().toString());
            return true;

        }

    public void salvar(View view){
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setKm(km.getText().toString());
        abastecimento.setDiaabastecido(diaabastecido.getText().toString());
        abastecimento.setQtdabastecida(qtdabastecida.getText().toString());
        abastecimento.setValor(valor.getText().toString());
        abasteceDB.inserir(abastecimento);
        abasteceDB.lista(dados);


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
    public void lista(List dados) {
        dados.clear();
        conexao = db.getReadableDatabase();
        String names[] = {"id", "quilometragem", "qtd_abastecida", "data","Valor"};
        Cursor query = conexao.query("Lista", names,
                null, null, null,
                null, "quilometragem");
        while (query.moveToNext()) {
            Abastecimento abastecimento = new Abastecimento();
            abastecimento.setId(Integer.parseInt(
                    query.getString(0)));
            abastecimento.setKm(
                    query.getString(1));
            abastecimento.setQtdabastecida(
                    query.getString(2));
            abastecimento.setDiaabastecido(
                    query.getString(3));
            abastecimento.setValor(
                    query.getString(4));
            dados.add(abastecimento);
        }
        conexao.close();
    }
}

