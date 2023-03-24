package database.control.op;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import database.base.op.DataBaseBaseOp;
import database.base.op.DatabaseHelper;

public class userInfoop {
    private long id1=-1;        //编号
    private String username;    //用户名
    private String password;    //密码
    private String question;    //密保问题
    private String answer;      //密保答案
    private String real_name;   //是否实名
    private String Reg_time;    //注册时间
    private String UState;      //用户状态
    private String opTable="userInfo";     //需要操作的数据库表的表名
    private DatabaseHelper helper=null;    //已经封装好的数据库类DatabaseHelper定义对象
    //声明构造方法
    public userInfoop(Context context){
        DataBaseBaseOp Dbop = new DataBaseBaseOp();
        //已经封装好的数据库类DataBaseBaseOp定义对象
        Dbop.initsqlite3(context);  //调用initsqlite3初始化sqlite3数据库
        helper = Dbop.getHelper();  //获取返回值
    }
    public long Add(){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(id1 != -1){values.put("ID",id1);}
        values.put("username",username);
        values.put("password",password);
        values.put("question",question);
        values.put("answer",answer);
        values.put("real_name",real_name);
        values.put("Reg_time",Reg_time);
        values.put("UState",UState);
        id1=db.insert("userInfo",null,values);
        return id1;
    }
    public long getId1() {
        return id1;
    }
    public void setId1(long id1) {
        this.id1 = id1;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getReal_name() {
        return real_name;
    }
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }
    public String getReg_time(String dateTimeNowLong) {
        return Reg_time;
    }
    public void setReg_time(String reg_time) {
        Reg_time = reg_time;
    }
    public String getUState() {
        return UState;
    }
    public void setUState(String UState) {
        this.UState = UState;
    }

}
