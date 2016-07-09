package study.guge.com.a3dapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2016/7/5.
 */
public class Netisok {
    /**
     * 网络是否可用
     *
     * @param
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
        } else {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null) {
                return true;
            }
        }
        return false;
    }
}
