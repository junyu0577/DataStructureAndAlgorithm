package com.github.junyu.solution.leetCode.easy.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1237_Find_Positive_Integer_Solution_for_a_Given_Equation {

    /*Given a function  f(x, y) and a value z, return all positive integer pairs x and y where f(x,y) == z.

    The function is constantly increasing, i.e.:

    f(x, y) < f(x + 1, y)
    f(x, y) < f(x, y + 1)
    The function interface is defined like this:

    interface CustomFunction {
        public:
        // Returns positive integer f(x, y) for any given positive integer x and y.
        int f(int x, int y);
    };
    For custom testing purposes you
    're given an integer function_id and a target z as input, where function_id represent one function
    from an secret internal list, on the examples you'll know only two functions from the list.

    You may return the solutions in any order.

    Example 1:

    Input: function_id = 1, z = 5
    Output: [[1,4],[2,3],[3,2],[4,1]]
    Explanation: function_id = 1 means that f(x, y) = x + y
    Example 2:

    Input: function_id = 2, z = 5
    Output: [[1,5],[5,1]]
    Explanation: function_id = 2 means that f(x, y) = x * y


    Constraints:

            1 <= function_id <= 9
            1 <= z <= 100
    It's guaranteed that the solutions of f(x, y) == z will be on the range 1 <= x, y <= 1000
    It's also guaranteed that f(x, y) will fit in 32 bit signed integer if 1 <= x, y <= 1000*/

    static class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x + y;
        }
    }

    /**
     * 找出给定方程的正整数解
     * 思路：在给定的区间范围，判断函数的返回结果，如果结果大于z，就增加x，小于z就减少y，相等就将值保存到list中，并缩小范围。
     * @param customfunction
     * @param z
     * @return
     */
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<>();

        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int res = customfunction.f(x, y);
            if (res < z)
                x++;
            else if (res > z)
                y--;
            else{
                list.add(Arrays.asList(x, y));
                x++;
                y--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        _1237_Find_Positive_Integer_Solution_for_a_Given_Equation test = new _1237_Find_Positive_Integer_Solution_for_a_Given_Equation();
        System.out.println(test.findSolution(new CustomFunction(),5));
    }
}
