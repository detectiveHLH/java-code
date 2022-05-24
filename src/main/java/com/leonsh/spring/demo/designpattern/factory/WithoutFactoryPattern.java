package com.leonsh.spring.demo.designpattern.factory;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * WithoutFactoryPattern
 *
 * @author leonsh
 * @date 2020-11-30 10:06
 **/
public class WithoutFactoryPattern {

    public static void main(String[] args) {
        Product product = new Product("测试产品");
        System.out.println(product);
    }

    @Data
    @AllArgsConstructor
    public static class Product {
        private String name;
    }
}
