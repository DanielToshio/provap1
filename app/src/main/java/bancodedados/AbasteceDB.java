package bancodedados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;
import java.util.LinkedList;

import br.unigran.provap1.Abastecimento;

public class AbasteceDB {

    private DBHelper db;
    private SQLiteDatabase conexao;
    public AbasteceDB(DBHelper db) {this.db=db;}
    public void inserir (Abastecimento abastecimento){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("km",abastecimento.getKm());
        valores.put("qtdabastecida",abastecimento.getQtdabastecida());
        valores.put("diaabastecido",abastecimento.getDiaabastecido());
        valores.put("valor",abastecimento.getValor());

        conexao.insertOrThrow("Abastecimento",null,valores);
        conexao.close();
    }

    public void inserir(Abastecimento abastecimento){
        conexao = db.getWritableDatabase();//abri o bd

    }
    public void atualizar(){}
    public void remover(int id){
        conexao=db.getWritableDatabase();
        conexao.delete("Abastecimento","id=?",
                new String[]{id+""});
    }
    public void lista(List dados){
        dados.clear();
        conexao=db.getReadableDatabase();
        String names[]={"km","qtdabastecida","diaabastecido","valor"};
        Cursor query = conexao.query("Abastecimento", names,
                null, null, null,
                null, "km");
        while (query.moveToNext()){
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
