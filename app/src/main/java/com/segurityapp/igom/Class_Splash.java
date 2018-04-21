package com.segurityapp.igom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class Class_Splash extends AppCompatActivity {
    int counter = 0;
    protected static final int TIMER_RUNTIME = 10000;
    protected boolean mbActive;
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IniciaSplash();
        Barrinha();
    }

    public void IniciaSplash() {
        setContentView(R.layout.class__splash);
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter++;
                try {
                    while (counter == 1 || counter <= 5) {  //Trocar a contagem do contador
                        Thread.sleep(1000);
                        counter++;
                        Log.e("counter =", Integer.toString(counter));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (counter == 6) {
                    Intent it = new Intent(Class_Splash.this, Class_Login.class);
                    startActivity(it);
                    counter++;
                    Log.e("Counter =", Integer.toString(counter));
                }
            }
        }).start();
    }

    protected void Barrinha() {
        setContentView(R.layout.class__splash);
        mProgressBar = (ProgressBar) findViewById(R.id.barrinha);
        final Thread timerThread = new Thread() {
            @Override
            public void run() {
                mbActive = true;
                try {
                    int waited = 0;
                    while (mbActive && (waited < TIMER_RUNTIME)) {
                        sleep(100);
                        if (mbActive) {
                            waited += 300;
                            updateProgress(waited);
                        }
                    }
                } catch (InterruptedException e) {

                } finally {
                    onContinue();
                }
            }
        };
        timerThread.start();
    }

    public void updateProgress(final int timePassed) {
        if (null != mProgressBar) {
            final int progress = mProgressBar.getMax() * timePassed / TIMER_RUNTIME;
            mProgressBar.setProgress(progress);
        }
    }

    public void onContinue() {

    }
}