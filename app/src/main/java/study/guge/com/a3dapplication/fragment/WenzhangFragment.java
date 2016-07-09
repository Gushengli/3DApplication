package study.guge.com.a3dapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.List;

import study.guge.com.a3dapplication.R;
import study.guge.com.a3dapplication.adapter.Mypageradapter;


public class WenzhangFragment extends Fragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    private View vwenzhang;
    private RadioGroup mRadioGroup;
    private HorizontalScrollView hsl;
    private ViewPager vpshow;
    private List<Fragment> mFragmentList;
    private RadioButton mRadioButton1, mRadioButton2, mRadioButton3,
            mRadioButton4, mRadioButton5, mRadioButton6, mRadioButton7,
            mRadioButton8, mRadioButton9, mRadioButton10;
    private Mypageradapter myadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vwenzhang = inflater.inflate(R.layout.fragment_wenzhang, null);

        initView();
        setData();
        setListener();

        return vwenzhang;
    }

    private void setData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new ShouyeFragment_Wenzhang());
        mFragmentList.add(Xinwenfragment.newInstance("2"));
        mFragmentList.add(Xinwenfragment.newInstance("151"));
        mFragmentList.add(Xinwenfragment.newInstance("152"));
        mFragmentList.add(Xinwenfragment.newInstance("153"));
        mFragmentList.add(Xinwenfragment.newInstance("154"));
        mFragmentList.add(Xinwenfragment.newInstance("196"));
        mFragmentList.add(Xinwenfragment.newInstance("197"));
        mFragmentList.add(Xinwenfragment.newInstance("199"));
        mFragmentList.add(Xinwenfragment.newInstance("25"));

        myadapter = new Mypageradapter(getFragmentManager(), mFragmentList);
        vpshow.setAdapter(myadapter);
    }

    private void initView() {
        vpshow = (ViewPager) vwenzhang.findViewById(R.id.vpshow_main);
        mRadioGroup = (RadioGroup) vwenzhang.findViewById(R.id.rg_top_mainactivity);
        hsl = (HorizontalScrollView) vwenzhang.findViewById(R.id.hs_mainactivity);

        mRadioButton1 = (RadioButton) vwenzhang.findViewById(R.id.rb1_top);
        mRadioButton1.setChecked(true);
        mRadioButton2 = (RadioButton) vwenzhang.findViewById(R.id.rb2_top);
        mRadioButton3 = (RadioButton) vwenzhang.findViewById(R.id.rb3_top);
        mRadioButton4 = (RadioButton) vwenzhang.findViewById(R.id.rb4_top);
        mRadioButton5 = (RadioButton) vwenzhang.findViewById(R.id.rb5_top);
        mRadioButton6 = (RadioButton) vwenzhang.findViewById(R.id.rb6_top);
        mRadioButton7 = (RadioButton) vwenzhang.findViewById(R.id.rb7_top);
        mRadioButton8 = (RadioButton) vwenzhang.findViewById(R.id.rb8_top);
        mRadioButton9 = (RadioButton) vwenzhang.findViewById(R.id.rb9_top);
        mRadioButton10 = (RadioButton) vwenzhang.findViewById(R.id.rb10_top);
    }

    private void setListener() {
        mRadioGroup.setOnCheckedChangeListener(this);
        vpshow.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        hsl.setVisibility(View.VISIBLE);
        mRadioGroup.setVisibility(View.VISIBLE);

        RadioButton rb = (RadioButton) mRadioGroup.getChildAt(position);
        rb.setChecked(true);

        int left = rb.getLeft();
        hsl.smoothScrollTo(left,0);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1_top:
                        vpshow.setCurrentItem(0);
                        break;
                    case R.id.rb2_top:
                        vpshow.setCurrentItem(1);
                        break;
                    case R.id.rb3_top:
                        vpshow.setCurrentItem(2);
                        break;
                    case R.id.rb4_top:
                        vpshow.setCurrentItem(3);
                        break;
                    case R.id.rb5_top:
                        vpshow.setCurrentItem(4);
                        break;
                    case R.id.rb6_top:
                        vpshow.setCurrentItem(5);
                        break;
                    case R.id.rb7_top:
                        vpshow.setCurrentItem(6);
                        break;
                    case R.id.rb8_top:
                        vpshow.setCurrentItem(7);
                        break;
                    case R.id.rb9_top:
                        vpshow.setCurrentItem(8);
                        break;
                    case R.id.rb10_top:
                        vpshow.setCurrentItem(9);
                        break;
                }
            }
        });
    }
}

