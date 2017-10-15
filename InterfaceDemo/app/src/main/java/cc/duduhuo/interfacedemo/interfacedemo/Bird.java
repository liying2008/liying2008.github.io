package cc.duduhuo.interfacedemo.interfacedemo;

import android.util.Log;

/**
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/8/20 18:05
 * 版本：1.0
 * 描述：
 * 备注：
 * =======================================================
 */
public class Bird implements MyInterface1, MyInterface2 {
    private static final String TAG = "Bird";
    @Override
    public void fly() {
        Log.i(TAG, "I can fly");
    }

    @Override
    public void walk() {
        Log.i(TAG, "I can walk");
    }
}
