package com.leonsh.java.code.util;

/**
 * Node 类2e23
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public void print() {
        Node node = this;
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