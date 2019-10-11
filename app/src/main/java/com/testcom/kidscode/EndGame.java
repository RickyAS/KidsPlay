package com.testcom.kidscode;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {
    Button ok;
    TextView score;
    final Context con = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        ok = findViewById(R.id.EGBut);
        score = findViewById(R.id.EGsub1);

        Intent i = getIntent();
        score.setText(i.getStringExtra("score"));
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent h = new Intent(EndGame.this, MainActivity.class);
                h.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(h);

            }
        });
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
                Intent intent = new Intent(EndGame.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();
            }
        });
        di.show();
    }
}
