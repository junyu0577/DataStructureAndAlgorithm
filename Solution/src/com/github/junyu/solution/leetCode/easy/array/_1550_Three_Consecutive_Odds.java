package com.github.junyu.solution.leetCode.easy.array;

public class _1550_Three_Consecutive_Odds {

    /*Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.

    Example 1:

    Input: arr = [2,6,4,1]
    Output: false
    Explanation: There are no three consecutive odds.
    Example 2:

    Input: arr = [1,2,34,3,4,5,7,23,12]
    Output: true
    Explanation: [5,7,23] are three consecutive odds.


    Constraints:

            1 <= arr.length <= 1000
            1 <= arr[i] <= 1000
*/

    /**
     * 三个连续的奇数
     * 思路：遍历数组，定义count记录当前奇数的数量。如果当前的元素是奇数则count++，否则就将count置为0。当count值为3时，说明包含连续的奇数。
     * @param arr
     * @return
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num :arr){
            if ((num&1)==1){
                count++;
            }else {
                count = 0;
            }
            if (count==3){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _1550_Three_Consecutive_Odds test = new _1550_Three_Consecutive_Odds();
        System.out.println(test.threeConsecutiveOdds(new int[]{2,6,4,1}));
        System.out.println(test.threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }
}
