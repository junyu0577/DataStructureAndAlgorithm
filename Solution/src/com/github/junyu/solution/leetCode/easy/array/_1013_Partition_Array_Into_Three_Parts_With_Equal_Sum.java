package com.github.junyu.solution.leetCode.easy.array;


public class _1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {

   /* Given an array A of integers, return true if and only if we can partition 
    the array into three non-empty parts with equal sums.

    Formally, we can partition the array if we can find indexes i+1 < j 
    with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] ==
                    A[j] + A[j-1] + ... + A[A.length - 1])

    Example 1:

    Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
    Output: true
    Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
    Example 2:

    Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
    Output: false
    Example 3:

    Input: A = [3,3,6,5,-2,2,5,1,-9,4]
    Output: true
    Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4


    Constraints:

            3 <= A.length <= 50000
            -10^4 <= A[i] <= 10^4*/

    /**
     * 将数组拆分为三个连续子串使得他们的元素之和相等
     * 思路：先统计数组的元素总和，如果总和不能被3整除说明无法被拆分成三个等额子串。
     * 然后遍历子串，通过不断的累加当前的元素，直到之和与平均数相同，再重新开始从累加，直到count满足三个。
     * 最后在遍历剩余的元素，如果他们的和为0，那么仍然是满足条件的。
     *
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }

        if (sum % 3 != 0)
            return false;

        int average = sum / 3;

        int partSum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            partSum += A[i];
            if (partSum == average) {
                count++;
                partSum = 0;
            }
            if (count == 3) {
                for (int j = i + 1; j < A.length; j++) {
                    partSum += A[j];
                }

                return partSum == 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        _1013_Partition_Array_Into_Three_Parts_With_Equal_Sum test = new _1013_Partition_Array_Into_Three_Parts_With_Equal_Sum();
        System.out.println(test.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(test.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(test.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(test.canThreePartsEqualSum(new int[]{12, -4, 16, -5, 9, -3, 3, 8, 0}));
    }
}
