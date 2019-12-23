package com.riyad_patwary.assessmenttest_01;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {
    ImageView background_img, clover;
    LinearLayout textSplash;
    LinearLayout textHome;
    ConstraintLayout mainView;
    Animation fromBottom;
    FadingTextView fadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //load animation...
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        //layout mapping...
        background_img = (ImageView) findViewById(R.id.backGround_img_id);
        clover = (ImageView) findViewById(R.id.clover_id);
        textSplash = (LinearLayout) findViewById(R.id.textSplash_id);
        textHome = (LinearLayout) findViewById(R.id.textHome_id);
        mainView = (ConstraintLayout) findViewById(R.id.mainView_constraint_id);
        fadingTextView = (FadingTextView) findViewById(R.id.fadingTextView_id);

        //animation customization...
        background_img.animate().translationY(-2000).setDuration(500).setStartDelay(2500);
        clover.animate().alpha(0).setDuration(2000).setStartDelay(300);
        textSplash.animate().translationY(-650).alpha(0).setDuration(600).setStartDelay(2500);
        textSplash.animate().translationX(-150).alpha(0).setDuration(600).setStartDelay(2500);

        //start animation...
        textHome.startAnimation(fromBottom);
        mainView.startAnimation(fromBottom);


    }
}
