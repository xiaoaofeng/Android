package com.recitewords.bdc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import activity.control.user.User_Login;

public class Index extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Intent intent=new Intent();
        intent.setClass(Index.this, User_Login.class);
        startActivity(intent);
    }
}
