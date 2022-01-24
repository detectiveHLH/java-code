package com.leonsh.spring.demo.leetcode;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode220
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 *
 * @author leonsh
 * @date 2022-01-19 17:22
 **/
public class LeetCode220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            // 这里很关键, 没找到需要更新一下下标, 例如 1,0,1,1 和 k=1 的情况
            map.put(nums[i], i);
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 执行关键方法
        boolean result = containsNearbyAlmostDuplicate(arr, k, t);
        System.out.println("结果：" + result);

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
