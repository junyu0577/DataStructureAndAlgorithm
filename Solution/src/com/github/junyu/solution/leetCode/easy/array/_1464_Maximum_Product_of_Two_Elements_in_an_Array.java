package com.github.junyu.solution.leetCode.easy.array;

public class _1464_Maximum_Product_of_Two_Elements_in_an_Array {

    /*Given the array of integers nums, you will choose two
    different indices i and j of that array. Return the maximum value of
            (nums[i]-1)*(nums[j]-1).

    Example 1:

    Input: nums = [3,4,5,2]
    Output: 12
    Explanation: If you choose the indices i=1 and j=2 (indexed from 0),
    you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) =
            (4-1)*(5-1) = 3*4 = 12.
    Example 2:

    Input: nums = [1,5,4,5]
    Output: 16
    Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will
    get the maximum value of (5-1)*(5-1) = 16.
    Example 3:

    Input: nums = [3,7]
    Output: 12


    Constraints:

            2 <= nums.length <= 500
            1 <= nums[i] <= 10^3
    */

    /**
     * 数组中两个最大元素的减一后的乘积
     * 思路：定义max和max2分别保存最大和次大的元素，如果当前遍历到的元素比最大的大，那么
     * 更新最大值，再将上一个最大值赋值给次大。
     * 如果当前的元素小于最大值，那么就和次大的进行比较，大于的话就更新次大。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int max2 = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>max){
                max2 = max;
                max = nums[i];
            }else {
                max2 = Math.max(max2,nums[i]);
            }
        }
        return (max-1)*(max2-1);
    }

    public static void main(String [] args) {
        _1464_Maximum_Product_of_Two_Elements_in_an_Array test = new _1464_Maximum_Product_of_Two_Elements_in_an_Array();
        System.out.println(test.maxProduct(new int[]{3,4,5,2}));
        System.out.println(test.maxProduct(new int[]{1,5,4,5}));
        System.out.println(test.maxProduct(new int[]{3,7}));
    }
}
