package study.guge.com.a3dapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import study.guge.com.a3dapplication.gsonbean.Shouyexiwen;
import study.guge.com.a3dapplication.itface.Allurl;
import study.guge.com.a3dapplication.utils.Dbdaomanager;
import study.guge.com.a3dapplication.utils.Jsontobean;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Servicedown extends Service {

    //private List<Shouyexiwen> listAll = new ArrayList<>();
    private Dbdaomanager dao = new Dbdaomanager();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        addDb(Allurl.WENZHANGSHOUYE);
        addDb(Allurl.XINWEN);
        addDb(Allurl.YOUXIZATAN);
        addDb(Allurl.YINGJIANXINXI);
        addDb(Allurl.YOUXIQIANZHAN);
        addDb(Allurl.YOUXIPINGCE);
        addDb(Allurl.YUANCHUANGJINGPING);
        addDb(Allurl.YOUXIPANDIAN);
        addDb(Allurl.SHISHIJIAODIAN);
        addDb(Allurl.GONGLVZHONGXIN);

        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    public void addDb(final String path) {

        RequestParams entity = new RequestParams(path);
        x.http().get(entity, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                List<Shouyexiwen>  list = Jsontobean.getList(result);
                dao.insertAll(list);
                Log.e("*********list******", list.size()+"");
                Log.e("***********************", "**************************");
                Log.e("*********list******",list.get(0).shorttitle);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(getApplicationContext(), "数据请求中，请稍等......", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {

                return true;
            }
        });
    }
}

