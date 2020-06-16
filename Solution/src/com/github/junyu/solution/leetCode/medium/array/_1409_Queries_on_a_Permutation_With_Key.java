package com.github.junyu.solution.leetCode.medium.array;

import java.util.*;

public class _1409_Queries_on_a_Permutation_With_Key {

    /*Given the array queries of positive integers between 1 and m,
    you have to process all queries[i] (from i=0 to i=queries.length-1)
    according to the following rules:

    In the beginning, you have the permutation P=[1,2,3,...,m].
    For the current i, find the position of queries[i] in the permutation
    P (indexing from 0) and then move this at the beginning of the permutation P.
    Notice that the position of queries[i] in P is the result for queries[i].
    Return an array containing the result for the given queries.

    Example 1:

    Input: queries = [3,1,2,1], m = 5
    Output: [2,1,2,1]
    Explanation: The queries are processed as follow:
    For i=0: queries[i]=3, P=[1,2,3,4,5], position of 3 in P is 2,
    then we move 3 to the beginning of P resulting in P=[3,1,2,4,5].
    For i=1: queries[i]=1, P=[3,1,2,4,5], position of 1 in P is 1,
    then we move 1 to the beginning of P resulting in P=[1,3,2,4,5].
    For i=2: queries[i]=2, P=[1,3,2,4,5], position of 2 in P is 2,
    then we move 2 to the beginning of P resulting in P=[2,1,3,4,5].
    For i=3: queries[i]=1, P=[2,1,3,4,5], position of 1 in P is 1,
    then we move 1 to the beginning of P resulting in P=[1,2,3,4,5].
    Therefore, the array containing the result is [2,1,2,1].
    Example 2:

    Input: queries = [4,1,2,2], m = 4
    Output: [3,1,2,0]
    Example 3:

    Input: queries = [7,5,5,8,3], m = 8
    Output: [6,5,0,7,5]


    Constraints:

            1 <= m <= 10^3
            1 <= queries.length <= m
    1 <= queries[i] <= m*/


    /**
     * 查询带键的排列
     * 思路：模拟流程，建立排列，每次从queries中获取key查询P中的位置（这个查询到的位置需要覆盖
     * 当前queries元素的值）并将元素本身移到头部，移动操作通过
     * 先删除后插入头部的方式。
     * @param queries
     * @param m
     * @return
     */
    public int[] processQueries(int[] queries, int m) {
        List<Integer> P = new ArrayList<>();
        for (int i=1;i<=m;i++){
            P.add(i);
        }

        for (int i=0;i<queries.length;i++){
            for (int j=0;j<P.size();j++){
                int cur = queries[i];
                if (P.get(j)==cur){
                    queries[i] = j;
                    P.remove(j);
                    P.add(0,cur);
                    break;
                }
            }
        }
        return queries;
    }

    public static void main(String[] args) {
        _1409_Queries_on_a_Permutation_With_Key test = new _1409_Queries_on_a_Permutation_With_Key();
        System.out.println(Arrays.toString(test.processQueries(new int[]{3, 1, 2, 1}, 5)));
        System.out.println(Arrays.toString(test.processQueries(new int[]{4, 1, 2, 2}, 4)));
        System.out.println(Arrays.toString(test.processQueries(new int[]{7, 5, 5, 8, 3}, 8)));
    }
}
