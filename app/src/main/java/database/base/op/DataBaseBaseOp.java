package database.base.op;

import android.content.Context;

public class DataBaseBaseOp {
    DatabaseHelper helper = null;
    //变量helper的Get方法
    public DatabaseHelper getHelper(){return helper;}
    //变量helper的Set方法
    public void SetHelper(DatabaseHelper helper){this.helper=helper;}
    public void initsqlite3(Context content){
        helper = new DatabaseHelper(content, "bdcTest.db",null,5);
        //数据库初始化，数据库库名为bdcTest.db
    }
}
