package com.github.junyu.solution.data_structure.utils;

import com.github.junyu.solution.leetCode.easy.linkedList.entity.ListNode;


public class LinkedListMaker {

    public static ListNode array2LinkedList(int[] arr) {
        ListNode tail = new ListNode(arr[arr.length - 1]);
        ListNode head = null;
        for (int i = arr.length - 2; i >= 0; i--) {
            head = new ListNode(arr[i]);
            head.next = tail;
            tail = head;
        }
        return head==null?tail:head;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedListMaker.array2LinkedList(new int[]{1, 2, 3,4,5});
        System.out.println(listNode);
    }
}
