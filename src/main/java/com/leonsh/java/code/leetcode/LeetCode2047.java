package com.leonsh.java.code.leetcode;

import org.springframework.util.StopWatch;

/**
 * LeetCode2047
 * <p>
 * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
 * <p>
 * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
 * <p>
 * 仅由小写字母、连字符和/或标点（不含数字）。
 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 *
 * @author leonsh
 * @date 2022-01-27 10:17
 **/
public class LeetCode2047 {
    public static int countValidWords(String sentence) {
        int count = 0;

        String[] arr = sentence.split(" ");
        for (String str : arr) {
            if ("".equals(str)) {
                continue;
            }

            if (isValidWords(str)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isValidWords(String str) {

        return true;
    }

    public static void main(String[] args) {
        /* 参数准备 */
//        String sentence = "!this  1-s b8d!";
        String sentence = "alice and  bob are playing stone-game1";

        /* 开始计时 */
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        /* 执行关键方法 */
        int result = countValidWords(sentence);
        System.out.println("结果：" + result);

        /* 打印耗时 */
        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
