package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _1441_Build_an_Array_With_Stack_Operations {

    /*Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

    Build the target array using the following operations:

    Push: Read a new element from the beginning list, and push it in the array.
    Pop: delete the last element of the array.
    If the target array is already built, stop reading more elements.
    You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

    Return the operations to build the target array.

    You are guaranteed that the answer is unique.



    Example 1:

    Input: target = [1,3], n = 3
    Output: ["Push","Push","Pop","Push"]
    Explanation:
    Read number 1 and automatically push in the array -> [1]
    Read number 2 and automatically push in the array then Pop it -> [1]
    Read number 3 and automatically push in the array -> [1,3]
    Example 2:

    Input: target = [1,2,3], n = 3
    Output: ["Push","Push","Push"]
    Example 3:

    Input: target = [1,2], n = 4
    Output: ["Push","Push"]
    Explanation: You only need to read the first 2 numbers and stop.
            Example 4:

    Input: target = [2,3,4], n = 4
    Output: ["Push","Pop","Push","Push","Push"]

    Constraints:

    1 <= target.length <= 100
    1 <= target[i] <= 100
    1 <= n <= 100
    */

    /**
     * 根据给定的target数组的元素记录栈的操作过程
     * 思路：由于插入的元素是从1-n的增序方式插入，那么就意味着如果即将要插入的数（count）不存在于当前target数组，我们就需要将其push进去后再pop掉，
     * 更极端点的情况是（count）需要递增n次才和当前target的元素匹配，那么就需要不断的push和pop，直到count和当前元素相等。
     * 再继续去比较target的下一个元素.
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
            int count = 1;
            List<String> ans = new ArrayList<>();
            for (int num : target){
                ans.add("Push");
                while (count!=num){
                    ans.add("Pop");
                    ans.add("Push");
                    count++;
                }
                count++;
            }
            return ans;
    }

    public static void main(String[] args) {
        _1441_Build_an_Array_With_Stack_Operations test = new _1441_Build_an_Array_With_Stack_Operations();
        System.out.println(test.buildArray(new int[]{1,3},3));
        System.out.println(test.buildArray(new int[]{1,2,3},3));
        System.out.println(test.buildArray(new int[]{1,2},4));
        System.out.println(test.buildArray(new int[]{2,3,4},4));
    }
}
