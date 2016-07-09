package study.guge.com.a3dapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.List;

import study.guge.com.a3dapplication.R;
import study.guge.com.a3dapplication.gsonbean.Shouyexiwen;
import study.guge.com.a3dapplication.itface.Allurl;



public class Wenzhangshouyelistviewadapter extends BaseAdapter {

    private Shouyexiwen shouyexiwen;
    private List<Shouyexiwen> listbean;

    public void setListbean(List<Shouyexiwen> listbean) {
        this.listbean = listbean;
    }

    @Override
    public int getCount() {
        return (listbean == null) ? 0 :listbean.size();
    }

    @Override
    public Object getItem(int position) {
        return listbean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_wenzhangshouyelistview, null);
            vh = new ViewHolder();
            vh.iv = (ImageView) convertView.findViewById(R.id.item_xinwenlistview_iv);
            vh.tv1 = (TextView) convertView.findViewById(R.id.item_xinwenlistview_title);
            vh.tv2 = (TextView) convertView.findViewById(R.id.item_xinwenlistview_time);
            vh.tv3 = (TextView) convertView.findViewById(R.id.item_xinwenlistview_pinglun);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        shouyexiwen =  listbean.get(position);
        vh.tv1.setText(shouyexiwen.shorttitle);
        vh.tv2.setText(Wenzhangshouyelistviewadapter.getdate(shouyexiwen.senddate));
        vh.tv3.setText(shouyexiwen.click);

        ImageOptions options = new ImageOptions.Builder()
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();
        x.image().bind(vh.iv,Allurl.MAINURL + shouyexiwen.litpic, options);

        return convertView;
    }

    static class ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }

    public static String getdate(Long mm) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(mm);
    }
}
