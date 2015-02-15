package com.inspiron.tharun26.navdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 4000;
    private static final float ROTATE_FROM = 0.0f;
    private static final float ROTATE_TO = -10.0f * 360.0f;// 3.141592654f * 32.0f;
public RotateAnimation r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ImageView favicon = (ImageView) findViewById(R.id.splash);
     //  RotateAnimation r; // = new RotateAnimation(ROTATE_FROM, ROTATE_TO);
        r = new RotateAnimation(ROTATE_FROM, ROTATE_TO, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        r.setDuration(2500);
        r.setRepeatCount(0);

        //favicon.startAnimation(r);


        /*RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);


        final ImageView splash = (ImageView) findViewById(R.id.splash);
        splash.startAnimation(anim);
*/
     final Animation animationFalling = AnimationUtils.loadAnimation(this, R.anim.falling);
        //final Animation animationFalling1 = AnimationUtils.loadAnimation(this, R.anim.falling1);
        final ImageView splash = (ImageView) findViewById(R.id.splash);
     //   final ImageView gear = (ImageView) findViewById(R.id.gear);

        favicon.startAnimation(animationFalling);
        //gear.startAnimation(animationFalling1);
       // favicon.startAnimation(r);
        // Later.. stop the animation


        animationFalling.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim) {
            }

            ;

            public void onAnimationRepeat(Animation anim) {
            }

            ;

            public void onAnimationEnd(Animation anim) {

               favicon.startAnimation(r);
            }


        });

        favicon.startAnimation(animationFalling);
        //dial.startAnimation(animation1);


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                Intent i = new Intent(SplashScreen.this, MainActivity.class);

                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }



}
