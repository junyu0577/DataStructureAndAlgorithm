package com.github.junyu.solution.leetCode.medium.hashTable;

import java.util.Arrays;
import java.util.Stack;

public class _739_Daily_Temperatures {

  /*  Given a list of daily temperatures, produce a list that, for each day in the input,
    tells you how many days you would have to wait until a warmer temperature. If there is
    no future day for which this is possible, put 0 instead.

    For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output
    should be [1, 1, 4, 2, 1, 1, 0, 0].

    Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be
    an integer in the range [30, 100].*/

//    /**
//     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
//     * 使用交换排序的思路，让当前的选择和后续的元素进行比较，如果后续有大于当前的，结果为他们的间隔，否则就是0
//     * 暴力解法 O(N^2)
//     * @param temperatures
//     * @return
//     */
//    public int[] dailyTemperatures(int[] temperatures) {
//        int res[] = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            for (int j = i + 1; j < temperatures.length; j++) {
//                if (temperatures[i] < temperatures[j]) {
//                    res[i] = j - i;
//                    break;
//                } else if (j == temperatures.length - 1) {
//                    res[i] = 0;
//                }
//            }
//        }
//        return res;
//    }

    /**
     * solution2
     * 使用栈保存数组中元素的索引，当栈顶的元素索引对应的值，小于当前遍历到的元素的值，那么说明当前的元素大于temp[s.peek]的值，
     * i-s.peek就是他们之间的间隔。每次pop完以后，如果栈不为空，还需要再查看栈顶的元素是否小于当前元素，因为只要在栈中的元素，都是
     * 还没有找到比他更大的元素。
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int index = s.pop();
                res[index] = i - index;
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _739_Daily_Temperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
