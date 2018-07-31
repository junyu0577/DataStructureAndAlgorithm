package com.github.junyu.solution.leetCode.easy.linkedList;

/**
 * @author ShaoJunyu
 * @since 2018/7/31 08:05
 */
public class Merge_Two_Sorted_Lists {


    /*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4*/


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode head;
        if (l1.val < l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    head = add(head, l1.val);
                    l1 = l1.next;
                } else {
                    head = add(head, l2.val);
                    l2 = l2.next;
                }
            } else if (l2 != null) {
                head = add(head, l2.val);
                l2 = l2.next;
            } else {// l1 != null
                head = add(head, l1.val);
                l1 = l1.next;
            }
        }
        return head;
    }


    private static ListNode add(ListNode node, int val) {
        if (node == null) {
            return new ListNode(val);
        } else {
            node.next = add(node.next, val);
            return node;
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        node.next = node1;
        node1.next = node4;

        ListNode node11 = new ListNode(1);
        ListNode node33 = new ListNode(3);
        ListNode node44 = new ListNode(4);

        node11.next = node33;
        node33.next = node44;

        mergeTwoLists(node, node11);
    }

}
