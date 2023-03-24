package activity.control.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.recitewords.bdc.R;

public class User_Login extends Activity {
    EditText edit_username,edit_password;
    Button btn_Login;
    TextView txt_forgetpassword;
    TextView txt_Register=null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        //自定义标题，去掉系统的标题栏
        setContentView(R.layout.user_login);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title);
        edit_username=(EditText) findViewById(R.id.edit_username);
        edit_password=(EditText) findViewById(R.id.edit_password);
        btn_Login=(Button) findViewById(R.id.bth_Login);
        txt_forgetpassword=(TextView)findViewById(R.id.txt_ForgetPassword);

        MyOnclick click=new MyOnclick();//以MyOnclick类定义对象click，并实例化
        btn_Login.setOnClickListener(click);
        //setOnClickListner是给控件（btn_Login）绑定监听器
        //参数是一个监听器（MyOnclick类对象click）
        txt_forgetpassword.setOnClickListener(click);
        txt_Register=(TextView) findViewById(R.id.txt_Register);
        txt_Register.setOnClickListener(click);
    }
    class MyOnclick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            String usernameString=edit_username.getText().toString();
            //对edit_username使用getText()获取EditText控件上输入的用户名，并转换为String类型赋给String变量usernameString
            String passwordString=edit_password.getText().toString();
            //获取密码的值赋给passwordString变量
            //Log.i("User_Login","onClick:"+usernameString+""+passwordString);

            Intent intent=new Intent();
            switch (v.getId()){//获取点击的控件的编号
                case R.id.bth_Login:
                    Toast.makeText(User_Login.this,"输入的用户名和密码是："+usernameString+"   "+passwordString,Toast.LENGTH_SHORT).show();;
                    //用Toast类的makeText方法输出获取的用户名和密码
                    break;
                case R.id.txt_ForgetPassword:
                    intent.setClass(User_Login.this, User_ForgetPassword.class);
                    startActivity(intent);
                    break;
                case R.id.txt_Register:
                    intent.setClass(User_Login.this,User_Regist.class);
                    break;
                    //如果有多个控件触发时间，可以增加多个case语句
            }
            startActivity(intent);
        }

    }
}
