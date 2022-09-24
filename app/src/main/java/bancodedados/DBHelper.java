package bancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
        public DBHelper(@Nullable Context context) {
            super(context, "BancoAbastecimento", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(
                    "create table abastecimento(" +
                            "id integer primary key autoincrement," +
                            "km varchar(150)," +
                            "qtdabastecida varchar(150)," +
                            "diaabastecido varchar(150)," +
                            "valor varchar(20))"

            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL(
//                "alter table agenda"
//        );
        }
    }


