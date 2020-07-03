package com.example.notes.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.notes.Manager.UserService;
import com.example.notes.Manager.User;
import com.example.ui.R;

public class RegisterActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    RadioGroup sex;
    Button res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        res.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String name=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String sexstr=((RadioButton)RegisterActivity.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
                Log.i("TAG",name+"_"+pass+"_"+sexstr);
                UserService uService=new UserService(RegisterActivity.this);
                User user=new User();
                user.setUsername(name);
                user.setPassword(pass);
                user.setSex(sexstr);
                uService.register(user);
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                finish();
                overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
            }
        });
    }
    public void fh(View view) {
        finish();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
    private void findViews() {
        username=(EditText) findViewById(R.id.text_userid);
        password=(EditText) findViewById(R.id.text_userpwd);
        sex=(RadioGroup) findViewById(R.id.sex);
        res=(Button) findViewById(R.id.res);
    }

}




