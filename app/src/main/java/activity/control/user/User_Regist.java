package activity.control.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.recitewords.bdc.R;

import java.sql.Date;
import java.text.SimpleDateFormat;
import database.control.op.userInfoop;

public class User_Regist extends Activity {
    EditText edit_username,edit_password,edit_repassword,edit_question,edit_answer;
    Button submit,back;
    userInfoop uop=null;    //userInfoop类定义对象uop

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.user_regist);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title);
        uop=new userInfoop(this);
        edit_username=(EditText) findViewById(R.id.edit_username);
        edit_password=(EditText) findViewById(R.id.edit_password);
        edit_repassword=(EditText) findViewById(R.id.edit_repassword);
        edit_question=(EditText) findViewById(R.id.edit_question);
        edit_answer=(EditText) findViewById(R.id.edit_answer);
        submit=(Button) findViewById(R.id.submit);
        back=(Button) findViewById(R.id.back);
        submit.setOnClickListener(new MyButton());
        back.setOnClickListener(new MyButton());
    }
    class MyButton implements View.OnClickListener{
        @Override
        public void onClick(View v){
            switch (v.getId())
            {
                case R.id.submit:
                    //调用userInfoop类的构造方法，将当前的Activity作为参数
                    uop.setUsername(edit_username.getText().toString());
                    //获取界面上输入的用户名，赋给uop对象的Username变量
                    uop.setPassword(edit_password.getText().toString());
                    //获取界面上输入的密码，赋给uop对象的Password变量
                    uop.setQuestion(edit_question.getText().toString());
                    //获取界面上输入的密保问题，赋给uop对象的question变量
                    uop.setAnswer(edit_answer.getText().toString());
                    //获取界面上输入的密保答案，赋给uop对象的answer变量
                    uop.setReal_name("no");//设置实名认证状态为”no“,为”未认证“
                    uop.getReg_time(getDateTimeNowLong());
                    //调用自定义方法getDateTimeNowLong()，获取当前时间，赋给uop对象的Reg_time变量
                    uop.setUState("1");//设置用户账户状态为“1”，为正常状态
                    long id1=uop.Add();
                    //调用uop的Add方法，插入相关数据，并返回插入后编号的值
                    //编号若为非负，数据插入成功；否则失败
                    if(id1>=1){
                        Toast.makeText(User_Regist.this,"注册成功！",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent();
                        intent.setClass(User_Regist.this,User_Login.class);
                        //跳转到登录界面
                        startActivity(intent);
                        break;
                    }else {
                        Toast.makeText(User_Regist.this,"注册失败! 请与管理员联系!",Toast.LENGTH_SHORT).show();
                        break;
                    }
                case R.id.back:
                    Intent intent=new Intent();
                    intent.setClass(User_Regist.this,User_Login.class);
                    //跳转登录界面
                    startActivity(intent);
                    break;
            }
        }
    }
    public String getDateTimeNowLong(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String DownLoadTime1 = formatter.format(curDate);
        return DownLoadTime1;
    }

}
