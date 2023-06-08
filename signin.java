package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
EditText username,password;
int attemp=0;
Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username=findViewById(R.id.suid);
        password=findViewById(R.id.spid);
        signin=findViewById(R.id.signin);
    }
    public void signing(View v)
    {
        Bundle b=getIntent().getExtras();
        String uname=b.getString("uid");
        String passwd=b.getString("pid");
        if(username.getText().toString().equals(uname)&&password.getText().toString().equals(passwd))
        {
            Toast.makeText(this,"successful",Toast.LENGTH_LONG).show();
            attemp=0;
            Intent i=new Intent(this,success.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"unsuccessful"+attemp,Toast.LENGTH_LONG).show();
            attemp++;
            if(attemp==2)
                signin.setEnabled(false);
        }
    }
}
