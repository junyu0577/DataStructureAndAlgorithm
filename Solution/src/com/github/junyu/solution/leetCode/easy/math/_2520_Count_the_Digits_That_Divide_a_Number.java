package com.github.junyu.solution.leetCode.easy.math;

public class _2520_Count_the_Digits_That_Divide_a_Number {


//    给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
//
//    如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
//
//             
//
//    示例 1：
//
//    输入：num = 7
//    输出：1
//    解释：7 被自己整除，因此答案是 1 。
//    示例 2：
//
//    输入：num = 121
//    输出：2
//    解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
//    示例 3：
//
//    输入：num = 1248
//    输出：4
//    解释：1248 可以被它每一位上的数字整除，因此答案是 4 。


    /**
     * 统计能整除数字的位数
     * 遍历num各个位子上的数并与num进行求模，如果结果为0，就累加ans，最后返回ans即可。
     *
     * @param num
     * @return
     */
    public int countDigits(int num) {
        int ans = 0;
        int temp = num;
        while (temp>0){
            if (num%(temp%10)==0)
                ans++;

            temp/=10;
        }
        return ans;
    }

    public static void main(String[] args) {
        _2520_Count_the_Digits_That_Divide_a_Number test = new _2520_Count_the_Digits_That_Divide_a_Number();
        System.out.println(test.countDigits(7));
        System.out.println(test.countDigits(121));
        System.out.println(test.countDigits(1248));
    }
}
