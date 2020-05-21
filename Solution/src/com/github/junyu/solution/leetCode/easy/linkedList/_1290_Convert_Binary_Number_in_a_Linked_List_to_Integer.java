package com.github.junyu.solution.leetCode.easy.linkedList;

import com.github.junyu.solution.data_structure.utils.LinkedListMaker;
import com.github.junyu.solution.leetCode.easy.linkedList.entity.ListNode;


public class _1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {


    /*Given head which is a reference node to a singly-linked list.
     The value of each node in the linked list is either 0 or 1.
     The linked list holds the binary representation of a number.

    Return the decimal value of the number in the linked list.

    Example 1:


    Input: head = [1,0,1]
    Output: 5
    Explanation: (101) in base 2 = (5) in base 10
    Example 2:

    Input: head = [0]
    Output: 0
    Example 3:

    Input: head = [1]
    Output: 1
    Example 4:

    Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
    Output: 18880
    Example 5:

    Input: head = [0,0]
    Output: 0


    Constraints:

    The Linked List is not empty.
    Number of nodes will not exceed 30.
    Each node's value is either 0 or 1.*/

    /**
     * 求链表元素组成的二进制数转为十进制后的值
     * 思路：由于我们从二进制的头部开始计算，所以需要不断的左移，从而将这些元素真正的值和他所处的位置相对应。
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans << 1;
            ans += head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1290_Convert_Binary_Number_in_a_Linked_List_to_Integer test = new _1290_Convert_Binary_Number_in_a_Linked_List_to_Integer();
        System.out.println(test.getDecimalValue(LinkedListMaker.array2LinkedList(new int[]{1, 0, 1})));
        System.out.println(test.getDecimalValue(LinkedListMaker.array2LinkedList(new int[]{0})));
        System.out.println(test.getDecimalValue(LinkedListMaker.array2LinkedList(new int[]{1})));
        System.out.println(test.getDecimalValue(LinkedListMaker.array2LinkedList(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0})));
        System.out.println(test.getDecimalValue(LinkedListMaker.array2LinkedList(new int[]{0, 0})));
    }
}
