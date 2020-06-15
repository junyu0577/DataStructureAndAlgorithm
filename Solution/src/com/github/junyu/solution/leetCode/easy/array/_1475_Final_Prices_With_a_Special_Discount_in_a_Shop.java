package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1475_Final_Prices_With_a_Special_Discount_in_a_Shop {

    /*Given the array prices where prices[i] is the price of the ith item in a
    shop. There is a special discount for items in the shop, if you buy the
    ith item, then you will receive a discount equivalent to prices[j] where
    j is the minimum index such that j > i and prices[j] <= prices[i]
            , otherwise, you will not receive any discount at all.

    Return an array where the ith element is the final price you will
    pay for the ith item of the shop considering the special discount.

    Example 1:

    Input: prices = [8,4,6,2,3]
    Output: [4,2,4,2,3]
    Explanation:
    For item 0 with price[0]=8 you will receive a discount equivalent to
    prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
    For item 1 with price[1]=4 you will receive a discount equivalent to
    prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
    For item 2 with price[2]=6 you will receive a discount equivalent to
    prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
    For items 3 and 4 you will not receive any discount at all.
    Example 2:

    Input: prices = [1,2,3,4,5]
    Output: [1,2,3,4,5]
    Explanation: In this case, for all items, you will not receive any discount at all.
            Example 3:

    Input: prices = [10,1,1,6]
    Output: [9,0,1,6]


    Constraints:

            1 <= prices.length <= 500
            1 <= prices[i] <= 10^3*/

    /**
     * 商品折扣后的价格
     * 思路：当遍历到一个商品时，循环它后面商品的价格，只有有一件商品的价格小于等于当前，就将
     * 当前商品价格减去折扣价格并重新赋值，只打折一次，注意跳出循环。
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        _1475_Final_Prices_With_a_Special_Discount_in_a_Shop test = new _1475_Final_Prices_With_a_Special_Discount_in_a_Shop();
        System.out.println(Arrays.toString(test.finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(test.finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(test.finalPrices(new int[]{10, 1, 1, 6})));
    }
}
