package cc.duduhuo.interfacedemo.calculator;

/**
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/8/20 18:30
 * 版本：1.0
 * 描述：
 * 备注：
 * =======================================================
 */
public class Test {
    public static void main(String[] args) {
        Calculator calculator = new ACalculator();
        int sum = calculator.add(12, 14);
        System.out.println("sum = " + sum);
    }
}
