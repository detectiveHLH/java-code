package com.leonsh.spring.demo.designpattern.templatemethod;

/**
 * TemplateMethodPattern
 *
 * @author leonsh
 * @date 2020-11-30 09:39
 **/
public class TemplateMethodPattern {

    public static void main(String[] args) {
        DiscountCalculator1 discountCalculator1 = new DiscountCalculator1();
        DiscountCalculator2 discountCalculator2 = new DiscountCalculator2();
        DiscountCalculator3 discountCalculator3 = new DiscountCalculator3();

        discountCalculator1.calculate();
        discountCalculator2.calculate();
        discountCalculator3.calculate();
    }

    public interface DiscountCalculator {
        /**
         * 计算接口
         */
        void calculate();
    }

    public static abstract class AbstractDiscountCalculator implements DiscountCalculator {
        @Override
        public void calculate() {
            commonCalculate();
            specificCalculate();
        }

        public void commonCalculate() {
            System.out.println("通用的计算逻辑");
        }

        /**
         * 抽象计算方法
         */
        public abstract void specificCalculate();
    }

    public static class DiscountCalculator1 extends AbstractDiscountCalculator {

        @Override
        public void specificCalculate() {
            System.out.println("计算器1的特殊逻辑");
        }
    }

    public static class DiscountCalculator2 extends AbstractDiscountCalculator {

        @Override
        public void specificCalculate() {
            System.out.println("计算器2的特殊逻辑");
        }
    }

    public static class DiscountCalculator3 extends AbstractDiscountCalculator {

        @Override
        public void specificCalculate() {
            System.out.println("计算器3的特殊逻辑");
        }
    }

}
