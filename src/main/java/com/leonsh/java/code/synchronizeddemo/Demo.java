package com.leonsh.java.code.synchronizeddemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Demo
 *
 * @author leonsh
 * @date 2022-03-03 10:21
 **/
public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,6,0,7,4,9,3};
        int[] index = new int[]{0,1,2,3,4,0,5,1,2,6,7};

        StringBuilder tel = new StringBuilder();
        for (int i : index) {
            tel.append(arr[i]);
        }

        System.out.println(tel.toString());
    }
}
