package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _985_Sum_of_Even_Numbers_After_Queries {

    /*

    We have an array A of integers, and an array queries of queries.

    For the i-th query val = queries[i][0], index = queries[i][1],
    we add val to A[index].  Then, the answer to the i-th query is the
    sum of the even values of A.

            (Here, the given index = queries[i][1] is a 0-based index,
    and each query permanently modifies the array A.)

    Return the answer to all queries.  Your answer array should have answer[i]
    as the answer to the i-th query.



    Example 1:

    Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
    Output: [8,6,2,4]
    Explanation:
    At the beginning, the array is [1,2,3,4].
    After adding 1 to A[0], the array is [2,2,3,4],
    and the sum of even values is 2 + 2 + 4 = 8.
    After adding -3 to A[1], the array is [2,-1,3,4],
    and the sum of even values is 2 + 4 = 6.
    After adding -4 to A[0], the array is [-2,-1,3,4],
    and the sum of even values is -2 + 4 = 2.
    After adding 2 to A[3], the array is [-2,-1,3,6],
    and the sum of even values is -2 + 6 = 4.


    Note:

            1 <= A.length <= 10000
            -10000 <= A[i] <= 10000
            1 <= queries.length <= 10000
            -10000 <= queries[i][0] <= 10000
            0 <= queries[i][1] < A.length

    */

    /**
     * 统计处理过的数组的偶数和
     * 首先对原数组进行一次偶数的求和，然后在遍历queries数组，如果当前读到的元素在修改前
     * 是偶数，那么先将sum减去该元素。接着再处理元素，处理后再次判断修改后的是否为偶数，如果是则
     * 将元素累加进sum，并将sum添加到结果数组中。
     * @param A
     * @param queries
     * @return
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int sum = 0;
        int ans[] = new int[queries.length];

        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0)
                sum += A[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int curVal = queries[i][0];
            int curPos = queries[i][1];

            if ((A[curPos] & 1) == 0)
                sum -= A[curPos];

            A[curPos] = curVal + A[curPos];

            if ((A[curPos] & 1) == 0)
                sum += A[curPos];

            ans[i] = sum;
        }

        return ans;
    }

    public static void main(String[] args) {
        _985_Sum_of_Even_Numbers_After_Queries sum = new _985_Sum_of_Even_Numbers_After_Queries();
        System.out.println(Arrays.toString(sum.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }

}
