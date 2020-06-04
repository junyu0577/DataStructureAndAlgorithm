package com.github.junyu.solution.leetCode.medium.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1282_Group_the_People_Given_the_Group_Size_They_Belong_To {

    /*There are n people whose IDs go from 0 to n - 1 and each person belongs
    exactly to one group. Given the array groupSizes of length n telling the
    group size each person belongs to, return the groups there are and
    the people's IDs each group includes.

    You can return any solution in any order and the same applies for IDs.
            Also, it is guaranteed that there exists at least one solution.

    Example 1:

    Input: groupSizes = [3,3,3,3,3,1,3]
    Output: [[5],[0,1,2],[3,4,6]]
    Explanation:
    Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
    Example 2:

    Input: groupSizes = [2,1,3,3,3,2]
    Output: [[1],[0,5],[2,3,4]]


    Constraints:

    groupSizes.length == n
    1 <= n <= 500
            1 <= groupSizes[i] <= n*/

    /**
     * 给用户分组，元素的值代表组员的数量
     * 思路：将组员的数量和当前组的人员存在map中，每遍历到一个元素，就先从map取出对应的组，往
     * 组里添加后判断是否已经满员，如果未满员则再次将list存回map中。
     * 如果已经满员，则将list添加到结果集合中，并删除当前map中的元素，以建立新的相同人数的分组。
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            List<Integer> list = map.get(size);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);

            if (list.size() == size) {
                ans.add(list);
                map.remove(size);
            } else {
                map.put(size,list);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        _1282_Group_the_People_Given_the_Group_Size_They_Belong_To test = new _1282_Group_the_People_Given_the_Group_Size_They_Belong_To();
        System.out.println(test.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(test.groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }

}
