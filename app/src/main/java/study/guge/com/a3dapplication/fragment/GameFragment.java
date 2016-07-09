package study.guge.com.a3dapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import study.guge.com.a3dapplication.R;

/**
 * Created by Administrator on 2016/7/6.
 */
public class GameFragment extends Fragment{

    private View vyouxi;
    private RelativeLayout mRelativeLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vyouxi = inflater.inflate(R.layout.fragment_youxi, null);

        gettitle();
        return vyouxi;
    }

    private void gettitle() {

        mRelativeLayout = (RelativeLayout) vyouxi.findViewById(R.id.title_youxi);
        TextView tv = (TextView) mRelativeLayout.findViewById(R.id.tv_title);
        tv.setText("游戏");
    }

}
