package com.github.junyu.solution.leetCode.easy.hashTable;


import java.util.*;

public class _599_Minimum_Index_Sum_of_Two_Lists {


    /*Suppose Andy and Doris want to choose a restaurant for dinner,
    and they both have a list of favorite restaurants represented by strings.

    You need to help them find out their common interest with the least
    list index sum. If there is a choice tie between answers, output all
    of them with no order requirement. You could assume there always exists an answer.

    Example 1:

    Input:
            ["Shogun", "Tapioca Express", "Burger King", "KFC"]
            ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
    Output: ["Shogun"]
    Explanation: The only restaurant they both like is "Shogun".
    Example 2:

    Input:
            ["Shogun", "Tapioca Express", "Burger King", "KFC"]
            ["KFC", "Shogun", "Burger King"]
    Output: ["Shogun"]
    Explanation: The restaurant they both like and have the least index sum is "Shogun"
    with index sum 1 (0+1).
    Note:

    The length of both lists will be in the range of [1, 1000].
    The length of strings in both lists will be in the range of [1, 30].
    The index is starting from 0 to the list length minus 1.
    No duplicates in both lists.
*/

    /**
     * 找出两个列表公有且索引相加后值最小的元素
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hash.put(list1[i], i);
        }
        List<String> values = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer index = hash.get(list2[i]);
            if (index != null) {
                if (index + i < max) {
                    max = index+i;
                    values.clear();
                    values.add(list2[i]);
                } else if (index + i == max) {
                    values.add(list2[i]);
                }
            }
        }
        return (String[]) values.toArray(new String[values.size()]);
    }

    public static void main(String[] args) {
        _599_Minimum_Index_Sum_of_Two_Lists minimum_index_sum_of_two_lists = new _599_Minimum_Index_Sum_of_Two_Lists();
        System.out.println(Arrays.toString(minimum_index_sum_of_two_lists.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(minimum_index_sum_of_two_lists.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));

        System.out.println(Arrays.toString(minimum_index_sum_of_two_lists.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"})));
    }
}
