package com.github.junyu.solution.leetCode.medium.array;

import java.util.Arrays;

public class _503_Next_Greater_Element_II {

  /*  Given a circular array (the next element of the last element is the first element of the array),
    print the Next Greater Number for every element. The Next Greater Number of a number x is
    the first greater number to its traversing-order next in the array, which means you could search circularly
    to find its next greater number. If it doesn't exist, output -1 for this number.

    Example 1:
    Input: [1,2,1]
    Output: [2,-1,2]
    Explanation: The first 1's next greater number is 2;
    The number 2 can't find next greater number;
    The second 1's next greater number needs to search circularly, which is also 2.
    Note: The length of given array won't exceed 10000.*/

    /**
     * 找出下一个更大的数，这题目在第一个版本上进行了拓展，要将数组看成是一个环，到最后一个元素以后，如果还没有比他更大的，要继续从数组
     * 的第0个元素开始比较，一直到他的本身的前一个元素。
     * 下面的实现不需要额外的内存开销，通过一个isLooped变量判断是否已经有过一次循环，如果到最后一个元素还没有循环过，那么再从0开始比较，一直比较到自身的
     * 上一个元素。
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            int start = i + 1;
            boolean isLooped = false;
            while (start < nums.length || !isLooped) {
                if (isLooped && start==i){
                    res[i] = -1;
                    break;
                }

                if (start == nums.length){
                    isLooped = true;
                    start = 0;
                    continue;
                }

                if (nums[i] < nums[start]) {
                    res[i] = nums[start];
                    break;
                } else if (start == nums.length - 1) {
                    if (!isLooped) {
                        isLooped = true;
                        start = 0;
                        continue;
                    } else {
                        res[i] = -1;
                    }
                }

                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _503_Next_Greater_Element_II().nextGreaterElements(new int[]{1, 2, 1})));
    }

}
