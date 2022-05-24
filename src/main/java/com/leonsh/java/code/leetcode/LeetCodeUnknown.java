package com.leonsh.java.code.leetcode;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCodeUnknown
 *
 * @author leonsh
 * @date 2022-01-25 16:59
 **/
public class LeetCodeUnknown {
    public static int unknown(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            if (sum <= 0) {
                sum = 1;
            }
        }

        return Math.max(max, min);
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        /* 参数准备 */
//        int[] arr = new int[]{-2, 0, 6, 3};
//        int[] arr = new int[]{3, -1, 4};
        int[] arr = new int[]{-3, -1, -1};
//        int[] arr = new int[]{0, 2};

        /* 启动计时器 */
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        /* 执行关键方法 */
        int res = unknown(arr);
        System.out.println("结果: " + res);

        /* 打印运行耗时 */
        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
