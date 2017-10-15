package cc.duduhuo.interfacedemo;

import java.util.Date;

import cc.duduhuo.interfacedemo.callback.OnInfoFetchCallback;

/**
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/8/20 18:57
 * 版本：1.0
 * 描述：
 * 备注：
 * =======================================================
 */
public class InfoService {
    private OnInfoFetchCallback callback;
    public InfoService(OnInfoFetchCallback callback) {
        this.callback = callback;
    }

    public void getInfo() {
        // 模拟一个耗时操作
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    // 信息获取成功，传递结果
                    callback.onSuccess("结果是：" + new Date());
                } catch (InterruptedException e) {
                    // 信息获取失败
                    callback.failure();
                }
            }
        });
        thread.start();
    }
}
