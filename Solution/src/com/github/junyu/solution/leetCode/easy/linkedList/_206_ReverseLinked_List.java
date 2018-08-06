package com.github.junyu.solution.leetCode.easy.linkedList;


import com.github.junyu.solution.leetCode.easy.linkedList.entity.ListNode;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/30 20:40
 */
public class _206_ReverseLinked_List {

/*    Reverse a singly linked list.

            Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
    Follow up:

    A linked list can be reversed either iteratively or recursively. Could you implement both?*/


    /**
     * 翻转链表
     * 定义一个pre的空节点，后续所有的节点都将通过head赋值给pre
     * 然后开始遍历整个链表
     * 1.先保存一份head.next
     * 2.将pre赋值给head.next，即head的next变成了pre，这时候的head没变,只是head.next变成了pre
     * 3.将head赋值给pre，此时的pre已经完成了两个节点的交换
     * 4.将temp赋值给head，使得整个链表继续遍历下去，直到head为null，pre里就完整的保存的翻转后的链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        System.out.println(reverseList(node));
    }

}
