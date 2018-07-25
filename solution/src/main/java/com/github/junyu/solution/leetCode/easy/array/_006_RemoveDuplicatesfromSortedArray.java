package com.github.junyu.solution.leetCode.easy.array;


/**
 * @author ShaoJunyu
 * @since 2018/6/13 09:45
 */
public class _006_RemoveDuplicatesfromSortedArray {



    /*
    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    */

  /*
    Example:
    Given nums = [1,1,2],
    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
    It doesn't matter what you leave beyond the returned length.

    Given nums = [0,0,1,1,1,2,2,3,3,4],
    Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
    It doesn't matter what values are set beyond the returned length.
    */

    /**
     * 思路：起始point指向第一个元素，每次用point所指得元素去比较后续得每一个元素，循环从第二个元素开始，每当遇到相同
     * 得元素就跳过，遇到不同得就将值赋给point得next元素
     * 赋值得次数+1就是去重后得数组长度
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int point = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[point] != nums[i]) {
                point++;
                nums[point] = nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
        return point + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
//        int[] arr = {1,2,3};
//        int[] arr = {};
        System.out.println(removeDuplicates(arr));
    }
}
