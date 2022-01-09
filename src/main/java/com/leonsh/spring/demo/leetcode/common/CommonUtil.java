package com.leonsh.spring.demo.leetcode.common;

public class CommonUtil {
    public static ListNode makeListNode(int[] list) {
        int index = 1;
        ListNode rootNode = new ListNode(list[0]);
        ListNode currNode = rootNode;
        while (index < list.length) {
            currNode.next = new ListNode(list[index]);
            currNode = currNode.next;
            index++;
        }
        return rootNode;
    }
}
