package com.testcom.kidscode;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Math extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    TextView answer, answer2, life, score;;
    MediaPlayer song1, song2;
    private int lif =0;
    private int sco=0;
    private String lvl="";
    final Context con = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent i = getIntent();
        this.lif = Integer.valueOf(i.getStringExtra("life"));
        this.sco =Integer.valueOf(i.getStringExtra("score"));
        this.lvl = i.getStringExtra("lvl");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);


        btn1 = findViewById(R.id.MathBtn1);
        btn2 = findViewById(R.id.MathBtn2);
        btn3 = findViewById(R.id.MathBtn3);
        btn4 = findViewById(R.id.MathBtn4);
        answer= findViewById(R.id.MathSub1);
        answer2= findViewById(R.id.MathSub2);
        life=findViewById(R.id.MathLife);
        score=findViewById(R.id.MathBoard);
        song1=MediaPlayer.create(Math.this, R.raw.simple_beep);
        song2=MediaPlayer.create(Math.this, R.raw.beeps_beeps_simple);

        life.setText(String.valueOf(lif));
        score.setText(String.valueOf(sco));
        answer.setText("");
        answer2.setText("");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.getText().toString().equalsIgnoreCase("")){
                    answer.setText("5");
                }
                else {
                    answer2.setText("5");
                }
                btn1.setVisibility(View.INVISIBLE);
                btn1.setEnabled(false);
                fu();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.getText().toString().equalsIgnoreCase("")){
                    answer.setText("4");
                }
                else {
                    answer2.setText("4");
                }
                btn2.setVisibility(View.INVISIBLE);
                btn2.setEnabled(false);
                fu();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.getText().toString().equalsIgnoreCase("")){
                    answer.setText("6");
                }
                else {
                    answer2.setText("6");
                }
                btn3.setVisibility(View.INVISIBLE);
                btn3.setEnabled(false);
                fu();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.getText().toString().equalsIgnoreCase("")){
                    answer.setText("2");
                }
                else {
                    answer2.setText("2");
                }
                btn4.setVisibility(View.INVISIBLE);
                btn4.setEnabled(false);
                fu();
            }
        });
    }

    public void fu(){
        final Bunker gg = new Bunker();
        if (!answer.getText().toString().equalsIgnoreCase("") && !answer2.getText().toString().equalsIgnoreCase("")){
            gg.Arr(answer.getText().toString(), answer2.getText().toString(), lif, sco);
            showToast(gg.getResult());
            lif = gg.getLife();
            sco =gg.getScore();
            fu1(gg.getResult());
        }
        final Intent end = new Intent(Math.this, GameOver.class);
        if  (lif==0){
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    end.putExtra("score", String.valueOf(sco));
                    startActivity(end);
                }
            },2000);
        }
    }

    public void fu1(String a){
        final long[]pattern={1,500};
        final Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (a.equalsIgnoreCase("wrong")){
            vibe.vibrate(pattern,-1);
            song2.start();
            life.setText(String.valueOf(lif));
            score.setText(String.valueOf(sco));
            btn1.setVisibility(View.VISIBLE);
            btn1.setEnabled(true);
            btn2.setVisibility(View.VISIBLE);
            btn2.setEnabled(true);
            btn3.setVisibility(View.VISIBLE);
            btn3.setEnabled(true);
            btn4.setVisibility(View.VISIBLE);
            btn4.setEnabled(true);
            answer.setText("");
            answer2.setText("");
        }

        else if (a.equalsIgnoreCase("perfect")){
            btn1.setEnabled(false);
            btn4.setEnabled(false);
            song1.start();
            score.setText(String.valueOf(sco));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent j= new Intent(Math.this, Transition.class);
                    j.putExtra("lvl", lvl);
                    j.putExtra("life", "3");
                    j.putExtra("score",String.valueOf(sco));
                    startActivity(j);
                }
            },2000);


        }



    }



    public void showToast(String a){
        LayoutInflater inf =getLayoutInflater();
        Toast tos = new Toast(getApplicationContext());
        tos.setGravity(Gravity.CENTER,0,500);
        tos.setDuration(Toast.LENGTH_SHORT);
        if (a.equalsIgnoreCase("wrong")){
            View layout=inf.inflate(R.layout.toast_incorrect, (ViewGroup) findViewById(R.id.toast_root2));
            tos.setView(layout);
        }
        else if (a.equalsIgnoreCase("perfect")){
            View layout=inf.inflate(R.layout.toast_correct, (ViewGroup) findViewById(R.id.toast_root));
            tos.setView(layout);
        }
        tos.show();
    }

    @Override
    public void onBackPressed()
    {
        final Dialog di = new Dialog(con);
        di.requestWindowFeature(Window.FEATURE_NO_TITLE);
        di.setContentView(R.layout.dialog);

        Button btn1 = (Button) di.findViewById(R.id.DialogBtn2);
        Button btn2 = (Button) di.findViewById(R.id.DialogBtn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                di.dismiss();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Math.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();
            }
        });
        di.show();
    }
}
