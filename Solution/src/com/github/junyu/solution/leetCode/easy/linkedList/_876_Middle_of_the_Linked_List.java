package com.github.junyu.solution.leetCode.easy.linkedList;

import com.github.junyu.solution.leetCode.easy.linkedList.entity.ListNode;

public class _876_Middle_of_the_Linked_List {

/*
    Given a non-empty, singly linked list with head node head, return a middle node of linked list.

    If there are two middle nodes, return the second middle node.



    Example 1:

    Input: [1,2,3,4,5]
    Output: Node 3 from this list (Serialization: [3,4,5])
    The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
    Note that we returned a ListNode object ans, such that:
    ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
            Example 2:

    Input: [1,2,3,4,5,6]
    Output: Node 4 from this list (Serialization: [4,5,6])
    Since the list has two middle nodes with values 3 and 4, we return the second one.


            Note:

    The number of nodes in the given list will be between 1 and 100.
    */


    /**
     * 设置快慢指针，fast每次走两步，slow每次走一步，
     * 直到fast的当前变成空（偶数）或者fast的next变成空（奇数），返回的slow就是从链表的中部开始的。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;

    }

    public static void main(String args[]) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;


        _876_Middle_of_the_Linked_List middle_of_the_linked_list = new _876_Middle_of_the_Linked_List();
        middle_of_the_linked_list.middleNode(node);
    }


}
