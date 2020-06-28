package com.github.junyu.solution.leetCode.medium.array;

public class _1493_Longest_Subarray_of_1s_After_Deleting_One_Element {


    /*Given a binary array nums, you should delete one element from it.

    Return the size of the longest non-empty subarray containing only 1's in the resulting array.

    Return 0 if there is no such subarray.

    Example 1:

    Input: nums = [1,1,0,1]
    Output: 3
    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
    Example 2:

    Input: nums = [0,1,1,1,0,1,1,0,1]
    Output: 5
    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,
    1,1,1,1].
    Example 3:

    Input: nums = [1,1,1]
    Output: 2
    Explanation: You must delete one element.
            Example 4:

    Input: nums = [1,1,0,0,1,1,1,0,1]
    Output: 4
    Example 5:

    Input: nums = [0,0,0]
    Output: 0


    Constraints:

            1 <= nums.length <= 10^5
    nums[i] is either 0 or 1.*/

    /**
     * 删掉一个元素以后全为 1 的最长子数组
     * 思路：遍历数组遇到1时记录次数（leftOneCount）,当遇到0以后，向后寻找1的数量，将左右两边的数量求和与最大值进行比较。
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int count = 0;
        int leftOneCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0)
                        break;
                    count++;
                }
                ans = Math.max(ans, count+leftOneCount);
                count = 0;
                leftOneCount = 0;
            } else {
                leftOneCount++;
            }
        }
        if (ans == 0 && nums[0] == 1)
            return nums.length - 1;

        return ans;
    }

    public static void main(String[] args) {
        _1493_Longest_Subarray_of_1s_After_Deleting_One_Element test =
                new _1493_Longest_Subarray_of_1s_After_Deleting_One_Element();
        System.out.println(test.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(test.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(test.longestSubarray(new int[]{1, 1, 1}));
        System.out.println(test.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
        System.out.println(test.longestSubarray(new int[]{0, 0, 0}));
    }
}
