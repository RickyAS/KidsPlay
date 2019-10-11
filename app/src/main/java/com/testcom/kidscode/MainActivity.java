package com.testcom.kidscode;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
Button play;
ToggleButton music;

    final Context con = this;
    private static LinkedList <String> teh = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
play=findViewById(R.id.btnplay);

music=findViewById(R.id.btnsong);

        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Dom gg = new Dom();
                System.out.println("SIZE!!!!!!!!!!"+teh.size());
            if (!teh.isEmpty()){
             teh.remove("com.testcom.kidscode.Puzzle");
             teh.remove("com.testcom.kidscode.Arrange");
             teh.remove("com.testcom.kidscode.Math");
                teh.remove("com.testcom.kidscode.NameGuess");
                teh.remove("com.testcom.kidscode.Quiz");
            }
                System.out.println("SIZE!!!!!!!!!!"+teh.size());
                gg.rand();
                teh.add(gg.getStage1());
                teh.add(gg.getStage2());
                teh.add(gg.getStage3());
                teh.add(gg.getStage4());
                teh.add(gg.getStage5());

                Intent i = new Intent(MainActivity.this, Transition.class);

                i.putExtra("lvl","1");
                i.putExtra("life","3");
                i.putExtra("score","25");
                startActivity(i);
            }
        });



        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    startService(new Intent(MainActivity.this, SongService.class));

                }

                else {
                    stopService(new Intent(MainActivity.this,SongService.class));
                }
            }

        }
        );

    }



    public static LinkedList<String> returnArray()
    {
        return teh;
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
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();
            }
        });
        di.show();
    }
}
