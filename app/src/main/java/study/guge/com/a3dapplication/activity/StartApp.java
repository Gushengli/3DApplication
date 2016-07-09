package study.guge.com.a3dapplication.activity;

import android.app.Application;

import org.xutils.x;

public class StartApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
