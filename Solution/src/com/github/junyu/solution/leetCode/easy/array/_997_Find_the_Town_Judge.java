package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _997_Find_the_Town_Judge {

    /*In a town, there are N people labelled from 1 to N.
    There is a rumor that one of these people is secretly the town judge.

    If the town judge exists, then:

    The town judge trusts nobody.
            Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.
    You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

    Example 1:

    Input: N = 2, trust = [[1,2]]
    Output: 2
    Example 2:

    Input: N = 3, trust = [[1,3],[2,3]]
    Output: 3
    Example 3:

    Input: N = 3, trust = [[1,3],[2,3],[3,1]]
    Output: -1
    Example 4:

    Input: N = 3, trust = [[1,2],[2,3]]
    Output: -1
    Example 5:

    Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    Output: 3


    Constraints:

            1 <= N <= 1000
            0 <= trust.length <= 10^4
    trust[i].length == 2
    trust[i] are all different
    trust[i][0] != trust[i][1]
            1 <= trust[i][0], trust[i][1] <= N*/

    /**
     * 找到小镇的法官
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> judge = new HashSet<>();
        for (int i=0;i<trust.length;i++){
            judge.add(trust[i][1]);
            map.put(trust[i][0],trust[i][1]);
        }
        for (int i :judge){
            if (!map.containsKey(i))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        _997_Find_the_Town_Judge test = new _997_Find_the_Town_Judge();
//        System.out.println(test.findJudge(2,new int[][]{{1,2}}));
//        System.out.println(test.findJudge(3,new int[][]{{1,3},{2,3}}));
//        System.out.println(test.findJudge(3,new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(test.findJudge(3,new int[][]{{1,2},{2,3}}));
//        System.out.println(test.findJudge(4,new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}
