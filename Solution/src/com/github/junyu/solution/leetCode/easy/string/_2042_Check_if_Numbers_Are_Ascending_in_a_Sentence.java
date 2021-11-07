package com.github.junyu.solution.leetCode.easy.string;

public class _2042_Check_if_Numbers_Are_Ascending_in_a_Sentence {

    /*
    A sentence is a list of tokens separated by a single space with no leading
    or trailing spaces. Every token is either a positive number consisting of
    digits 0-9 with no leading zeros, or a word consisting of lowercase English
    letters.

    For example, "a puppy has 2 eyes 4 legs" is a sentence with seven
    tokens: "2" and "4" are numbers and the other tokens such as "puppy"
    are words.
    Given a string s representing a sentence, you need to check if all the
    numbers in s are strictly increasing from left to right (i.e., other than
     the last number, each number is strictly smaller than the number on its
     right in s).

    Return true if so, or false otherwise.



    Example 1:

    Input: s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
    Output: true
    Explanation: The numbers in s are: 1, 3, 4, 6, 12.
    They are strictly increasing from left to right: 1 < 3 < 4 < 6 < 12.


    Example 2:

    Input: s = "hello world 5 x 5"
    Output: false
    Explanation: The numbers in s are: 5, 5. They are not strictly increasing.


    Example 3:

    Input: s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
    Output: false
    Explanation: The numbers in s are: 7, 51, 50, 60. They are not strictly increasing.

    Example 4:

    Input: s = "4 5 11 26"
    Output: true
    Explanation: The numbers in s are: 4, 5, 11, 26.
    They are strictly increasing from left to right: 4 < 5 < 11 < 26.


    Constraints:

    3 <= s.length <= 200
    s consists of lowercase English letters, spaces, and digits from 0 to 9, inclusive.
    The number of tokens in s is between 2 and 100, inclusive.
    The tokens in s are separated by a single space.
    There are at least two numbers in s.
    Each number in s is a positive number less than 100, with no leading zeros.
    s contains no leading or trailing spaces.
*/

    /**
     * 检查句子中的数字是否递增
     * 将字符串通过空格分割，然后遍历每个子串。获取子串的首位字符并判断是否和数字，
     * 如果为数字则说明是数字token，那么就需要判断是否与之前的数字是递增关系。只要不是递增
     * 关系就说明句子条件不成立。是递增关系则更新number值用于比较。
     *
     *
     * Runtime: 1 ms, faster than 94.37% of Java online submissions for Check if Numbers Are Ascending in a Sentence.
     * Memory Usage: 37.5 MB, less than 80.62% of Java online submissions for Check if Numbers Are Ascending in a Sentence.
     *
     * @param s
     * @return
     */
    public boolean areNumbersAscending(String s) {
        String [] arr = s.split(" ");
        int number = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (Character.isDigit(arr[i].charAt(0))){
                Integer cur = Integer.parseInt(arr[i]);
                if (cur<=number)
                    return false;
                else
                    number = cur;
            }
        }
        return true;
    }

    public static void main(String [] args) {
        _2042_Check_if_Numbers_Are_Ascending_in_a_Sentence test = new _2042_Check_if_Numbers_Are_Ascending_in_a_Sentence();
//        System.out.println(test.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(test.areNumbersAscending("hello world 5 x 5"));
        System.out.println(test.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println(test.areNumbersAscending("4 5 11 26"));
    }
}
