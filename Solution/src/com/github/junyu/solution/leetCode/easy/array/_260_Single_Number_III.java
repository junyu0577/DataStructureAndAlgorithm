package com.github.junyu.solution.leetCode.easy.array;

import java.util.*;

public class _260_Single_Number_III {


/*
    Given an array of numbers nums, in which exactly two elements appear only once and all
    the other elements appear exactly twice. Find the two elements that appear only once.

    Example:

    Input:  [1,2,1,3,2,5]
    Output: [3,5]
    Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?*/


//    /**
//     * 和第二版本不同的是，这次是找出所有单独出现的数，并且其中重复的数都是成对出现,single number固定为两个
//     * 用hashmap的解法和版本号差不多，key为数字，value为是否重复
//     *
//     * @param nums
//     * @return
//     */
//    public int[] singleNumber(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return null;
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
//        List<Integer> res = new ArrayList<>();
//        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
//            if (!entry.getValue())
//                res.add(entry.getKey());
//        }
//        int arr[] = new int[res.size()];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = res.get(i);
//        }
//        return arr;
//    }


    /**
     * 解法二
     * 先对数组进行一次排序,然后先对头尾进行判断，0和1不同0就是single， n-1和n-2不同，那n-1就是single。
     * 然后从第一个元素遍历到倒数第二个元素，如果某一个元素和左边以及右边都不同，那就是single,
     * 由于整个数组最多就只会出现两个single number，那么在res有两个元素以后就可以break了
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        if (nums[0] != nums[1])//第一个single
            res.add(nums[0]);
        if (nums[nums.length - 1] != nums[nums.length - 2]) {//最后一个single
            res.add(nums[nums.length - 1]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                res.add(nums[i]);
                if (res.size() == 2)
                    break;
            }
        }
        int arr[] = new int[2];
        arr[0] = res.get(0);
        arr[1] = res.get(1);
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 2, 5};
        _260_Single_Number_III single_number_iii = new _260_Single_Number_III();
        System.out.println(Arrays.toString(single_number_iii.singleNumber(arr)));

    }

}
