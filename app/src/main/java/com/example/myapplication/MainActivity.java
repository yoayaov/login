package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
                String pwd = ((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString();
                boolean flag = false;//用于记录登录是否成功的标记变量
                String nickname = "";//保存昵称的变量
                for (int i = 0; i < Data.USER.length; i++){
                    if(number.equals(Data.USER[i][0])){     //判断账号是否正确
                        if (pwd.equals(Data.USER[i][1])){   //判断密码是否正确
                            nickname = Data.USER[i][2];     //获取昵称
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag){
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nickname",nickname);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"输入的账号或密码错误",Toast.LENGTH_SHORT);
                }
            }
        });
        Button exit =  findViewById(R.id.button2);
        exit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    public void close(View view) {
        finish();
    }
}