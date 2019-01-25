package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _976_Largest_Perimeter_Triangle {

   /*
    Given an array A of positive lengths, return the largest perimeter
    of a triangle with non-zero area, formed from 3 of these lengths.

    If it is impossible to form any triangle of non-zero area, return 0.

    Example 1:

    Input: [2,1,2]
    Output: 5
    Example 2:

    Input: [1,2,1]
    Output: 0
    Example 3:

    Input: [3,2,3,4]
    Output: 10
    Example 4:

    Input: [3,6,2,3]
    Output: 8


    Note:

            3 <= A.length <= 10000
            1 <= A[i] <= 10^6
    */

    /**
     * 找出能形成最大三角的元素，求和后返回
     * 刚开始的思路是利用组合的方式进行求解，但是超时了。
     * 那么换一种解法，先对数组进行一次排序，然后从后开始向前进行遍历，每次判断三个元素。
     * 三角尺形成的条件是最小的两边大于第三边。那么只要三个为一组，不满足条件就剔除掉最大的元素，
     * 向前推进就可以了。
     *
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {

        Arrays.sort(A);

        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        _976_Largest_Perimeter_Triangle largest_perimeter_triangle = new _976_Largest_Perimeter_Triangle();
        System.out.println(largest_perimeter_triangle.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(largest_perimeter_triangle.largestPerimeter(new int[]{1, 2, 1}));
        System.out.println(largest_perimeter_triangle.largestPerimeter(new int[]{3, 2, 3, 4}));
        System.out.println(largest_perimeter_triangle.largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}
