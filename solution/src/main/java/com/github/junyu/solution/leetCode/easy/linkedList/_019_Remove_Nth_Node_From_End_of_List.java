package com.github.junyu.solution.leetCode.easy.linkedList;

/**
 * @author ShaoJunyu
 * @since 2018/7/31 09:36
 */
public class _019_Remove_Nth_Node_From_End_of_List {

   /* Given a linked list, remove the n-th node from the end of list and return its head.

    Example:

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:

    Given n will always be valid.

    Follow up:

    Could you do this in one pass?

    */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 定义一个count，通过遍历完整个链表获取链表的个数，
     * 定义另外一个变量removeIndex，这个就是要删除的元素的位置，
     * 依然使用递归回溯，一直到index==removeIndex后，找到了要删除的元素，判断一下下一个元素是否为空，
     * 如果为空直接返回null，不为空，就将node变成node.next
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        int count = 0;
        ListNode temp = head;
        while (head != null) {
            count++;
            head = head.next;
        }

        head = temp;
        int removeIndex = count + 1 - n;
        return remove(head, 1, removeIndex);

    }

    private static ListNode remove(ListNode node, int index, int removeIndex) {
        if (index == removeIndex) {//get
            if (node.next == null)
                return null;
            node.val = node.next.val;
            node.next = node.next.next;
            return node;
        } else {
            node.next = remove(node.next, index + 1, removeIndex);
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        removeNthFromEnd(node,2);
    }

}
