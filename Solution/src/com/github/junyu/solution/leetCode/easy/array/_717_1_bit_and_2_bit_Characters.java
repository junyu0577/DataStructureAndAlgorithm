package com.github.junyu.solution.leetCode.easy.array;

public class _717_1_bit_and_2_bit_Characters {

/*    We have two special characters. The first character can be represented by
    one bit 0. The second character can be represented by two bits (10 or 11).

    Now given a string represented by several bits. Return whether the last
    character must be a one-bit character or not. The given string will always end with a zero.

            Example 1:
    Input:
    bits = [1, 0, 0]
    Output: True
    Explanation:
    The only way to decode it is two-bit character and one-bit character.
    So the last character is one-bit character.
    Example 2:
    Input:
    bits = [1, 1, 1, 0]
    Output: False
    Explanation:
    The only way to decode it is two-bit character and two-bit character.
    So the last character is NOT one-bit character.
    Note:

            1 <= len(bits) <= 1000.
    bits[i] is always 0 or 1.*/


    /**
     * 判断最后一个字符是否是一个一比特字符,组合方式三种0，10，11，最后已0结尾
     * 从头开始遍历数组，遇到1时，因为组合只有11或者10这两种情况，所以下一个元素可以直接忽略，所以p+2;
     * 遇到0时，判断下如果是最后一个元素，那么必定是一比特字符。如果最后的组合是10，p+2以后就直接结束while循环了。
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        int p = 0;
        while (p < bits.length) {
            if (bits[p] == 0) {
                if (p == bits.length - 1)
                    return true;
                p++;
            } else {
                p += 2;
            }
        }

        return false;
    }

    public static void main(String [] args) {
        System.out.println(new _717_1_bit_and_2_bit_Characters().isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(new _717_1_bit_and_2_bit_Characters().isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

}
