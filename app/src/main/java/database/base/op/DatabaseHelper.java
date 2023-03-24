package database.base.op;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="";
        sql="create table userInfo(" +
                "ID         INTEGER PRIMARY KEY autoincrement NOT NULL,"  +
                "username   varchar(20) not null," +
                "password   varchar(20) not null," +
                "question   varchar(50) not null," +
                "answer     varchar(50) not null," +
                "real_name  varchar(10) not null," +
                "Reg_time   varchar(30) not null," +
                "UState     varchar(10) not null" +
                ")";/*创建userInfo数据表SQL语句的字符串，
                String类型的sql变量中存放的是创建userInfo数据表的SQL语句字符串*/
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
