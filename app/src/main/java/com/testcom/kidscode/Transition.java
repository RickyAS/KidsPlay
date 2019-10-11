package com.testcom.kidscode;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.LinkedList;

public class Transition extends AppCompatActivity {
TextView title2;
    private static LinkedList<String> teh = MainActivity.returnArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

title2 =findViewById(R.id.title2);



                try {
                    Intent i = getIntent();
                    title2.setText(i.getStringExtra("lvl"));


                    String g = teh.get(Integer.valueOf(i.getStringExtra("lvl"))-1);
                    Class cls = Class.forName(g);

                    int ds = Integer.valueOf(i.getStringExtra("lvl")) +1;
                   final Intent j = new Intent(Transition.this, cls);
                    j.putExtra("lvl", Integer.toString(ds));
                    j.putExtra("life", i.getStringExtra("life"));
                    j.putExtra("score", i.getStringExtra("score"));
                    System.out.println(g);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(j);
                        }
                    },2000);



                } catch(Exception e) {
                    System.out.println("FUCK!!!!!!!!!!!!!");
                    Intent a = getIntent();
                    Intent i = new Intent(Transition.this, EndGame.class);
                    i.putExtra("score",a.getStringExtra("score") );
                    startActivity(i);

                }


    }
}
