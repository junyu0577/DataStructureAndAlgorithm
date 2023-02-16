package com.github.junyu.solution.leetCode.easy.array;

public class _2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer {


//    给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
//
//    换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
//    注意：0 既不是正整数也不是负整数。
//
//             
//
//    示例 1：
//
//    输入：nums = [-2,-1,-1,1,2,3]
//    输出：3
//    解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
//    示例 2：
//
//    输入：nums = [-3,-2,-1,0,0,1,2]
//    输出：3
//    解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
//    示例 3：
//
//    输入：nums = [5,20,66,1314]
//    输出：4
//    解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
//             
//
//    提示：
//
//            1 <= nums.length <= 2000
//            -2000 <= nums[i] <= 2000
//    nums 按 非递减顺序 排列。


    /**
     * 正整数和负整数的最大计数
     * 先统计负数的个数，同时记录出现正整数的位置。
     * 循环结束后，判断一下特殊情况（全是0），那么直接返回0
     *
     * 否者就通过数组长度减去出现位置(正数个数)与count(负数个数)进行比较，谁大就返回谁
     *
     * @param nums
     * @return
     */
    public int maximumCount(int[] nums) {
        int count = 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                count++;

            if (nums[i] > 0) {
                pos = i;
                break;
            }
        }

        if (count == 0 && nums[0]==0)
            return 0;

        return count > nums.length - pos ? count : nums.length - pos;
    }


    public static void main(String[] args) {
        _2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer test = new _2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer();
        System.out.println(test.maximumCount(new int[]{0, 0}));
        System.out.println(test.maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
        System.out.println(test.maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
        System.out.println(test.maximumCount(new int[]{5, 20, 66, 1314}));
    }
}
