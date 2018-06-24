package com.ipo.distropia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created on 21/06/2018.
 */
public class Splash extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;
    @Override
    public void onCreate(Bundle icicle) {
        //setTheme(R.style.AppTheme);
        super.onCreate(icicle);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
