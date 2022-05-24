package com.leonsh.java.code.leetcode;

import com.leonsh.java.code.util.CommonUtil;
import com.leonsh.java.code.util.ListNode;
import org.springframework.util.StopWatch;

import java.util.*;

/**
 * LeetCode77
 *
 * @author leonsh
 * @date 2022-01-14 10:11
 **/
public class LeetCode77 {
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;
        List<Integer> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(list);
        ListNode node = new ListNode(list.get(0));
        ListNode mark = node;
        for (int i = 1; i < list.size(); i++) {
            ListNode currNode = new ListNode(list.get(i));
            currNode.next = null;

            node.next = currNode;
            node = node.next;
        }

        return mark;
    }

    public static void main(String[] args) {
//        int[] arr = CommonUtil.generateSortedArray(10);
//        CommonUtil.shuffle(arr);

        int[] arr = new int[]{4, 19, 14, 5, -3, 1, 8, 5, 11, 15};

        ListNode node = CommonUtil.makeListNode(arr);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 执行关键方法
        node = sortList(node);
        node.print();

        stopWatch.stop();
        System.out.printf("耗时: %sms", stopWatch.getTotalTimeMillis());
    }
}
