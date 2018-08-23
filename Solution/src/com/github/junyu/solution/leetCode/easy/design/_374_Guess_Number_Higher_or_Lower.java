package com.github.junyu.solution.leetCode.easy.design;

public class _374_Guess_Number_Higher_or_Lower {


    /*We are playing the Guess Game. The game is as follows:

    I pick a number from 1 to n. You have to guess which number I picked.

    Every time you guess wrong, I'll tell you whether the number is higher or lower.

    You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

            -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
    Example:
    n = 10, I pick 6.

    Return 6.*/

    public int guess(int num) {
        if (num == 6)
            return 0;
        else if (num < 6)
            return 1;
        else
            return -1;
    }

    /**
     * 猜数字，通过调用leetCode提供的方法，获取你当前猜的数字是对的，还是高了或者低了，分别对应返回0，1，-1
     * 可能考察用递归实现二分查找吧。
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        return guessNumber(1, n);
    }

    public int guessNumber(int left, int right) {
        int mid = (right - left) / 2 + left;
        int res = guess(mid);
        if (res == 0)
            return mid;
        else if (res == 1) {
            return guessNumber(mid + 1, right);
        } else {
            return guessNumber(1, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _374_Guess_Number_Higher_or_Lower().guessNumber(10));
    }
}
