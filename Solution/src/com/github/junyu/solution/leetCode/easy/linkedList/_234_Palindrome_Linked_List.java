package com.github.junyu.solution.leetCode.easy.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/30 21:53
 */
public class _234_Palindrome_Linked_List {

  /*  Given a singly linked list, determine if it is a palindrome.

    Example 1:

    Input: 1->2
    Output: false
    Example 2:

    Input: 1->2->2->1
    Output: true
    Follow up:
    Could you do it in O(n) time and O(1) space?*/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 判断是否是回文
     * 首先将元素都放到list中，
     * 然后遍历n/2次，依次进行首尾缩进式判断，有不一致的就结束返回false。
     *
     * 时间 O(n+n/2) 空间为O(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i)))
                return false;
        }
        return true;

    }

    public static void main(String [] args){
        ListNode node = new ListNode(-129);
        ListNode node1 = new ListNode(-129);
        node.next = node1;
        System.out.println(isPalindrome(node));
    }

}
