package com.github.junyu.solution.leetCode.easy.sort;

public class _2231_Largest_Number_After_Digit_Swaps_by_Parity {

    /*
    You are given a positive integer num. You may swap any two digits of num that
    have the same parity (i.e. both odd digits or both even digits).

    Return the largest possible value of num after any number of swaps.



    Example 1:

    Input: num = 1234
    Output: 3412
    Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
    Swap the digit 2 with the digit 4, this results in the number 3412.
    Note that there may be other sequences of swaps but it can be shown that 3412 is the
    largest possible number.

    Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.

    Example 2:

    Input: num = 65875
    Output: 87655
    Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
    Swap the first digit 5 with the digit 7, this results in the number 87655.
    Note that there may be other sequences of swaps but it can be shown that 87655
    is the largest possible number.


            Constraints:

            1 <= num <= 109
*/

    /**
     *
     * 按奇偶性交换后的最大数字
     *
     * Runtime: 2 ms, faster than 79.11% of Java online submissions for Largest Number After Digit Swaps by Parity.
     * Memory Usage: 41.1 MB, less than 58.73% of Java online submissions for Largest Number After Digit Swaps by Parity.
     *
     * 先将num拆分存进数组中，然后通过交换排序的方法，找到同是奇数或者同是偶数的元素，如果前者小于后者就交换位置。
     * 最后就是将排序好的元素放到StringBuilder中，使用parseInt转为数字。
     *
     * @param num
     * @return
     */
    public int largestInteger(int num) {
        String numStr = String.valueOf(num);
        int[] arr = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            arr[i] = numStr.charAt(i) - '0';
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) % 2 == 0 && arr[j] > arr[i]) {
                    swap(arr,i,j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr){
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        _2231_Largest_Number_After_Digit_Swaps_by_Parity test = new _2231_Largest_Number_After_Digit_Swaps_by_Parity();
        System.out.println(test.largestInteger(1234));
        System.out.println(test.largestInteger(65875));
    }
}
