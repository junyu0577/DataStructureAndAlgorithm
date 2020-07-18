package com.github.junyu.solution.leetCode.easy.array;

public class _1512_Number_of_Good_Pairs {

    /*Given an array of integers nums.

    A pair (i,j) is called good if nums[i] == nums[j] and i < j.

    Return the number of good pairs.



    Example 1:

    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
            Example 2:

    Input: nums = [1,1,1,1]
    Output: 6
    Explanation: Each pair in the array are good.
            Example 3:

    Input: nums = [1,2,3]
    Output: 0


    Constraints:

            1 <= nums.length <= 100
            1 <= nums[i] <= 100
*/

    /**
     * 好数对的数目
     * 思路：统计出现的次数，根据次数去计算好奇数的对数数量。
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int ans = 0;
        for (int i : nums) {
            count[i]++;
        }
        for (int i : count) {
            ans += count(i);
        }
        return ans;
    }

    private int count(int num) {
        if (num < 2)
            return 0;

        return num * (num - 1) / 2;
    }

//    /**
//     * 好数对的数目
//     * 思路：两两比较统计相同元素的个数。
//     * @param nums
//     * @return
//     */
//    public int numIdenticalPairs(int[] nums) {
//        int ans = 0;
//        for (int i=0;i<nums.length-1;i++){
//            for (int j=i+1;j<nums.length;j++){
//                if (nums[i]== nums[j])
//                    ans++;
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        _1512_Number_of_Good_Pairs test = new _1512_Number_of_Good_Pairs();
        System.out.println(test.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(test.numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(test.numIdenticalPairs(new int[]{1, 2, 3}));
        System.out.println(test.numIdenticalPairs(new int[]{6, 5, 1, 5, 7, 7, 9, 1, 5, 7, 1, 6, 10, 9, 7, 4, 1, 8, 7,
                1, 1, 8, 6, 4, 7, 4, 10, 5, 3, 9, 10, 1, 9, 5, 5, 4, 1, 7, 4, 2, 9, 2, 6, 6, 4, 2, 10, 3, 5, 3, 6, 4,
                7, 4, 6, 4, 4, 6, 3, 4, 10, 1, 10, 6, 10, 4, 9, 6, 6, 4, 8, 6, 9, 5, 4}));
    }
}
