package com.github.junyu.solution.easy.array;

import java.util.Arrays;

/**
 * @author ShaoJunyu
 * @since 2018/6/13 11:46
 */
public class _008_PlusOne {

  /*
    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.
    */


   /*
    Example :
    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.

    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
    */

    /**
     * 思路：遇到9就跳过对元素做置零操作，遇到小于9得元素就递增，return完成。
     * 如果数组中所有得元素都是9，则需要创建一个原数组+1长度得数组，并将首位元素
     * 置为0完成操作
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;

        return newArr;

    }

    public static void main(String[] args) {
//        int[] digits = {1, 2, 2, 1};
        int[] digits = {9, 9, 9};
//        int[] digits = {9,9,8};
//        int[] digits = {8,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
