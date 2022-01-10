package com.leonsh.spring.demo.util;

/**
 * CommonUtil
 *
 * @author leonsh
 * @date 2022-01-10 14:38
 **/
public class CommonUtil {
    /**
     * 生成 count 长度的有序数组
     *
     * @param count 要生成的数组长度
     * @return 生成好的有序数组
     */
    public static int[] generateSortedArray(int count) {
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = i + 1;
        }
        return res;
    }

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
