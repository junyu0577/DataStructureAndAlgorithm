package com.github.junyu.solution.leetCode.easy.array;

public class _1529_Bulb_Switcher_IV {

    /*There is a room with n bulbs, numbered from 0 to n-1, arranged in a row from left to right. Initially all the
    bulbs are turned off.

    Your task is to obtain the configuration represented by target where target[i] is '1' if the i-th bulb is turned on
    and is '0' if it is turned off.

    You have a switch to flip the state of the bulb, a flip operation is defined as follows:

    Choose any bulb (index i) of your current configuration.
    Flip each bulb from index i to n-1.
    When any bulb is flipped it means that if it is 0 it changes to 1 and if it is 1 it changes to 0.

    Return the minimum number of flips required to form target.

    Example 1:

    Input: target = "10111"
    Output: 3
    Explanation: Initial configuration "00000".
    flip from the third bulb:  "00000" -> "00111"
    flip from the first bulb:  "00111" -> "11000"
    flip from the second bulb:  "11000" -> "10111"
    We need at least 3 flip operations to form target.

    Example 2:

    Input: target = "101"
    Output: 3
    Explanation: "000" -> "111" -> "100" -> "101".
    Example 3:

    Input: target = "00000"
    Output: 0
    Example 4:

    Input: target = "001011101"
    Output: 5


    Constraints:

            1 <= target.length <= 10^5
    target[i] == '0' or target[i] == '1'*/

    /**
     * 灯泡开关
     * 思路：这里将思路反转一下，我们可以通过求将target中的元素全部翻转为0所需的最小次数。
     * 先排除掉target前部为0的元素。然后两两比较其中的元素，只要有不同的元素就将次数+1。
     * 最后还需要补上第一个元素的翻转次数。
     * @param target
     * @return
     */
    public int minFlips(String target) {
        int ans = 0;
        int pos = -1;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '1') {
                break;
            }
            pos = i;
        }
        if (pos==target.length()-1)
            return ans;

        target = target.substring(pos + 1);
        for (int i = 0; i < target.length()-1; i++) {
          if (target.charAt(i)!=target.charAt(i+1))
              ans++;
        }
        return ans+1;
    }

    public static void main(String[] args) {
        _1529_Bulb_Switcher_IV test = new _1529_Bulb_Switcher_IV();
        System.out.println(test.minFlips("10111"));
        System.out.println(test.minFlips("101"));
        System.out.println(test.minFlips("00000"));
        System.out.println(test.minFlips("001011101"));
    }
}
