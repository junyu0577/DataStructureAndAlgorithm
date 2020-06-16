package com.github.junyu.solution.leetCode.medium.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1338_Reduce_Array_Size_to_The_Half {

/*    Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the
array.

    Return the minimum size of the set so that at least half of the integers of the array are removed.

    Example 1:

    Input: arr = [3,3,3,3,5,5,5,2,2,7]
    Output: 2
    Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size
    of the old array).
    Possible sets of size 2 are {3,5},{3,2},{5,2}.
    Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half
     of the size of the old array.
            Example 2:

    Input: arr = [7,7,7,7,7,7]
    Output: 1
    Explanation: The only possible set you can choose is {7}. This will make the new array empty.
    Example 3:

    Input: arr = [1,9]
    Output: 1
    Example 4:

    Input: arr = [1000,1000,3,7]
    Output: 1
    Example 5:

    Input: arr = [1,2,3,4,5,6,7,8,9,10]
    Output: 5


    Constraints:

            1 <= arr.length <= 10^5
    arr.length is even.
    1 <= arr[i] <= 10^5*/

    /**
     * 数组大小减半，返回 至少 能删除数组中的一半整数的整数集合的最小大小。
     * 思路：统计数量元素出现的数量，然后将数量按降序添加到优先队列，最后从队列中取出元素，累加后如果超过数组长度的一半就满足。
     * @param arr
     * @return
     */
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int half = arr.length/2;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }
        int sum = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            count++;
            sum += pq.poll();
            if (sum>=half){
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _1338_Reduce_Array_Size_to_The_Half test = new _1338_Reduce_Array_Size_to_The_Half();
        System.out.println(test.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(test.minSetSize(new int[]{7, 7, 7, 7, 7, 7}));
        System.out.println(test.minSetSize(new int[]{1, 9}));
        System.out.println(test.minSetSize(new int[]{1000, 1000, 3, 7}));
        System.out.println(test.minSetSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
