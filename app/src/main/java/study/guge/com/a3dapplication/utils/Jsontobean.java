package study.guge.com.a3dapplication.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import study.guge.com.a3dapplication.gsonbean.Shouyexiwen;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Jsontobean {

    public static List<Shouyexiwen> getList(String strJson) {

        List<Shouyexiwen> list = new ArrayList<>();
        Shouyexiwen syxw;

        try {
            JSONObject obj1 = new JSONObject(strJson);
                JSONObject obj2 = obj1.getJSONObject("data");
                for (int i = 0; i < obj2.length(); i++) {

                    JSONObject obj3 = obj2.getJSONObject(""+i);
                    String typeid = obj3.getString("typeid");
                    String shorttitle = obj3.getString("shorttitle");
                    String click = obj3.getString("click");
                    Long senddate = obj3.getLong("senddate");
                    String litpic = obj3.getString("litpic");
                    String arcurl = obj3.getString("arcurl");
                    syxw = new Shouyexiwen(typeid, shorttitle, click, senddate,  arcurl,litpic);
                    list.add(syxw);
            }
            return list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
