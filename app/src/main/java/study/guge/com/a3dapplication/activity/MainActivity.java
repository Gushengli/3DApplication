package study.guge.com.a3dapplication.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import study.guge.com.a3dapplication.R;
import study.guge.com.a3dapplication.fragment.GameFragment;
import study.guge.com.a3dapplication.fragment.LuntanFragment;
import study.guge.com.a3dapplication.fragment.WenzhangFragment;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout mFrameLayout;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1, mRadioButton2, mRadioButton3;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setData();
        setListener();
    }

    private void setListener() {
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    private void setData() {
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl_mainactivity, new WenzhangFragment())
                .commit();
    }

    private void initView() {
        mFrameLayout = (FrameLayout) findViewById(R.id.fl_mainactivity);
        mRadioGroup = (RadioGroup) findViewById(R.id.main_bottom_rg);
        mRadioButton1 = (RadioButton) findViewById(R.id.main_bottom_rb01);
        mRadioButton2 = (RadioButton) findViewById(R.id.main_bottom_rb02);
        mRadioButton3 = (RadioButton) findViewById(R.id.main_bottom_rb03);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if (checkedId == R.id.main_bottom_rb01) {

            fragmentTransaction.replace(R.id.fl_mainactivity, new WenzhangFragment()).commit();
        } else if (checkedId == R.id.main_bottom_rb02) {
            fragmentTransaction.replace(R.id.fl_mainactivity, new LuntanFragment()).commit();
        } else if (checkedId == R.id.main_bottom_rb03) {
            fragmentTransaction.replace(R.id.fl_mainactivity, new GameFragment()).commit();
        }
    }
}
