package cc.duduhuo.interfacedemo.calculator;

/**
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/8/20 18:28
 * 版本：1.0
 * 描述：A计算器
 * 备注：
 * =======================================================
 */
public class ACalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public long mul(int a, int b) {
        return a * b;
    }

    @Override
    public float div(int a, int b) {
        return (float) a / (float) b;
    }
}
