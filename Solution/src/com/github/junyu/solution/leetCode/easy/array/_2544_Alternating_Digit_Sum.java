package com.github.junyu.solution.leetCode.easy.array;

public class _2544_Alternating_Digit_Sum {


//    给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
//
//    最高有效位 上的数字分配到 正 号。
//    剩余每位上数字的符号都与其相邻数字相反。
//    返回所有数字及其对应符号的和。
//
//             
//
//    示例 1：
//
//    输入：n = 521
//    输出：4
//    解释：(+5) + (-2) + (+1) = 4
//    示例 2：
//
//    输入：n = 111
//    输出：1
//    解释：(+1) + (-1) + (+1) = 1
//    示例 3：
//
//    输入：n = 886996
//    输出：0
//    解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
//             
//
//    提示：
//
//            1 <= n <= 109


    /**
     * 交替数字和
     * 从高位开始遍历数字的各个位数，然后进行加与减的替换操作即可。
     * @param n
     * @return
     */
    public int alternateDigitSum(int n) {
        int ans = 0;
        String str = String.valueOf(n);
        boolean isAdd = true;
        for (char c : str.toCharArray()) {
            if (isAdd) {
                ans += c - '0';
            } else {
                ans -= c - '0';
            }
            isAdd  = !isAdd;
        }
        return ans;
    }


    public static void main(String[] args) {
        _2544_Alternating_Digit_Sum test = new _2544_Alternating_Digit_Sum();
        System.out.println(test.alternateDigitSum(521));
        System.out.println(test.alternateDigitSum(111));
        System.out.println(test.alternateDigitSum(886996));
    }
}
