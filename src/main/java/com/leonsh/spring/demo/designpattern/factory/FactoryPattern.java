package com.leonsh.spring.demo.designpattern.factory;

/**
 * FactoryPattern
 *
 * @author leonsh
 * @date 2020-11-30 10:10
 **/
public class FactoryPattern {

    public static void main(String[] args) {
        Product product = ProductFactory.create();
        product.execute();
    }

    public interface Product {
        /**
         * 执行的接口
         */
        void execute();
    }

    public static class ProductImpl1 implements Product {
        @Override
        public void execute() {
            System.out.println("这是产品的功能实现1");
        }
    }

    public static class ProductImpl2 implements Product {
        @Override
        public void execute() {
            System.out.println("这是产品的功能实现2");
        }
    }

    public static class ProductFactory {
        public static Product create() {
//            return new ProductImpl1();
            return new ProductImpl2();
        }
    }
}
