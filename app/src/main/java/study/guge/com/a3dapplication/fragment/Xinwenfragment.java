package study.guge.com.a3dapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import study.guge.com.a3dapplication.R;
import study.guge.com.a3dapplication.adapter.Wenzhangshouyelistviewadapter;
import study.guge.com.a3dapplication.gsonbean.Shouyexiwen;
import study.guge.com.a3dapplication.utils.Dbdaomanager;

public class Xinwenfragment extends Fragment{

    private View vxinwen;
    private Dbdaomanager dao;
    private List<Shouyexiwen> listbean;
    private PullToRefreshListView mPullToRefreshListView;

    public static Xinwenfragment newInstance(String mtypeid) {
        Xinwenfragment newFragment = new Xinwenfragment();
        Bundle bundle = new Bundle();
        bundle.putString("mtypeid", mtypeid);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vxinwen = View.inflate(getContext(), R.layout.fragment_xinwen, null);

        initView();
        setData();
        return vxinwen;
    }

    private void setData() {
        Bundle bundle = getArguments();
        if(bundle != null){

                List<Shouyexiwen> listbean = dao.queryAllWhere(bundle.getString("mtypeid"));

            }
            mPullToRefreshListView.setAdapter(new Wenzhangshouyelistviewadapter());
        }

    private void initView() {
        dao = new Dbdaomanager();
        mPullToRefreshListView = (PullToRefreshListView) vxinwen.findViewById(R.id.pull_xinwen);
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
    }
}
