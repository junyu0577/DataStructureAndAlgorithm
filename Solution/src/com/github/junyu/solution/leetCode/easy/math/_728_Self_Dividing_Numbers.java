package com.github.junyu.solution.leetCode.easy.math;

import java.util.ArrayList;
import java.util.List;

public class _728_Self_Dividing_Numbers {

   /* A self-dividing number is a number that is divisible by every digit it contains.

    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

    Also, a self-dividing number is not allowed to contain the digit zero.

    Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

            Example 1:
    Input:
    left = 1, right = 22
    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
    Note:

    The boundaries of each input argument are 1 <= left <= right <= 10000.*/

//    /**
//     * 列出left-right之间的自除数，自除数就是能被本身含有的所有的数整除
//     * 通过将数值转字符数组，然后让数字除以它身上的每一个数，如果除数为0或者无法本整除就表示不是自除数
//     * @param left
//     * @param right
//     * @return
//     */
//    public List<Integer> selfDividingNumbers(int left, int right) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = left; i <= right; i++) {
//            char cs[] = String.valueOf(i).toCharArray();
//            boolean flag = true;
//            for (int j = 0; j < cs.length; j++) {
//                if (cs[j] - '0' == 0 || i % (cs[j] - '0') != 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag)
//                res.add(i);
//        }
//
//        return res;
//    }

    /**
     * 列出left-right之间的自除数，自除数就是能被本身含有的所有的数整除
     * 通过对数字除10进行取模，获取他自身的每一个数，判断都能被这些数整除，都能
     * 整除就意味着是自除数。
     *
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int cur = i;
            boolean isSelfDividing = true;
            while (cur != 0) {
                int mod = cur % 10;
                if (mod == 0 || i % mod != 0) {
                    isSelfDividing = false;
                    break;
                }
                cur = cur/10;
            }
            if (isSelfDividing)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _728_Self_Dividing_Numbers().selfDividingNumbers(1, 22));
    }
}
