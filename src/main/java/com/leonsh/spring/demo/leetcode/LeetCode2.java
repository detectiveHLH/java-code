package com.leonsh.spring.demo.leetcode;

import com.leonsh.spring.demo.util.CommonUtil;
import com.leonsh.spring.demo.util.ListNode;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.util.StopWatch;

public class LeetCode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateSortedArray(3);
        CommonUtil.shuffle(arr);
        ListNode node = CommonUtil.makeListNode(arr);
        int[] arr2 = CommonUtil.generateSortedArray(3);
        CommonUtil.shuffle(arr);
        ListNode node2 = CommonUtil.makeListNode(arr2);

        System.out.print("Input: ");
        node.print();
        node2.print();
        System.out.println();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 执行关键方法
        node = addTwoNumbers(node, node2);
        if (node != null) {
            node.print();
        }

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
