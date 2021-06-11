package com.github.junyu.solution.leetCode.easy.array;

public class _1748_Sum_of_Unique_Elements {

    /*
    You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

    Return the sum of all the unique elements of nums.



    Example 1:
    Input: nums = [1,2,3,2]
    Output: 4
    Explanation: The unique elements are [1,3], and the sum is 4.

    Example 2:
    Input: nums = [1,1,1,1,1]
    Output: 0
    Explanation: There are no unique elements, and the sum is 0.

    Example 3:
    Input: nums = [1,2,3,4,5]
    Output: 15
    Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.


    Constraints:

            1 <= nums.length <= 100
            1 <= nums[i] <= 100
    */

    /**
     * 唯一元素的和
     * hash表统计元素出现次数，然后遍历hash表，累加所有出现次数为1的元素。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Unique Elements.
     * Memory Usage: 38.6 MB, less than 10.75% of Java online submissions for Sum of Unique Elements.
     *
     * @param nums
     * @return
     */
    public int sumOfUnique(int[] nums) {
        int [] hash = new int[101];
        int ans = 0;
        for (int i=0;i<nums.length;i++) {
            hash[nums[i]]++;
        }
        for (int i=0;i<hash.length;i++){
            if (hash[i]==1){
                ans+=i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1748_Sum_of_Unique_Elements test = new _1748_Sum_of_Unique_Elements();
        System.out.println(test.sumOfUnique(new int[]{1,2,3,2}));
        System.out.println(test.sumOfUnique(new int[]{1,1,1,1,1}));
        System.out.println(test.sumOfUnique(new int[]{1,2,3,4,5}));
    }
}
