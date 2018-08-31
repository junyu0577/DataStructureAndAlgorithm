package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;
import java.util.HashMap;

public class _496_Next_Greater_Element_I {

   /* You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are
    subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

    The Next Greater Number of a number x in nums1 is the first greater number to its right in
    nums2. If it does not exist, output -1 for this number.

            Example 1:
    Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
    Output: [-1,3,-1]
    Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
    Example 2:
    Input: nums1 = [2,4], nums2 = [1,2,3,4].
    Output: [3,-1]
    Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
    Note:
    All elements in nums1 and nums2 are unique.
    The length of both nums1 and nums2 would not exceed 1000.*/

    /**
     * 获取下一个更大的元素，如果nums2中对应的元素的下一个没有比他更大的就返回-1
     * 这题用暴力求解并不难，就是不断的从nums1的取出一个元素，然后找到nums2中他所在的位置，然后开始向后进行比较，如果后面有元素大于从nums1中取出
     * 的元素，就将赋值给res对应的位置。如果没有大于的，在遍历到最后一个元素时，直接赋值-1。
     * 如果每次从nums2的第0个元素开始查找，显示效率低，所以借助一个hashMap，直接快速的索引到达nums中所在的位置，key存元素的值，value存元素在nums2的索引。
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int pos = map.get(nums1[i]);
            while (pos < nums2.length) {
               if (nums1[i]<nums2[pos]){
                   res[i] = nums2[pos];
                   break;
               } else if(pos==nums2.length-1){
                   res[i] = -1;
               }
               pos++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums1[] = {4, 1, 2}; int nums2[] = {1, 3, 4, 2};
//        int nums1[] = {2, 4}; int nums2[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new _496_Next_Greater_Element_I().nextGreaterElement(nums1, nums2)));
    }
}
