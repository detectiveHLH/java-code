package com.leonsh.java.code.leetcode;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode3
 * - 暴力解法
 * - 滑动窗口
 *
 * @author leonsh
 * @date 2022-01-19 09:44
 **/
public class LeetCode3 {
    /**
     * 暴力解法, 直接遍历所有的 case, 有没有更好的解法？
     */
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }

        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                String c = String.valueOf(s.charAt(j));
                if (sb.indexOf(c) != -1) {
                    break;
                }
                sb.append(c);
            }
            if (sb.length() > maxLen) {
                maxLen = sb.length();
            }
            System.out.println(sb);
        }

        return maxLen;
    }

    /**
     * 滑动窗口
     */
//    public static int lengthOfLongestSubstring01(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        int left = 0;
//        for (int i = 0; i < s.length(); i++) {
//            Character c = s.charAt(i);
//            if (map.containsKey(c)) {
//                left = Math.max(left, map.get(c) + 1);
//                continue;
//            }
//
//            map.put()
//        }
//    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 执行关键方法
        String str = "";

        // 暴力解法
        int result = lengthOfLongestSubstring(str);
        // 滑动窗口
//        int result = lengthOfLongestSubstring01(str);

        System.out.println("结果： " + result);

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
