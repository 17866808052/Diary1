package com.example.notes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import android.view.View.OnClickListener;
import com.example.notes.Manager.UserService;


import com.example.ui.R;

public class LoginActivity extends AppCompatActivity {
    Button logbtn,resbtn;
    EditText text_userid;
    EditText text_userpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
    }
    private void findViews() {
        text_userid=(EditText) findViewById(R.id.text_userid);
        text_userpwd=(EditText) findViewById(R.id.text_userpwd);
        logbtn=(Button) findViewById(R.id.logbtn);
        resbtn=(Button) findViewById(R.id.resbtn);
        logbtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String name=text_userid.getText().toString();
                String pass=text_userpwd.getText().toString();
                Log.i("TAG",name+"_"+pass);
                UserService uService=new UserService(LoginActivity.this);
                boolean flag=uService.login(name, pass);
                if(flag){
                    Log.i("TAG","登录成功");
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                }else{
                    Log.i("TAG","登录失败");
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                }
            }
        });
        resbtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

}

