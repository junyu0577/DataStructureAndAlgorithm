package com.github.junyu.solution.leetCode.easy.array;

import java.util.LinkedList;
import java.util.List;

public class _989_Add_to_Array_Form_of_Integer {

    /*
    For a non-negative integer X, the array-form of X is an
    array of its digits in left to right order.  For example,
    if X = 1231, then the array form is [1,2,3,1].

    Given the array-form A of a non-negative integer X,
            return the array-form of the integer X+K.

    Example 1:

    Input: A = [1,2,0,0], K = 34
    Output: [1,2,3,4]
    Explanation: 1200 + 34 = 1234
    Example 2:

    Input: A = [2,7,4], K = 181
    Output: [4,5,5]
    Explanation: 274 + 181 = 455
    Example 3:

    Input: A = [2,1,5], K = 806
    Output: [1,0,2,1]
    Explanation: 215 + 806 = 1021
    Example 4:

    Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
    Output: [1,0,0,0,0,0,0,0,0,0,0]
    Explanation: 9999999999 + 1 = 10000000000


    Note：

            1 <= A.length <= 10000
            0 <= A[i] <= 9
            0 <= K <= 10000
    If A.length > 1, then A[0] != 0
    */

    /**
     * 计算数组和K的和
     * 首先将K拆分成多个个位数按顺序放进链表中。然后循环链表，从末尾开始和A的末尾一一对应的
     * 进行求和，如果超过两位数则记录在remain中，再下一个的元素求和时再增加上remain。
     * 另外还有情况是数组A的长度可能比k的数组长，那么还要补充上剩余的靠前的所有元素。
     * 最后如果remain还是大于1，还需要在结果list的第一个位置补充1。
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        while (K > 0) {
            ((LinkedList<Integer>) list).addFirst(K % 10);
            K /= 10;
        }

        int pos = A.length - 1;
        int remain = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int cur = 0;
            if (pos >= 0)
                cur = A[pos];

            int sum = list.get(i) + remain + cur;
            remain = sum / 10;

            ((LinkedList<Integer>) ans).addFirst(sum % 10);
            pos--;
        }

        while (pos >= 0) {
            ((LinkedList<Integer>) ans).addFirst((A[pos] + remain) % 10);
            remain = (A[pos] + remain) / 10;
            pos--;
        }

        if (remain > 0)
            ((LinkedList<Integer>) ans).addFirst(1);

        return ans;

    }

    public static void main(String[] args) {
        _989_Add_to_Array_Form_of_Integer add_to_array_form_of_integer = new _989_Add_to_Array_Form_of_Integer();
        System.out.println(add_to_array_form_of_integer.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(add_to_array_form_of_integer.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(add_to_array_form_of_integer.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(add_to_array_form_of_integer.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        System.out.println(add_to_array_form_of_integer.addToArrayForm(new int[]{0}, 23));
    }
}
