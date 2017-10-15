package cc.duduhuo.interfacedemo.calculator;

/**
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/8/20 18:25
 * 版本：1.0
 * 描述：计算器接口
 * 备注：
 * =======================================================
 */
public interface Calculator {
    /** 计算器可以计算两个数的和 */
    int add(int a, int b);
    /** 计算器可以计算两个数的差 */
    int sub(int a, int b);
    /** 计算器可以计算两个数的积 */
    long mul(int a, int b);
    /** 计算器可以计算两个数的商 */
    float div(int a, int b);
}
