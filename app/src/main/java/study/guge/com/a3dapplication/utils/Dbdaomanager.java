package study.guge.com.a3dapplication.utils;

import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

import study.guge.com.a3dapplication.gsonbean.Shouyexiwen;

/**
 * Created by Administrator on 2016/7/8.
 */
public class Dbdaomanager {

    private org.xutils.DbManager.DaoConfig mDaoConfig;

    public Dbdaomanager() {
        mDaoConfig = new org.xutils.DbManager.DaoConfig();
        mDaoConfig.setDbName("1604.db");
    }

    public void deleteAll(){
        try {
            x.getDb(mDaoConfig).dropDb();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void insertAll(List<Shouyexiwen> list){

        try {
            x.getDb(mDaoConfig).saveOrUpdate(list);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public List<Shouyexiwen> queryAllWhere(String str) {

        List<Shouyexiwen> listdb = null;
        try {
            listdb = x.getDb(mDaoConfig)
                    .selector(Shouyexiwen.class)
                    .where("typeid", "=", str)
                    .findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return listdb;
    }
}
