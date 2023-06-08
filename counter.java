package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Handler myhandler=new Handler();
int t,i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.countervalue);

    }
    public void startcounter(View v)
    {
        int i=0;
        myhandler.postDelayed(Threadcount,0);


    }
    public void stopcounter(View v)
    {
        myhandler.removeCallbacks(Threadcount);
    }

    public Runnable Threadcount=new Runnable() {
        @Override
        public void run() {
            tv.setText(""+i);
            i++;
            myhandler.postDelayed(Threadcount,0);
        }
    };
}
