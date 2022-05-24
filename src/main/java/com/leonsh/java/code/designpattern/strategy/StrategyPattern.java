package com.leonsh.java.code.designpattern.strategy;

import lombok.Data;

/**
 * StrategyPattern
 *
 * @author leonsh
 * @date 2020-12-01 09:37
 **/
public class StrategyPattern {

    public static void main(String[] args) {
        int discountStyle = 2;

        DiscountCalculateStrategy strategy = DiscountCalculateStrategyFactory.getDiscountCalculateStrategy(discountStyle);
        strategy.calculate();

        /**
         * 要点1：必须将if else的代码，封装到不同的策略中去
         * 要点2：具体选择哪种策略的代码，一定要放到工厂中去
         * 要点3：Context不是必须的，关键是看你的策略执行这块如果就一行调用，就没有必要，如果执行的逻辑稍微复杂一点
         * 可以考虑用context
         *
         * 策略模式应该是出现频率非常高的设计模式了
         */
        Context context = new Context();
        context.setStrategy(strategy);
        context.calculate();
    }

    public interface DiscountCalculateStrategy {
        /**
         * 策略接口的执行模式
         */
        void calculate();
    }

    public static class DiscountCalculateStrategyA implements DiscountCalculateStrategy {
        @Override
        public void calculate() {
            System.out.println("执行优惠计价1的业务逻辑");
        }
    }

    public static class DiscountCalculateStrategyB implements DiscountCalculateStrategy {
        @Override
        public void calculate() {
            System.out.println("执行优惠计价2的业务逻辑");
        }
    }

    public static class DiscountCalculateStrategyC implements DiscountCalculateStrategy {
        @Override
        public void calculate() {
            System.out.println("执行优惠计价3的业务逻辑");
        }
    }

    public static class DiscountCalculateStrategyDefault implements DiscountCalculateStrategy {
        @Override
        public void calculate() {
            System.out.println("执行默认的优惠计价策略");
        }
    }

    public static class DiscountCalculateStrategyFactory {
        public static DiscountCalculateStrategy getDiscountCalculateStrategy(int discountStyle) {
            if (discountStyle == 1) {
                return new DiscountCalculateStrategyA();
            } else if (discountStyle == 2) {
                return new DiscountCalculateStrategyB();
            } else if (discountStyle == 3) {
                return new DiscountCalculateStrategyC();
            } else {
                return new DiscountCalculateStrategyDefault();
            }
        }
    }

    @Data
    public static class Context {
        private DiscountCalculateStrategy strategy;
        public void setStrategy(DiscountCalculateStrategy strategy) {
            this.strategy = strategy;
        }

        public void calculate() {
            this.strategy.calculate();
        }
    }
}
