package com.app.mygrocerylist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(1000)
                .withBackgroundColor(Color.parseColor("#fbead9"))
                .withAfterLogoText("My Grocery List")
                .withLogo(R.drawable.ic_splashscreen);

        config.getAfterLogoTextView().setTextSize(35);
        config.getAfterLogoTextView().setTextColor(Color.BLACK);


        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}
