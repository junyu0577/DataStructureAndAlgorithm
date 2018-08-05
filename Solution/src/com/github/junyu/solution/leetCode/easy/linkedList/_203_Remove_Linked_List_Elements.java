package com.github.junyu.solution.leetCode.easy.linkedList;

public class _203_Remove_Linked_List_Elements {


/*
    Remove all elements from a linked list of integers that have value val.

            Example:

    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
*/


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 先递归到底，在回溯过程中判断是否有要删除的元素
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        head.next = removeElements(head.next, val);

        if (head.val == val) {
            head = head.next;
        }

        return head;

    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        node.next = node2;
        node2.next = node3;

        _203_Remove_Linked_List_Elements remove_linked_list_elements = new _203_Remove_Linked_List_Elements();
        remove_linked_list_elements.removeElements(node, 2);
    }

}
