package com.github.junyu.solution.leetCode.medium.math;

public class _264_Ugly_Number_II {

 /*   Write a program to find the n-th ugly number.

    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

    Example:

    Input: n = 10
    Output: 12
    Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
    Note:

            1 is typically treated as an ugly number.
    n does not exceed 1690.*/

//    /**
//     * 找出第n个丑数
//     * 通过从1开始，逐个数字去判断一个数是否是丑数，是的话count++，直到count=n的时候，就获取到第n个丑数，这种方式提交会 Time Limit Exceeded，
//     * 所有需要换一种方式来解决这个问题。
//     * @param n
//     * @return
//     */
//    public int nthUglyNumber(int n) {
//        int count = 0;
//
//        int res = 1;
//
//        while (true) {
//
//            if (isUgly(res)) {
//                count++;
//            }
//
//            if (count == n)
//                break;
//
//            res++;
//        }
//
//        return res;
//    }
//
//    private boolean isUgly(int num) {
//        if (num <= 0)
//            return false;
//        while (num % 2 == 0)
//            num = num >> 1;
//
//        while (num % 3 == 0)
//            num = num / 3;
//
//        while (num % 5 == 0)
//            num = num / 5;
//
//        return num == 1;
//    }


    /**
     * 用空间换时间
     * 一个丑数无非就是通过另一个丑数*2或者*3后者*5得到的，那么我们就可以定义一个长度为n的数组，里面去存放所有的丑数。
     * 数组中最后一个丑数即使第n个丑数。
     * 为了保证丑数插入到数组中是有序的，还需要定义3个指针，p2,p3,p5,开始时他们分别指向第0个元素，每次在数组中增加一个丑数后，需要维护这三个指针，
     * 如果某一个指针所指的元素*它对应的倍数（p2为2，p3为3，p5为5）小于等于刚插入的丑数，那么就需要他指向下一个元素，直到他所指的元素大于新增的丑数。
     * 得到一个丑数是通过比较三个指针所指的元素的倍数的最小值，让数组有序，才能得到第n个丑数。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {

        if (n <= 0)
            return 0;

        int nums [] = new int[n];
        nums[0] = 1;
        int next = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while (next<n){
            int uglyNum = min(nums[p2]*2,nums[p3]*3,nums[p5]*5);
            nums[next] = uglyNum;

            while (nums[p2]*2<=uglyNum)
                p2++;

            while (nums[p3]*3<=uglyNum)
                p3++;

            while (nums[p5]*5<=uglyNum)
                p5++;

            next++;
        }

        return nums[next-1];

    }

    private int min(int num1, int num2, int num3) {
        int min = Math.min(num1,num2);
        return Math.min(min,num3);
    }


    public static void main(String[] args) {
        System.out.println(new _264_Ugly_Number_II().nthUglyNumber(1));
        System.out.println(new _264_Ugly_Number_II().nthUglyNumber(2));
        System.out.println(new _264_Ugly_Number_II().nthUglyNumber(10));
        System.out.println(new _264_Ugly_Number_II().nthUglyNumber(1352));
    }
}
