package com.leonsh.spring.demo.leetcode;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    /*
    使用 Hash 表的解法算法效率还是可以
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(tmp, i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        /* 参数准备 */
//        int[] arr = new int[]{2,7,11,15};
//        int target = 9;

        int[] arr = new int[]{3,2,4};
        int target = 6;

        /* 启动计时器 */
        StopWatch stopWatch = new StopWatch("206");
        stopWatch.start();

        /* 执行关键方法 */
        int[] res = twoSum(arr, target);
        System.out.println("结果: " + Arrays.toString(res));

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
