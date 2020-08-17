package com.github.junyu.solution.leetCode.medium.array;

public class _1551_Minimum_Operations_to_Make_Array_Equal {

    /*You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).

     In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x]
     and add 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements
     of the array equal. It is guaranteed that all the elements of the array can be made equal using some operations.

     Given an integer n, the length of the array. Return the minimum number of operations needed to make all
     the elements of arr equal.

    Example 1:

    Input: n = 3
    Output: 2
    Explanation: arr = [1, 3, 5]
    First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
    In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].
    Example 2:

    Input: n = 6
    Output: 9

    Constraints:

            1 <= n <= 10^4*/

    /**
     * 使数组中所有元素相等的最小操作数
     * 思路：首先获取中间位的数字，如果是长度为奇数mid为(half - 1) * 2 + 2。长度为偶数则mid为half*2+1。
     * 然后遍历[1,mid)，并将mid和当前元素的差值累加进ans。
     * @param n
     * @return
     */
    public int minOperations(int n) {
        int half = n / 2;
        int ans = 0;
        int mid;
        if ((n & 1) == 0) {
            mid = (half - 1) * 2 + 2;
        } else {
            mid = half * 2 + 1;
        }
        for (int i = 1; i < mid; i += 2) {
            ans += mid - i;
        }

        return ans;
    }

    public static void main(String[] args) {
        _1551_Minimum_Operations_to_Make_Array_Equal test = new _1551_Minimum_Operations_to_Make_Array_Equal();
        System.out.println(test.minOperations(3));
        System.out.println(test.minOperations(5));
        System.out.println(test.minOperations(6));
        System.out.println(test.minOperations(7));
        System.out.println(test.minOperations(8));
    }
}
