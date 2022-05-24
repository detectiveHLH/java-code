package com.leonsh.java.code.designpattern.strategy;

/**
 * WitouStrategyPattern
 *
 * @author leonsh
 * @date 2020-12-01 09:35
 **/
public class WithoutStrategyPattern {
    public static void main(String[] args) {
        int discountStyle = 1;

        if (discountStyle == 1) {
            System.out.println("执行优惠计价1的业务逻辑");
        } else if (discountStyle == 2) {
            System.out.println("执行优惠计价2的业务逻辑");
        } else {
            System.out.println("执行优惠计价3的业务逻辑");
        }

        /**
         * 实际业务中, if else的代码绝对不是这么短的, 而且也绝对不是这么简单的
         * 看起来就跟屎一样的代码, 长达几百行、甚至上千行
         */
    }
}
