package com.leonsh.spring.demo.leetcode;

import com.leonsh.spring.demo.util.CommonUtil;
import com.leonsh.spring.demo.util.ListNode;
import org.springframework.util.StopWatch;

/**
 * LeetCode61
 *
 * @author leonsh
 * @date 2022-01-19 09:20
 **/
public class LeetCode61 {
    /**
     * 1-2-3-4-5 右移1位 5-1-2-3-4
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int len = 0;

        ListNode p = null;
        ListNode tail = null;
        ListNode curr = head;
        while (curr != null) {
            len++;
            if (curr.next == null) {
                tail = curr;
            }
            curr = curr.next;
        }

        k = k % len;
        curr = head;

        int cnt = 0;
        while (curr != null) {
            if (cnt == len - k - 1) {
                p = curr;
                break;
            }
            cnt++;
            curr = curr.next;
        }

        tail.next = head;
        head = p.next;
        p.next = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateSortedArray(5);
        ListNode node = CommonUtil.makeListNode(arr);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 执行关键方法
        int k = 10;
        node = rotateRight(node, k);
        if (node != null) {
            node.print();
        }

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
