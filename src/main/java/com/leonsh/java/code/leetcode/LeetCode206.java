package com.leonsh.java.code.leetcode;

import com.leonsh.java.code.util.CommonUtil;
import com.leonsh.java.code.util.ListNode;
import org.springframework.util.StopWatch;

public class LeetCode206 {
    /**
     * 基础解法——迭代
     * 并不是真正要反转链表, 而是要改变所有节点 next 的指向. 例如原来是 1->2->3
     * 我们只需要改成 1.next=null 2.next=1 3.next=2 即可
     * 所以思路就是需要一个 pre 来记录最后赋值的内容, 并且由于需要更改 curr.next
     * 的值, 所以需要 next 变量将其暂存下来用于往后推动 while 循环
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateSortedArray(5);
        ListNode node = CommonUtil.makeListNode(arr);

        StopWatch stopWatch = new StopWatch("206");
        stopWatch.start();

        // 执行关键方法
        node = reverseList(node);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
