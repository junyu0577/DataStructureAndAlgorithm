package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1103_Distribute_Candies_to_People {

    /*We distribute some number of candies, to a row of n = num_people people in the following way:

    We then give 1 candy to the first person, 2 candies to the second person, and so on until
    we give n candies to the last person.

    Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the
    second person, and so on until we give 2 * n candies to the last person.

    This process repeats (with us giving one more candy each time, and moving to the start of the row after
            we reach the end) until we run out of candies.  The last person will receive all of our remaining
    candies (not necessarily one more than the previous gift).

    Return an array (of length num_people and sum candies) that represents the final distribution of candies.

    Example 1:

    Input: candies = 7, num_people = 4
    Output: [1,2,3,1]
    Explanation:
    On the first turn, ans[0] += 1, and the array is [1,0,0,0].
    On the second turn, ans[1] += 2, and the array is [1,2,0,0].
    On the third turn, ans[2] += 3, and the array is [1,2,3,0].
    On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
    Example 2:

    Input: candies = 10, num_people = 3
    Output: [5,2,3]
    Explanation:
    On the first turn, ans[0] += 1, and the array is [1,0,0].
    On the second turn, ans[1] += 2, and the array is [1,2,0].
    On the third turn, ans[2] += 3, and the array is [1,2,3].
    On the fourth turn, ans[0] += 4, and the final array is [5,2,3].


    Constraints:

            1 <= candies <= 10^9
            1 <= num_people <= 1000*/

    /**
     * 分发糖果，隔一个人额外增发一颗糖，在数组中循环发放，发完为止。
     * 思路：判断新增一颗糖后是否有超出剩余糖果的数量，如果超过则直接将剩余的糖果发给当前索引位的人。如果不超过，则发放+1后的数量，并且更新剩余
     * 的糖果数量。
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int index = 0;
        int candyCount = 0;
        while (candies > 0) {
            if (candyCount+1<=candies){
                ans[index++] += ++candyCount;
                candies-=candyCount;
            }else {
                ans[index++]+= candies;
                candies = 0;
            }
            index %= num_people;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1103_Distribute_Candies_to_People test = new _1103_Distribute_Candies_to_People();
        System.out.println(Arrays.toString(test.distributeCandies(7, 4)));
        System.out.println(Arrays.toString(test.distributeCandies(10, 3)));
    }
}
