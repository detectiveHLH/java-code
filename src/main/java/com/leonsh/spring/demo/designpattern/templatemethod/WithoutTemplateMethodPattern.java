package com.leonsh.spring.demo.designpattern.templatemethod;

/**
 * WithoutTemplateMethodPattern
 *
 * @author leonsh
 * @date 2020-11-30 09:36
 **/
public class WithoutTemplateMethodPattern {

    public static void main(String[] args) {
        DiscountCal1 discountCal1 = new DiscountCal1();
        DiscountCal2 discountCal2 = new DiscountCal2();
        DiscountCal3 discountCal3 = new DiscountCal3();

        discountCal1.calculate();
        discountCal2.calculate();
        discountCal3.calculate();
    }

    public static class DiscountCal1 {
        public void calculate() {
            System.out.println("通用的计算逻辑");
            System.out.println("计算器1的特殊逻辑");
        }
    }

    public static class DiscountCal2 {
        public void calculate() {
            System.out.println("通用的计算逻辑");
            System.out.println("计算器2的特殊逻辑");
        }
    }

    public static class DiscountCal3 {
        public void calculate() {
            System.out.println("通用的计算逻辑");
            System.out.println("计算器3的特殊逻辑");
        }
    }

}
