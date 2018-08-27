package com.github.junyu.solution.leetCode.medium.array;

public class _540_Single_Element_in_a_Sorted_Array {

/*
    Given a sorted array consisting of only integers where every element appears
    twice except for one element which appears once. Find this single element that appears only once.

    Example 1:
    Input: [1,1,2,3,3,4,4,8,8]
    Output: 2
    Example 2:
    Input: [3,3,7,7,10,11,11]
    Output: 10
    Note: Your solution should run in O(log n) time and O(1) space.*/

//    /**
//     * 找到唯一出现过一次的数，其他的数都出现两次
//     * 那么将数组中的每一个数与0异或，结果就是只出现一次的数
//     * 时间复杂度O(n)
//     * @param nums
//     * @return
//     */
//    public int singleNonDuplicate(int[] nums) {
//        int res = 0;
//        for (int i=0;i<nums.length;i++){
//            res = res ^ nums[i];
//        }
//        return res;
//    }

    /**
     * 题目要求时间复杂度是logN，并且数组是已经排序的，那么很自然的就想到了二分查找
     * 取到mid时，判断mid和左右是否有相同的，如果都不同，那么mid就是唯一的。
     * 如果和左边相同，那么查看除左边的数后，剩下的数字总数都是是偶数，是偶数继续考查mid+1到right的范围，奇数则考查left到mid-1。
     * 如果和右边相同，那么同样的排除后边的数后，剩下的是否是偶数，是偶数就考查left到mid-1,反之考查mid+1到right
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            else if (nums[mid] == nums[mid - 1]) {//和左边相等
                if ((mid - 1) % 2 == 0)
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if ((nums.length - mid) % 2 == 0)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new _540_Single_Element_in_a_Sorted_Array().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(new _540_Single_Element_in_a_Sorted_Array().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(new _540_Single_Element_in_a_Sorted_Array().singleNonDuplicate(new int[]{1,2,2}));
        System.out.println(new _540_Single_Element_in_a_Sorted_Array().singleNonDuplicate(new int[]{2,2,3}));
        System.out.println(new _540_Single_Element_in_a_Sorted_Array().singleNonDuplicate(new int[]{0, 1, 1, 2, 2, 5, 5}));
    }
}



