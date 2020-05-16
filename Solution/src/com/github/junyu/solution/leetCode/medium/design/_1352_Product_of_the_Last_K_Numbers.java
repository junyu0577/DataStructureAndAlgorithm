package com.github.junyu.solution.leetCode.medium.design;

import java.util.ArrayList;
import java.util.List;

public class _1352_Product_of_the_Last_K_Numbers {

    /*Implement the class ProductOfNumbers that supports two methods:

            1. add(int num)

    Adds the number num to the back of the current list of numbers.
    2. getProduct(int k)

    Returns the product of the last k numbers in the current list.
    You can assume that always the current list has at least k numbers.
    At any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without
    overflowing.



    Example:

    Input
    ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
            [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

        Output
    [null,null,null,null,null,null,20,40,0,null,32]

        Explanation
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
    productOfNumbers.add(3);        // [3]
    productOfNumbers.add(0);        // [3,0]
    productOfNumbers.add(2);        // [3,0,2]
    productOfNumbers.add(5);        // [3,0,2,5]
    productOfNumbers.add(4);        // [3,0,2,5,4]
    productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
    productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
    productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
    productOfNumbers.add(8);        // [3,0,2,5,4,8]
    productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32


    Constraints:

    There will be at most 40000 operations considering both add and getProduct.
            0 <= num <= 100
            1 <= k <= 40000*/

    /**
     * 求数组最后K个数的乘积
     * 思路：每次add新元素的时候，都计算当前的最大乘积，这样可以保证，每次add的时候，都是将上一次的乘积结果
     * 与当前元素相乘，获取到当前的最大乘积。同时获取最后k个数的乘积时，如最后一个数就是其本身，最后两个数的乘积为倒数第一个元素除
     * 倒数第二个元素，最后K个数也就是倒数第一个元素除以list.size-1-k的元素值。
     * 以上没有考虑0的情况，由于会有0的情况，就会导致除0的操作。因此需要去记一下最后0的位置，当0出现后，之前的元素的乘积都为0.而0
     * 后面的第一个元素如果非0则为其本身，再后续非0的元素开始累乘操作。
     * 所以如果k取值到0的索引位时可直接返回0.
     */
    static class ProductOfNumbers {

        private List<Integer> list;
        private int sum = 1;
        private int zeroIndex = -1;

        public ProductOfNumbers() {
            list = new ArrayList<>();
        }

        public void add(int num) {
            if (num == 0) {
                zeroIndex = list.size();
                sum = 1;
                list.add(0);
            } else {
                sum *= num;
                list.add(sum);
            }
        }

        public int getProduct(int k) {
            if (list.size() - k <= zeroIndex)
                return 0;

            if (list.size() == k)
                return sum;


            int pre = list.get(list.size() - 1 - k);//a ab abc
            if (pre == 0)
                return sum;

            return sum / pre;
        }
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);

//        productOfNumbers.add(3);
//        productOfNumbers.add(2);
//        productOfNumbers.add(1);

        System.out.println(productOfNumbers.getProduct(1));
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
    }
}
