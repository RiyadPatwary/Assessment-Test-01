package com.riyad_patwary.assessmenttest_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageView background_img, clover;
    LinearLayout textSplash, textHome, menus;
    Animation fromBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load animation...
        fromBottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);

        //layout mapping...
        background_img = (ImageView) findViewById(R.id.backGround_img_id);
        clover = (ImageView) findViewById(R.id.clover_id);
        textSplash = (LinearLayout) findViewById(R.id.textSplash_id);
        textHome = (LinearLayout) findViewById(R.id.textHome_id);
        menus = (LinearLayout) findViewById(R.id.menus_id);

        //animating...
        background_img.animate().translationY(-2000).setDuration(1500).setStartDelay(300);
        clover.animate().alpha(0).setDuration(1500).setStartDelay(300);
        textSplash.animate().translationY(-650).alpha(0).setDuration(1000).setStartDelay(300);
        textSplash.animate().translationX(-150).alpha(0).setDuration(1000).setStartDelay(300);
        //menus.animate().translationY(-150).alpha(0).setDuration(5000).setStartDelay(300);

        textHome.startAnimation(fromBottom);
        menus.startAnimation(fromBottom);


    }
}
