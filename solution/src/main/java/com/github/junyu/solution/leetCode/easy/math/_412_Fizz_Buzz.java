package com.github.junyu.solution.leetCode.easy.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaoJunyu
 * @since 2018/7/31 13:36
 */
public class _412_Fizz_Buzz {


    /*Write a program that outputs the string representation of numbers from 1 to n.

    But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
    For numbers which are multiples of both three and five output “FizzBuzz”.

    Example:

    n = 15,

    Return:
            [
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz"
            ]*/

    /**
     * 同时能被3和5整除用FizzBuzz替换，只能被3整除用Fizz替换，
     * 只能被5整除用Buzz替换。
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (i%3==0 && i%5==0)
                res.add("FizzBuzz");
            else if (i%3==0)
                res.add("Fizz");
            else if (i%5==0)
                res.add("Buzz");
            else
                res.add(String.valueOf(i));
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(fizzBuzz(20));
    }
}
