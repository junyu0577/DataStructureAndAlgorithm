package com.github.junyu.solution.leetCode.medium.linkedList;

import com.github.junyu.solution.leetCode.easy.linkedList.entity.ListNode;

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


//    /**
//     * 定义一个count，通过遍历完整个链表获取链表的个数，
//     * 定义另外一个变量removeIndex，这个就是要删除的元素的位置，
//     * 依然使用递归回溯，一直到index==removeIndex后，找到了要删除的元素，判断一下下一个元素是否为空，
//     * 如果为空直接返回null，不为空，就将node变成node.next
//     *
//     * @param head
//     * @param n
//     * @return
//     */
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null)
//            return null;
//        int count = 0;
//        ListNode temp = head;
//        while (head != null) {
//            count++;
//            head = head.next;
//        }
//
//        head = temp;
//        int removeIndex = count + 1 - n;
//        return remove(head, 1, removeIndex);
//
//    }
//
//    private static ListNode remove(ListNode node, int index, int removeIndex) {
//        if (index == removeIndex) {//get
//            if (node.next == null)
//                return null;
//            node.val = node.next.val;
//            node.next = node.next.next;
//            return node;
//        } else {
//            node.next = remove(node.next, index + 1, removeIndex);
//            return node;
//        }
//    }

    private int count = 0;

//    /**
//     * solution2 在递归回溯的过程中，维护一个count变量，也就是从最后开始累加，当累加到和n相等时，
//     * 说明已经是倒数第n的元素，那么只需要将当前的节点的next赋值给当前节点，就完成了删除操作
//     * @param head
//     * @param n
//     * @return
//     *//*
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null)
//            return null;
//
//        head.next = removeNthFromEnd(head.next, n);
//        count++;
//        if (count==n){
//            head = head.next;
//        }
//
//        return head;
//    }
//*/

    /**
     * solution3 先建立一个虚拟头节点，接着设置快慢指针。先让快指针走n+1步，然后两个指针一起向后移，当快指针为空时，
     * 说明已经遍历到尾部。然后将慢指针的下一个指向下下一个元素。这样虚拟头节点的next就是删除指定元素后的链表
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode listNode = new ListNode(0);
        listNode.next = head;

        ListNode fast = listNode;
        ListNode slow = listNode;

        for (int i=0;i<n+1;i++){
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return listNode.next;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        _019_Remove_Nth_Node_From_End_of_List remove_nth_node_from_end_of_list = new _019_Remove_Nth_Node_From_End_of_List();
        ListNode listNode = remove_nth_node_from_end_of_list.removeNthFromEnd(node, 1);
        System.out.println(listNode);
    }

}
