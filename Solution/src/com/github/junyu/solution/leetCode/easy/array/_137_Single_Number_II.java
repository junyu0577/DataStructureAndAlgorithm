package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _137_Single_Number_II {


/*
    Given a non-empty array of integers, every element appears three times
        except for one, which appears exactly once. Find that single one.

    Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,3,2]
    Output: 3
    Example 2:

    Input: [0,1,0,1,0,1,99]
    Output: 99*/

//    /**
//     * 升级版的单独的数，和之前的版本不同的是，这题重复的元素都会出现三次
//     * 使用hashmap，key为数字，值为boolean的表示是否存在多个，迭代map查看值为false的数字就是single number
//     *
//     * @param nums
//     * @return
//     */
//    public int singleNumber(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return -1;
//
//        HashMap<Integer, Boolean> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.get(nums[i]) == null)
//                map.put(nums[i], false);
//            else {
//                map.put(nums[i], true);
//            }
//        }
//
//        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
//            if (!entry.getValue())
//                return entry.getKey();
//        }
//
//        return -1;
//    }

    /**
     * 题目要求不能使用额外的空间，那就还一种思路解
     * 先对数组进行一次排序,然后先对头尾进行判断，0和1不同0就是single， n-1和n-2不同，那n-1就是single。
     * 然后从第一个元素遍历到倒数第二个元素，如果某一个元素和左边以及右边都不同，那就是single
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        Arrays.sort(nums);

        if (nums[0] != nums[1])//第一个single
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) {//最后一个single
            return nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int arr[] = {2, 2, 3, 2};
//        int arr[] = {2, 2, 2, 3, 4, 4, 4};
        int arr[] = {2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6};
//        int arr[] = {40,-15,51,-33,41,19,-5,28,-50,-12,48,-46,-26,-37,41,54,51,-29,-30,-49,29,4,-7,30,18,32,6,9,24,-15,-13,12,20,-8,6,53,18,14,-2,-46,-25,-22,-20,-46,-28,-35,18,15,-3,49,54,-20,55,28,-39,4,52,-12,37,29,-29,15,50,46,42,-22,11,43,49,40,16,-3,-13,-33,-7,25,16,-24,-34,-50,-31,-37,-50,6,44,-25,-15,25,11,47,40,41,-24,32,49,-20,-29,-33,52,-2,-49,48,-25,24,-42,-37,39,-6,-49,54,-30,-44,15,-42,-28,-22,20,25,-30,-48,-31,12,-40,20,-14,-16,-40,42,-12,46,-1,-35,-6,39,-8,-32,50,-31,43,28,32,-8,5,-3,-48,11,5,55,9,-39,-39,42,-7,33,-35,9,14,-34,53,51,-32,30,44,50,-48,-44,-6,-5,19,12,-26,-16,-13,53,33,-1,23,4,-16,37,29,16,44,19,46,-32,39,5,47,-28,37,43,52,-42,33,24,-40,30,-24,48,-34,-5,-14,47,-14,55,-26,-2,-1,-44,14};
//        int arr[] = {0, 1, 0, 1, 0, 1, 99};
        _137_Single_Number_II single_number_ii = new _137_Single_Number_II();
        System.out.println(single_number_ii.singleNumber(arr));
    }


}
