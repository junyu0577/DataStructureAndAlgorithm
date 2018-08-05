package com.github.junyu.solution.leetCode.easy.dp;

/**
 * @author ShaoJunyu
 * @since 2018/8/2 08:14
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {

   /* Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
    design an algorithm to find the maximum profit.

    Note that you cannot sell a stock before you buy one.

            Example 1:

    Input: [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Not 7-1 = 6, as selling price needs to be larger than buying price.
    Example 2:

    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.*/

    /**
     * 从仅计算两天的收益 一直推算到第n天的收益，
     * profit保存整个交易过程中最大的收益
     * curProfit保存的是截止到第i天的收益,如果到第i的时候收益为负，那么就认为到第i天的收益为0.
     * 整个计算每个的收益中需要不断维护profit这个变量，如果curProfit大于profit需要更新profit的值
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int profit = 0;
        int curProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            curProfit = Math.max(curProfit + prices[i] - prices[i - 1], 0);
            profit = curProfit > profit ? curProfit : profit;
        }

        return profit;

    }

    public static void main(String[] args) {
//        int arr[] = {7, 1, 5, 3, 6, 4};
//        int arr[] = {7,6,4,3,1};
//        int arr[] = {5, 10, 4, 6, 8};
        int arr[] = {1, 2};
        _121_Best_Time_to_Buy_and_Sell_Stock best_time_to_buy_and_sell_stock = new _121_Best_Time_to_Buy_and_Sell_Stock();
        System.out.println(best_time_to_buy_and_sell_stock.maxProfit(arr));
    }

}
