package study.guge.com.a3dapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import study.guge.com.a3dapplication.R;
import study.guge.com.a3dapplication.adapter.MyAdapter;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private View pointsview;
    private View mView1, mView2;
    private LinearLayout mLinearLayout;
    private MyAdapter adapter;
    private List<View> mListView;
    private int preposition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
        initData();
        setListener();
    }

    private void setListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mLinearLayout.getChildAt(position).setBackgroundResource(R.drawable.dot_enable);
                mLinearLayout.getChildAt(preposition).setBackgroundResource(R.drawable.dot_normal);
                preposition = position;

                if (position == mListView.size() - 1) {
                    Button btncheck = (Button) mListView.get(position).findViewById(R.id.btn_guideactivity_viewpager);
                    btncheck.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setTrance();
                            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        mListView = new ArrayList<>();
        mView1 = View.inflate(this, R.layout.guide_item1, null);
        mView2 = View.inflate(this, R.layout.guide_item3, null);
        mListView.add(mView1);
        mListView.add(mView2);

        adapter = new MyAdapter();
        adapter.setList(mListView);
        mViewPager.setAdapter(adapter);

        setPoints();
    }

    private void setPoints() {
        for (int i = 0; i < mListView.size(); i++) {
            pointsview = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
            params.leftMargin = 15;
            pointsview.setLayoutParams(params);
            pointsview.setBackgroundResource(R.drawable.dot_normal);
            mLinearLayout.addView(pointsview);
            pointsview.setTag(i);

            pointsview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int tag = (Integer) v.getTag();
                    mViewPager.setCurrentItem(tag);
                }
            });
            mLinearLayout.getChildAt(0).setBackgroundResource(R.drawable.dot_enable);
        }
    }

    private void setTrance() {
        SharedPreferences sp = getSharedPreferences("isFirstShow", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("isFirst", true);
        edit.commit();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_guideactivity);
        mLinearLayout = (LinearLayout) findViewById(R.id.ll_guideactivity);
    }
}
