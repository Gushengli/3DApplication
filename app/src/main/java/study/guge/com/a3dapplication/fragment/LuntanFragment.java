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
public class LuntanFragment extends Fragment{

    private View vluntan;
    private RelativeLayout mRelativeLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vluntan = inflater.inflate(R.layout.fragment_luntan, null);

        gettitle();
        return vluntan;
    }

    private void gettitle() {
        mRelativeLayout = (RelativeLayout) vluntan.findViewById(R.id.title_luntan);
        TextView tv = (TextView) mRelativeLayout.findViewById(R.id.tv_title);
        tv.setText("论坛");
    }

}
