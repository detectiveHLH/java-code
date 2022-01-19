package com.leonsh.spring.demo.leetcode;

import com.leonsh.spring.demo.util.CommonUtil;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode219
 *
 * @author leonsh
 * @date 2022-01-19 16:51
 **/
public class LeetCode219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
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
        int[] arr = new int[]{1,0,1,1};
        int k = 1;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 执行关键方法
        boolean result = containsNearbyDuplicate(arr, k);
        System.out.println("结果：" + result);

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
