package com.leonsh.java.code.leetcode;

import com.leonsh.java.code.util.CommonUtil;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode217
 *
 * @author leonsh
 * @date 2022-01-19 16:42
 **/
public class LeetCode217 {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                return true;
            }
            map.put(n, true);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateSortedArray(5);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 执行关键方法
        containsDuplicate(arr);

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
