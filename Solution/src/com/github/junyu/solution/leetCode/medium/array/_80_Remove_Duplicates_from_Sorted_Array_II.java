package com.github.junyu.solution.leetCode.medium.array;


public class _80_Remove_Duplicates_from_Sorted_Array_II {


    /*Given a sorted array nums, remove the duplicates in-place such that
     duplicates appeared at most twice and return the new length.

    Do not allocate extra space for another array, you must do this by
    modifying the input array in-place with O(1) extra memory.

    Example 1:

    Given nums = [1,1,1,2,2,3],

    Your function should return length = 5, with the first five elements
     of nums being 1, 1, 2, 2 and 3 respectively.

    It doesn't matter what you leave beyond the returned length.
    Example 2:

    Given nums = [0,0,1,1,1,1,2,3,3],

    Your function should return length = 7, with the first seven elements
    of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

    It doesn't matter what values are set beyond the returned length.
    Clarification:

    Confused why the returned value is an integer but your answer is an array?

    Note that the input array is passed in by reference, which means
    modification to the input array will be known to the caller as well.

    Internally you can think of this:

    // nums is passed in by reference. (i.e., without making a copy)
    int len = removeDuplicates(nums);

    // any modification to nums in your function would be known by the caller.
    // using the length returned by your function, it prints the first len elements.
    for (int i = 0; i < len; i++) {
        print(nums[i]);
    }*/

    /**
     * 移除重复的元素，最多保留两个，要求不能使用额外空间
     * 思路：对比前后两个元素，过程中记录相同元素的个数，不足两个时，先将当前的元素插入到index位置，index
     * 为当前元素要插入的位置，每次插入后index递增。
     * 如果两个元素不相同，则需要将count重置为1，同时将当前元素插入到index位置上。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length==0)
            return 0;

        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[index++] = nums[i];
                count = 1;
            } else {
                if (count < 2) {
                    nums[index++] = nums[i];
                }
                count++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        _80_Remove_Duplicates_from_Sorted_Array_II test = new _80_Remove_Duplicates_from_Sorted_Array_II();
        System.out.println(test.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(test.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
