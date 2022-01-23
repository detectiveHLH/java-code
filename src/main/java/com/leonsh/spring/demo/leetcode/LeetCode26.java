package com.leonsh.spring.demo.leetcode;

import com.leonsh.spring.demo.util.CommonUtil;
import com.leonsh.spring.demo.util.ListNode;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class LeetCode26 {

    /**
     * 解法偏暴力
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        ListNode newHead = head;
        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            if (i == 0) {
                newHead.next = new ListNode(list.get(len - i - 1));
            } else {
                newHead.next = new ListNode(list.get(i));
                newHead = newHead.next;
                newHead.next = new ListNode(list.get(len - i - 1));
            }
            newHead = newHead.next;
        }

        if (len % 2 != 0) {
            newHead.next = new ListNode(list.get(len / 2));
        }
    }

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateSortedArray(5);
        CommonUtil.shuffle(arr);
        ListNode node = CommonUtil.makeListNode(arr);

        System.out.print("Input: ");
        node.print();
        System.out.println();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 执行关键方法
        reorderList(node);
        if (node != null) {
            node.print();
        }

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
