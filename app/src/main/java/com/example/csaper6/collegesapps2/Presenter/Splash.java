package com.example.csaper6.collegesapps2.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import com.example.csaper6.collegesapps2.R;

public class Splash extends AppCompatActivity {

    SeekBar pb;
    Intent next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pb = (SeekBar) (findViewById(R.id.seekBar));
        pb.setEnabled(false);
        pb.setProgress(1000);
        next = new Intent(this, Login.class);

        new CountDownTimer(10000,100){

            @Override
            public void onTick(long l) {
                pb.setProgress((int)(l/100));
            }

            @Override
            public void onFinish() {
                startActivity(next);
                this.cancel();
            }
        }.start();

    }
}
