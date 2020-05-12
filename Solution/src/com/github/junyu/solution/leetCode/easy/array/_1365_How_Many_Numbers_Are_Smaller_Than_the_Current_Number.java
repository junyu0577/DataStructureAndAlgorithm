package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {

  /*  Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
    That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

    Return the answer in an array.

    Example 1:

    Input: nums = [8,1,2,2,3]
    Output: [4,0,1,1,3]
    Explanation:
    For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
    For nums[1]=1 does not exist any smaller number than it.
    For nums[2]=2 there exist one smaller number than it (1).
    For nums[3]=2 there exist one smaller number than it (1).
    For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
    Example 2:

    Input: nums = [6,5,4,8]
    Output: [2,1,0,3]
    Example 3:

    Input: nums = [7,7,7,7]
    Output: [0,0,0,0]


    Constraints:

            2 <= nums.length <= 500
            0 <= nums[i] <= 100
*/


    /**
     * 统计比当前元素小的元素数量
     * 思路：思路基本同第一种解法，区别在于第一次统一完每个元素的出现的次数后，通过遍历count数组，统计截至当前元素的元素数量之和，后续在获取
     * 小于某一个元素的数量时，就可以方便的在count[nums[i]-1]获取对应的数量，节省了方案一每次都需要遍历count进行数量的累加操作。
     *
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int ans[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                ans[i] = 0;
            }else {
                ans[i] = count[num-1];
            }
        }

        return ans;
    }


//    /**
//     * 统计比当前元素小的元素数量
//     * 思路：由于元素的取值范围是0-100所以定义一个长度为101的数组，存放所有元素出现的次数。
//     * 然后通过遍历原始数组，将当前的元素取出来，在统计次数的数组中，从比当前元素小1的索引位置开始遍历，累加这些元素出现的
//     * 次数获得比当前元素小的元素数量。
//     *
//     * @param nums
//     * @return
//     */
//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int [] count = new int[101];
//        for (int i=0;i<nums.length;i++){
//            count[nums[i]]++;
//        }
//
//        int ans [] = new int[nums.length];
//        int point = 0;
//        int len = nums.length;
//        while (point<len){
//            int total = 0;
//            for (int i=nums[point]-1;i>=0;i--){
//                if (count[i]>0){
//                    total += count[i] ;
//                }
//            }
//            ans[point] = total;
//            point++;
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {
        _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number test =
                new _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number();
        System.out.println(Arrays.toString(test.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(test.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(test.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
    }
}
