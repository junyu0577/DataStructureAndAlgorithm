package com.github.junyu.solution.leetCode.easy.linkedList.entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr is empty !");

        this.val = arr[0];
        ListNode cur = this;
        for (int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {

            sb.append(node.val + "->");

            node = node.next;
        }
        sb.append("NULL");

        return sb.toString();
    }
}
