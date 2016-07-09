package study.guge.com.a3dapplication.gsonbean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/7/6.
 */

@Table(name = "shouye")
public class Shouyexiwen {

    @Column(name = "id",isId = true )
    public int id;
    @Column(name = "typeid")
    public String typeid;
    @Column(name = "shorttitle")
    public String shorttitle;
    @Column(name = "click")
    public String click;
    @Column(name = "senddate")
    public Long senddate;
    @Column(name = "arcurl")
    public String arcurl;
    @Column(name = "litpic")
    public String litpic;

    public Shouyexiwen(String typeid, String shorttitle,String click,
                       Long senddate, String arcurl, String litpic) {
        this.typeid = typeid;
        this.shorttitle = shorttitle;
        this.click = click;
        this.senddate = senddate;
        this.arcurl = arcurl;
        this.litpic = litpic;
    }

}

