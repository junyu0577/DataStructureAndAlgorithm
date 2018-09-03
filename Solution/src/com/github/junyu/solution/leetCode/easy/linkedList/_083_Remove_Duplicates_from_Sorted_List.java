package com.github.junyu.solution.leetCode.easy.linkedList;

import com.github.junyu.solution.leetCode.easy.linkedList.entity.ListNode;

public class _083_Remove_Duplicates_from_Sorted_List {

/*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    Example 1:

    Input: 1->1->2
    Output: 1->2
    Example 2:

    Input: 1->1->2->3->3
    Output: 1->2->3
    */


//    /**
//     * solution1
//     * 在递归回溯的过程中进行值比较，比较当前节点的值与上一个节点的值，
//     * 如果一致就将node.next返回
//     *
//     * @param head
//     * @return
//     */
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        head.next = deleteDuplicates(head.val, head.next);
//        return head;
//    }
//
//    private ListNode deleteDuplicates(int val, ListNode node) {
//        if (node == null)
//            return null;
//
//        node.next = deleteDuplicates(node.val, node.next);
//
//        if (val == node.val)
//            return node.next;
//
//        return node;
//    }


//    /**
//     * solution3
//     * @param head
//     * @return
//     */
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null)
//            return null;
//
//        head.next = deleteDuplicates(head.next);
//
//        if (head.next!=null && head.next.val == head.val){
//            head.next = head.next.next;
//        }
//
//        return head;
//    }

    /**
     * solution2
     * 如果两个相邻的节点值相等，就让下一个节点指向next的next
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        _083_Remove_Duplicates_from_Sorted_List remove_duplicates_from_sorted_list = new _083_Remove_Duplicates_from_Sorted_List();
        remove_duplicates_from_sorted_list.deleteDuplicates(node);
    }

}
