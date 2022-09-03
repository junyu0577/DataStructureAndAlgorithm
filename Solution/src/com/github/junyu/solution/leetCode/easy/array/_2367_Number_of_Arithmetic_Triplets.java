package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashSet;
import java.util.Set;

public class _2367_Number_of_Arithmetic_Triplets {

    /*
    给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。
    如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：

    i < j < k ，
    nums[j] - nums[i] == diff 且
    nums[k] - nums[j] == diff
    返回不同 算术三元组 的数目。


    示例 1：

    输入：nums = [0,1,4,6,7,10], diff = 3
    输出：2
    解释：
            (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
            (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。

    示例 2：

    输入：nums = [4,5,6,7,8,9], diff = 2
    输出：2
    解释：
            (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
            (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
             

    提示：

            3 <= nums.length <= 200
            0 <= nums[i] <= 200
            1 <= diff <= 50
            nums 严格 递增
    */

    /**
     * 算术三元组的数目
     *
     * 定义ijk分别表示当前指向的三位数。
     * 从前三开始遍历，会出现四种情况
     * 1.如果j-i指向的小于dif说明不够大，需要尝试将j和k向后移。
     * 2.如果j-i指向的大于dif，就需要将i右移一位，从i与其挨着的后两个元素开始遍历。
     * 3.如果j-i与k-j正好相等则结果数量+1，并且i右移，从i与其挨着的后两个元素开始遍历
     * 4.说明j-i已经与dif相等，而k-j不相等,可以继续让k单独向右移动判断，同时也可以增加提
     * 前结束的条件（当k-j>dif后面的元素也不需要遍历）
     *
     *
     * Runtime: 3 ms, faster than 69.71% of Java online submissions for Number of Arithmetic Triplets.
     * Memory Usage: 40.1 MB, less than 96.25% of Java online submissions for Number of Arithmetic Triplets.
     *
     * @param nums
     * @param diff
     * @return
     */
//    public int arithmeticTriplets(int[] nums, int diff) {
//        int i = 0;
//        int j = i + 1;
//        int k = i + 2;
//        int ans = 0;
//        while (i <= nums.length - 3) {
//            if (nums[j] - nums[i] < diff) {
//                j++;
//                k++;
//            } else if (nums[j] - nums[i] > diff) {
//                i += 1;
//                j = i + 1;
//                k = i + 2;
//            } else if (nums[k] - nums[j] == diff) {
//                ans++;
//                i += 1;
//                j = i + 1;
//                k = i + 2;
//            } else {
//                k++;
//            }
//
//            if (k==nums.length){
//                i+=1;
//                j=i+1;
//                k=i+2;
//            }
//        }
//        return ans;
//
//    }

    /**
     * 使用hash表保存出现的元素，
     * 然后遍历数组，同时判断当前元素+diff和-diff是否存在与哈希表，存在则数量加一。
     *
     * Runtime: 2 ms, faster than 85.84% of Java online submissions for Number of Arithmetic Triplets.
     * Memory Usage: 42.2 MB, less than 44.44% of Java online submissions for Number of Arithmetic Triplets.
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for (int i=1;i<nums.length-1;i++){
            if (set.contains(nums[i]-diff) && set.contains(nums[i]+diff)){
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        _2367_Number_of_Arithmetic_Triplets test = new _2367_Number_of_Arithmetic_Triplets();
        System.out.println(test.arithmeticTriplets(new int[]{0,1,4,6,7,10},3));
        System.out.println(test.arithmeticTriplets(new int[]{4,5,6,7,8,9},2));
        System.out.println(test.arithmeticTriplets(new int[]{0, 2, 5, 6, 10}, 4));
    }
}
