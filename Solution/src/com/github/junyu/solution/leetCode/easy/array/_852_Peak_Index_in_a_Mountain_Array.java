package com.github.junyu.solution.leetCode.easy.array;

public class _852_Peak_Index_in_a_Mountain_Array {

   /* Let's call an array A a mountain if the following properties hold:

    A.length >= 3
    There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
    Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

    Example 1:

    Input: [0,1,0]
    Output: 1
    Example 2:

    Input: [0,2,1,0]
    Output: 1
    Note:

            3 <= A.length <= 10000
            0 <= A[i] <= 10^6
    A is a mountain, as defined above.*/

//    /**
//     * 求数组中最大值的索引
//     * 给定的数组是符合条件的，所以从第二个元素开始查找，只要大于maxIndex索引值，就更新maxIndex，一旦发现值开始变小，就可以直接返回max了
//     *
//     * @param A
//     * @return
//     */
//    public int peakIndexInMountainArray(int[] A) {
//        int maxIndex = 0;
//        for (int i = 1; i < A.length; i++) {
//            if (A[i] > A[maxIndex])
//                maxIndex = i;
//            else
//                return maxIndex;
//        }
//        return -1;
//    }

    /**
     * 用二分查找的思路去寻找，先取mid的值和mid+1去比，如果mid+1更大，那么继续继续在mid+1和n-1里去找。
     * 如果mid更大，就在左半部分寻找
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (A[mid] < A[mid + 1]) {//right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        _852_Peak_Index_in_a_Mountain_Array peak_index_in_a_mountain_array = new _852_Peak_Index_in_a_Mountain_Array();
        System.out.println(peak_index_in_a_mountain_array.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peak_index_in_a_mountain_array.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }
}
