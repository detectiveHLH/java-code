package com.leonsh.spring.demo.leetcode;

import com.leonsh.spring.demo.leetcode.common.CommonUtil;
import com.leonsh.spring.demo.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode206 {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr = curr.next;
            pre = curr;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5};
        ListNode node = CommonUtil.makeListNode(list);
        reverseList(node);
    }
}
