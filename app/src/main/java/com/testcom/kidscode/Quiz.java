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

public class Quiz extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;
    TextView txtview, life, score;;
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
        setContentView(R.layout.activity_quiz);
        btn1 = findViewById(R.id.QuizBtn1);
        btn2 = findViewById(R.id.QuizBtn2);
        btn3 = findViewById(R.id.QuizBtn3);
        btn4 = findViewById(R.id.QuizBtn4);
        life=findViewById(R.id.QuizLife);
        score=findViewById(R.id.QuizBoard);
        song1=MediaPlayer.create(Quiz.this, R.raw.simple_beep);
        song2=MediaPlayer.create(Quiz.this, R.raw.beeps_beeps_simple);

        life.setText(String.valueOf(lif));
        score.setText(String.valueOf(sco));

        final long[]pattern={1,500};
        final Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                fu1();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent j= new Intent(Quiz.this, Transition.class);
                        j.putExtra("lvl", i.getStringExtra("lvl"));
                        j.putExtra("life", "3");
                        j.putExtra("score", String.valueOf(sco));
                        startActivity(j);
                    }
                },2000);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fu();
                vibe.vibrate(pattern,-1);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fu();
                vibe.vibrate(pattern,-1);
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fu();
                vibe.vibrate(pattern,-1);
            }
        });


    }

    public void fu(){
        song2.start();
        showToast("wrong");
        final Bunker gg = new Bunker();
        final Intent end = new Intent(Quiz.this, GameOver.class);
        gg.test(lif,sco);
        lif = gg.getLife();
        sco = gg.getScore();
        life.setText(String.valueOf(lif));
        score.setText(String.valueOf(sco));
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
            }, 2000);

        }
    }

    public void fu1(){
        song1.start();
        showToast("perfect");
        final Bunker gg = new Bunker();
        gg.test(sco);
        sco = gg.getScore();
        score.setText(String.valueOf(sco));
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
                Intent intent = new Intent(Quiz.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();
            }
        });
        di.show();
    }
}
