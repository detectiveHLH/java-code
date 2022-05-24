package com.leonsh.java.code.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode node = this;
        System.out.printf("listNode: %s", node.val);
        node = node.next;
        if (node == null) {
            return;
        }

        System.out.print("->");

        while (node != null) {
            System.out.printf("%s", node.val);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }

        System.out.println();
        System.out.println();
    }
}
