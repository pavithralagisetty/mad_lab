package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pid);
    }
    public void signup(View v)
    {
        if(password.getText().toString().length()>=8&&validate(password.getText().toString()))
        {
            Toast.makeText(this,"successfull",Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,MainActivity2.class);
            Bundle b=new Bundle();
            b.putString("uid",username.getText().toString());
            b.putString("pid",password.getText().toString());
            i.putExtras(b);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"passw is not satisfying",Toast.LENGTH_LONG).show();
        }

    }
    public boolean validate(String password)
    {
        Pattern ptrn;
        Matcher mat;
        String passwordpat="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#$@%^&]).{8,}";
        ptrn=Pattern.compile(passwordpat);
        mat= ptrn.matcher(password);
        return mat.matches();
    }
}
