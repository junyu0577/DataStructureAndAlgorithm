package com.github.junyu.solution.leetCode.medium.other;

import java.util.Arrays;

public class _881_Boats_to_Save_People {

    /*The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

    Each boat carries at most 2 people at the same time, provided the sum of the
    weight of those people is at most limit.

    Return the minimum number of boats to carry every given person.
        (It is guaranteed each person can be carried by a boat.)



    Example 1:

    Input: people = [1,2], limit = 3
    Output: 1
    Explanation: 1 boat (1, 2)
    Example 2:

    Input: people = [3,2,2,1], limit = 3
    Output: 3
    Explanation: 3 boats (1, 2), (2) and (3)
    Example 3:

    Input: people = [3,5,3,4], limit = 5
    Output: 4
    Explanation: 4 boats (3), (3), (4), (5)
    Note:

            1 <= people.length <= 50000
            1 <= people[i] <= limit <= 30000
*/

    /**
     * 求需要多少船将所有的人运送过去，每个船最多只能坐两人，并且重量不能超过limit
     * 对数组进行排序后，从后往前比较判断，如果当前指向头部和尾部的指针相加的值小于limit，那么
     * 他们就可以一组。否则就让end指向的元素单独一组，然后继续上述的判断。
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            res++;
            if (people[end] + people[start] <= limit) {
                start++;
            }
            end--;

        }

        return res;
    }

    public static void main(String[] args) {
        _881_Boats_to_Save_People boats_to_save_people = new _881_Boats_to_Save_People();
        System.out.println(boats_to_save_people.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(boats_to_save_people.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(boats_to_save_people.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println(boats_to_save_people.numRescueBoats(new int[]{21, 40, 16, 24, 30}, 50));
    }
}
