package com.github.junyu.solution.leetCode.easy.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1389_Create_Target_Array_in_the_Given_Order {


   /* Given two arrays of integers nums and index. Your task is to create target array under the following rules:

    Initially target array is empty.
    From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
    Repeat the previous step until there are no elements to read in nums and index.
    Return the target array.

    It is guaranteed that the insertion operations will be valid.

    Example 1:

    Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
    Output: [0,4,1,3,2]
    Explanation:
    nums       index     target
        0            0        [0]
        1            1        [0,1]
        2            2        [0,1,2]
        3            2        [0,1,3,2]
        4            1        [0,4,1,3,2]
    Example 2:

    Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
    Output: [0,1,2,3,4]
    Explanation:
    nums       index     target
        1            0        [1]
        2            1        [1,2]
        3            2        [1,2,3]
        4            3        [1,2,3,4]
        0            0        [0,1,2,3,4]
    Example 3:

    Input: nums = [1], index = [0]
    Output: [1]


    Constraints:

    1 <= nums.length, index.length <= 100
    nums.length == index.length
    0 <= nums[i] <= 100
    0 <= index[i] <= i*/

    /**
     * 将元素nums[i]按index[i]的顺序插入数组
     * 思路：由于存在插入的位置已经存在元素时，需要后移后面的所有元素的位置，根据这个特征，正好可以采用arrayList,往指定位置添加元素。
     * 最后重新将list的元素导入进数组中返回。
     * @param nums
     * @param index
     * @return
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        _1389_Create_Target_Array_in_the_Given_Order test = new _1389_Create_Target_Array_in_the_Given_Order();
        System.out.println(Arrays.toString(test.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
        System.out.println(Arrays.toString(test.createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0})));
        System.out.println(Arrays.toString(test.createTargetArray(new int[]{1}, new int[]{0})));
    }
}
