package com.github.junyu.solution.leetCode.easy.linkedList;


/**
 * @author ShaoJunyu
 * @since 2018/7/30 08:34
 */
public class _141_Linked_List_Cycle {

    /*Given a linked list, determine if it has a cycle in it.

    Follow up:
    Can you solve it without using extra space?*/

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 验证linkList是否是形成一个环
     * 不断的向后进行遍历，每遍历到一个就将其的next指向head（也就是自己），如果head的next为null那肯定就不会环。
     * 如果head和head.next相同，那说明是一个环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        while (head != null) {
            if (head==head.next)
                return true;

            ListNode temp = head.next;
            head.next = head;
            head = temp;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node1;
        System.out.println(hasCycle(node));
    }
}
