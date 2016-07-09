package study.guge.com.a3dapplication.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import study.guge.com.a3dapplication.R;
import study.guge.com.a3dapplication.adapter.WenzhangshouyeAdapter;
import study.guge.com.a3dapplication.adapter.Wenzhangshouyelistviewadapter;
import study.guge.com.a3dapplication.gsonbean.Shouyexiwen;
import study.guge.com.a3dapplication.utils.Dbdaomanager;

public class ShouyeFragment_Wenzhang extends Fragment implements ViewPager.OnPageChangeListener {

    private Dbdaomanager dao;
    private int preposition = 0;
    private int currentposition = 0;
    private View vwenzhangshouye;
    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;
    private List<ImageView> mImageViews;
    private List<Shouyexiwen> listbean1;
    private WenzhangshouyeAdapter adapter;
    private PullToRefreshListView mPullToRefreshListView;
    private Wenzhangshouyelistviewadapter listViewadapter;

    private int[] imagearr = {R.drawable.default1, R.drawable.default2, R.drawable.default3};
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int arg1 = msg.arg1;
            mViewPager.setCurrentItem(arg1);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vwenzhangshouye = inflater.inflate(R.layout.wenzhangshouye_fragment, null);

        initView();
        setData();
        setpoints();
        setListener();
        setwheel();

        return vwenzhangshouye;
    }

    private void setwheel() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(2500);
                    if (currentposition > mImageViews.size() - 1) {
                        currentposition = 0;
                    } else {
                        currentposition++;
                    }
                    Message msg = Message.obtain();
                    msg.arg1 = currentposition;
                    handler.sendMessage(msg);
                }
            }
        }.start();
    }

    private void setListener() {
        mViewPager.addOnPageChangeListener(this);
    }

    private void setpoints() {
        for (int i = 0; i < mImageViews.size(); i++) {
            View v = new View(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.leftMargin = 15;
            v.setLayoutParams(params);
            v.setBackgroundResource(R.drawable.dot_white);
            v.setTag(i);
            mLinearLayout.addView(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (Integer) v.getTag();
                    mViewPager.setCurrentItem(tag);
                }
            });

            mLinearLayout.getChildAt(0).setBackgroundResource(R.drawable.dot_dark);
        }
    }

    private void setData() {
        mImageViews = new ArrayList<>();
        for (int i = 0; i < imagearr.length; i++) {
            ImageView iv = new ImageView(getActivity());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(imagearr[i]);
            mImageViews.add(iv);
        }
        adapter = new WenzhangshouyeAdapter();
        adapter.setImageViewList(mImageViews);
        mViewPager.setAdapter(adapter);

        dao = new Dbdaomanager();
        listbean1 = dao.queryAllWhere("2");
        mPullToRefreshListView.setAdapter(listViewadapter);
    }

    private void initView() {
        mViewPager = (ViewPager) vwenzhangshouye.findViewById(R.id.vp_wenzhangshouye);
        mLinearLayout = (LinearLayout) vwenzhangshouye.findViewById(R.id.ll_wenzhangshouye_points);

        mPullToRefreshListView = (PullToRefreshListView) vwenzhangshouye.findViewById(R.id.pull_wenzhangshouye);
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mLinearLayout.getChildAt(position).setBackgroundResource(R.drawable.dot_dark);
        mLinearLayout.getChildAt(preposition).setBackgroundResource(R.drawable.dot_white);
        preposition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
