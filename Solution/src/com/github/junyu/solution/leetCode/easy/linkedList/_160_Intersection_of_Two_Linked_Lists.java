package com.github.junyu.solution.leetCode.easy.linkedList;

public class _160_Intersection_of_Two_Linked_Lists {

/*

    Write a program to find the node at which the intersection of two singly linked lists begins.


    For example, the following two linked lists:

    A:          a1 → a2
                        ↘
                         c1 → c2 → c3
                        ↗
    B:     b1 → b2 → b3
    begin to intersect at node c1.


    Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
*/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 求两个链表的相交起始位置
     * 获取两个链表的长度，
     * 将两个链表长度减到一致
     * 再依次比较两个链表，如果两个对象相同,比较当前就是相交的起始。
     * 一直比较到两个都为null，那么自然两个链表也就没有相交部分
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int al = getLen(headA);
        int bl = getLen(headB);

        while (al > bl) {
            headA = headA.next;
            al--;
        }

        while (bl > al) {
            headB = headB.next;
            bl--;
        }


        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getLen(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;

    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        node.next = node2;
//        node2.next = node3;

        ListNode node22 = new ListNode(3);
        ListNode node33 = new ListNode(2);
//        node22.next = node33;

        _160_Intersection_of_Two_Linked_Lists intersection_of_two_linked_lists = new _160_Intersection_of_Two_Linked_Lists();
        intersection_of_two_linked_lists.getIntersectionNode(node, node22);

    }
}
