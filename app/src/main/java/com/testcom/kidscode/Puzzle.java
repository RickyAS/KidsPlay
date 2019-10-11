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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



public class Puzzle extends AppCompatActivity {
ImageButton pic1, pic2, pic3, pic4;
TextView life, score;
MediaPlayer song1, song2;
private int lif =0;
private int sco=0;
    final Context con = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Intent i = getIntent();
         this.lif = Integer.valueOf(i.getStringExtra("life"));
         this.sco =Integer.valueOf(i.getStringExtra("score"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        pic1=findViewById(R.id.PuzzlePic1);
        pic2=findViewById(R.id.PuzzlePic2);
        pic3=findViewById(R.id.PuzzlePic3);
        pic4=findViewById(R.id.PuzzlePic4);
        life=findViewById(R.id.PuzzleLife);
        score=findViewById(R.id.PuzzleBoard);
        song1=MediaPlayer.create(Puzzle.this, R.raw.simple_beep);
        song2=MediaPlayer.create(Puzzle.this, R.raw.beeps_beeps_simple);

        life.setText(String.valueOf(lif));
        score.setText(String.valueOf(sco));

        final long[]pattern={1,500};
        final Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fu();
                vibe.vibrate(pattern,-1);
            }
        });

        pic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fu();
                vibe.vibrate(pattern,-1);

            }
        });

        pic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        pic1.setEnabled(false);
        pic2.setEnabled(false);
        pic3.setEnabled(false);
        pic4.setEnabled(false);
                fu1();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent j= new Intent(Puzzle.this, Transition.class);
                        j.putExtra("lvl", i.getStringExtra("lvl"));
                        j.putExtra("life", "3");
                        j.putExtra("score", String.valueOf(sco));
                        startActivity(j);
                    }
                },2000);

            }
        });

        pic4.setOnClickListener(new View.OnClickListener() {
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
        final Intent end = new Intent(Puzzle.this, GameOver.class);
        gg.test(lif,sco);
        lif = gg.getLife();
        sco = gg.getScore();
        life.setText(String.valueOf(lif));
        score.setText(String.valueOf(sco));
        if  (lif==0){
            pic1.setEnabled(false);
            pic2.setEnabled(false);
            pic3.setEnabled(false);
            pic4.setEnabled(false);
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
                Intent intent = new Intent(Puzzle.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();
            }
        });
        di.show();
    }


}
