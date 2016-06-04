package com.inveitix.mindler.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.inveitix.mindler.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.grp_footer)
    ViewGroup grpFooter;
    @Bind(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onLoginClicked() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getViewsAnimator().start();
    }

    @NonNull
    private ObjectAnimator getViewsAnimator() {
        final ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(btnLogin, "alpha", 0, 1);
        alphaAnimator.setDuration(1000);
        alphaAnimator.setInterpolator(new DecelerateInterpolator());

        final ObjectAnimator moveAnimator = ObjectAnimator.ofFloat(grpFooter, "y", 600, 0);
        moveAnimator.setDuration(3500);
        moveAnimator.setInterpolator(new BounceInterpolator());
        moveAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                alphaAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        return moveAnimator;
    }
}
