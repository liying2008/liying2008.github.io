package cc.duduhuo.timelinedemo.model;

/**
 * =======================================================
 * 版权：Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying - liruoer2008@yeah.net
 * 日期：2016/11/22 16:58
 * 版本：1.0
 * 描述：物流信息类
 * 备注：
 * =======================================================
 */
public class Trace {
    /** 时间 */
    private String acceptTime;
    /** 描述 */
    private String acceptStation;

    public Trace() {
    }

    public Trace(String acceptTime, String acceptStation) {
        this.acceptTime = acceptTime;
        this.acceptStation = acceptStation;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }
}
