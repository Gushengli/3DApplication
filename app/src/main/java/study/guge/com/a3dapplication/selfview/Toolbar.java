package study.guge.com.a3dapplication.selfview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import study.guge.com.a3dapplication.R;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Toolbar extends LinearLayout {

    private TextView mTextView;

    public Toolbar(Context context) {
        super(context);
        View.inflate(context, R.layout.selfview_toolbar,null);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.selfview_toolbar,null);
    }
}
