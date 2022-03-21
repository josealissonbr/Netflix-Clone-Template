package com.techprimedev.netflixclonetemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    static boolean firstInit = false;
    static int countTick = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void onPause() {
        _handler = null;
        super.onPause();
    }

    private Handler _handler;

    @Override
    public void onResume() {
        super.onResume();
        _handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                if (!firstInit) {
                    if (_handler == _h0) {

                        tick();
                        _handler.postDelayed(this, 1000);
                    }
                }

            }

            private final Handler _h0 = _handler;
        };
        r.run();
    }
    private void tick() {
        countTick ++;
        System.out.println("Iniciando...");

        if (countTick == 3) {
            firstInit = false;
            initLogin();
        }
    }

    private void initLogin() {
        //Mudar o Activity

        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}