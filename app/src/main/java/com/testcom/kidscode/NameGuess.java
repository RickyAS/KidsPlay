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

public class NameGuess extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    TextView answer, life, score;;
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
        setContentView(R.layout.activity_name_guess);
        btn1 = findViewById(R.id.NGBtn1);
        btn2 = findViewById(R.id.NGBtn2);
        btn3 = findViewById(R.id.NGBtn3);
        btn4 = findViewById(R.id.NGBtn4);
        btn5 = findViewById(R.id.NGBtn5);
        btn6 = findViewById(R.id.NGBtn6);
        btn7 = findViewById(R.id.NGBtn7);
        btn8 = findViewById(R.id.NGBtn8);
        btn9 = findViewById(R.id.NGBtn9);
        btn10 = findViewById(R.id.NGBtn10);
        answer = findViewById(R.id.NGSub);
        life=findViewById(R.id.NGLife);
        score=findViewById(R.id.NGBoard);
        song1= MediaPlayer.create(NameGuess.this, R.raw.simple_beep);
        song2=MediaPlayer.create(NameGuess.this, R.raw.beeps_beeps_simple);

        life.setText(String.valueOf(lif));
        score.setText(String.valueOf(sco));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"A");
                btn1.setVisibility(View.INVISIBLE);
                btn1.setEnabled(false);
                fu();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"B");
                btn2.setVisibility(View.INVISIBLE);
                btn2.setEnabled(false);
                fu();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"E");
                btn3.setVisibility(View.INVISIBLE);
                btn3.setEnabled(false);
                fu();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"H");
                btn4.setVisibility(View.INVISIBLE);
                btn4.setEnabled(false);
                fu();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"K");
                btn5.setVisibility(View.INVISIBLE);
                btn5.setEnabled(false);
                fu();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"L");
                btn6.setVisibility(View.INVISIBLE);
                btn6.setEnabled(false);
                fu();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"O");
                btn7.setVisibility(View.INVISIBLE);
                btn7.setEnabled(false);
                fu();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"R");
                btn8.setVisibility(View.INVISIBLE);
                btn8.setEnabled(false);
                fu();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"U");
                btn9.setVisibility(View.INVISIBLE);
                btn9.setEnabled(false);
                fu();
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(answer.getText()+"Z");
                btn10.setVisibility(View.INVISIBLE);
                btn10.setEnabled(false);
                fu();
            }
        });

    }

    public void fu(){

        final Bunker gg = new Bunker();
        if (answer.getText().toString().length()==5){
            gg.Arr(answer.getText().toString(), lif, sco);
            showToast(gg.getResult());
            lif = gg.getLife();
            sco =gg.getScore();
            fu1(gg.getResult());
        }
        final Intent end = new Intent(NameGuess.this, GameOver.class);
        if  (lif==0){
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn10.setEnabled(false);
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
            btn5.setVisibility(View.VISIBLE);
            btn5.setEnabled(true);
            btn6.setVisibility(View.VISIBLE);
            btn6.setEnabled(true);
            btn7.setVisibility(View.VISIBLE);
            btn7.setEnabled(true);
            btn8.setVisibility(View.VISIBLE);
            btn8.setEnabled(true);
            btn9.setVisibility(View.VISIBLE);
            btn9.setEnabled(true);
            btn10.setVisibility(View.VISIBLE);
            btn10.setEnabled(true);
            answer.setText("");
        }

        else if (a.equalsIgnoreCase("perfect")){
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn9.setEnabled(false);
            song1.start();
            score.setText(String.valueOf(sco));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent j= new Intent(NameGuess.this, Transition.class);
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
                Intent intent = new Intent(NameGuess.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();
            }
        });
        di.show();
    }
}
