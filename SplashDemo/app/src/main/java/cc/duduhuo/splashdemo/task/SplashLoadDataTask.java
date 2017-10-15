package cc.duduhuo.splashdemo.task;

import android.os.AsyncTask;

/**
 * =======================================================
 * 版权：Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying - liruoer2008@yeah.net
 * 日期：2016/11/21 13:55
 * 版本：1.0
 * 描述：Splash界面加载应用数据任务类
 * 备注：
 * =======================================================
 */
public class SplashLoadDataTask extends AsyncTask<Void, Void, Integer> {

    private LoadDataCallback callback;

    public SplashLoadDataTask(LoadDataCallback callback) {
        this.callback = callback;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        int status = 0;
        // 在此执行耗时任务，可根据任务（数据加载）执行状态给status赋不同的值。
        // ...

        return status;
    }

    @Override
    protected void onPostExecute(Integer status) {
        super.onPostExecute(status);
        if (status == 0) {
            callback.loaded();
        } else if (status == 1) {
            callback.loadError();
        }
    }

    /**
     * 加载数据回调
     */
    public interface LoadDataCallback {
        /**
         * 数据加载完毕
         */
        void loaded();

        /**
         * 数据加载出错
         */
        void loadError();
    }

}
