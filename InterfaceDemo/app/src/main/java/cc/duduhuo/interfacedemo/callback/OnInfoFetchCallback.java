package cc.duduhuo.interfacedemo.callback;

/**
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/8/20 18:54
 * 版本：1.0
 * 描述：
 * 备注：
 * =======================================================
 */
public interface OnInfoFetchCallback {
    /** 获取信息成功 */
    void onSuccess(String info);
    /** 获取信息失败 */
    void failure();
}
