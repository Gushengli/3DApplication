package study.guge.com.a3dapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import study.guge.com.a3dapplication.R;
import study.guge.com.a3dapplication.service.Servicedown;
import study.guge.com.a3dapplication.utils.Netisok;

public class WelcomeActivity extends AppCompatActivity {


    //private GifImageView mGifImageView;
    private ImageView iv;
    private Animation mAnimation;
    private boolean networkAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initView();
        setAnimation();
        setListener();
    }

    private void setListener() {
        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                networkAvailable = Netisok.isNetworkAvailable(WelcomeActivity.this);
                if (networkAvailable) {
                    Intent intent = new Intent(WelcomeActivity.this, Servicedown.class);
                    startService(intent);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!networkAvailable) {
                    Toast.makeText(WelcomeActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
                }

                isFirstShow();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void isFirstShow() {
        SharedPreferences sp = getSharedPreferences("isFirstShow",  Context.MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst", false);
        if (!isFirst) {
            Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void setAnimation() {
        mAnimation = new AlphaAnimation(1.0F, 0.3F);
        mAnimation.setDuration(5000);
        iv.startAnimation(mAnimation);
        ImageOptions options = new ImageOptions.Builder()
                .setFailureDrawableId(R.drawable.welcome)
                .setSize(DensityUtil.getScreenWidth(),DensityUtil.dip2px(200))
                .setIgnoreGif(false)
                .build();
        x.image().bind(iv,"", options);
    }

    private void initView() {
        //mGifImageView = (GifImageView) findViewById(R.id.iv_welcome_gif);
        iv = (ImageView) findViewById(R.id.iv_welcome_gif);
       // mGifImageView.setImageResource(R.drawable.welcome);
    }
}