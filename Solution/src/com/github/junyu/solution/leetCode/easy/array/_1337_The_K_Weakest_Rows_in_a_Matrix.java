package com.github.junyu.solution.leetCode.easy.array;

import java.util.*;

public class _1337_The_K_Weakest_Rows_in_a_Matrix {

    /*Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians),
        return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

    A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j,
    or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row,
    that is, always ones may appear first and then zeros.

    Example 1:

    Input: mat =
            [[1,1,0,0,0],
            [1,1,1,1,0],
            [1,0,0,0,0],
            [1,1,0,0,0],
            [1,1,1,1,1]],
    k = 3
    Output: [2,0,3]
    Explanation:
    The number of soldiers for each row is:
    row 0 -> 2
    row 1 -> 4
    row 2 -> 1
    row 3 -> 2
    row 4 -> 5
    Rows ordered from the weakest to the strongest are [2,0,3,1,4]
    Example 2:

    Input: mat =
            [[1,0,0,0],
            [1,1,1,1],
            [1,0,0,0],
            [1,0,0,0]],
    k = 2
    Output: [0,2]
    Explanation:
    The number of soldiers for each row is:
    row 0 -> 1
    row 1 -> 4
    row 2 -> 1
    row 3 -> 1
    Rows ordered from the weakest to the strongest are [0,2,3,1]

    Constraints:

    m == mat.length
    n == mat[i].length
    2 <= n, m <= 100
            1 <= k <= m
    matrix[i][j] is either 0 or 1.*/

    class Pair {
        int index;
        int count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    /**
     * 思路：使用优先队列，先统计每行1的数量，队列插入时，先按1的数量进行排序，如果数量相等，那么就按所在矩阵的索引进行排序。
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.count == b.count) {
                    return a.index - b.index;
                }
                return a.count - b.count;
            }
        });
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                count++;
            }
            pq.offer(new Pair(i, count));
        }


        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().index;
        }

        return ans;
    }

//    /**
//     * 方阵中战斗力最弱的 K 行
//     * 思路：使用treeMap去统计相应数量对应的索引值，由于treeMap是按key进行升序排序，因此前k个对应的索引就是最弱的方阵。
//     * @param mat
//     * @param k
//     * @return
//     */
//    public int[] kWeakestRows(int[][] mat, int k) {
//        int[] ans = new int[k];
//        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//        for (int i = 0; i < mat.length; i++) {
//            int count = 0;
//            for (int j = 0; j < mat[i].length; j++) {
//                if (mat[i][j] == 0) {
//                    break;
//                }
//                count++;
//            }
//            if (map.get(count) == null) {
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(count, list);
//            } else {
//                map.get(count).add(i);
//            }
//        }
//
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            if (k > 0) {
//                List<Integer> list = entry.getValue();
//                for (Integer i : list) {
//                    ans[ans.length - k] = i;
//                    k--;
//                    if (k == 0)
//                        return ans;
//                }
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        _1337_The_K_Weakest_Rows_in_a_Matrix test = new _1337_The_K_Weakest_Rows_in_a_Matrix();
        System.out.println(Arrays.toString(test.kWeakestRows(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0,
                0, 0}, {1, 1, 0,
                0, 0}, {1, 1, 1, 1, 1}}, 3)));

        System.out.println(Arrays.toString(test.kWeakestRows(new int[][]{{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}}, 2)));

        System.out.println(Arrays.toString(test.kWeakestRows(new int[][]{{1, 0}, {1, 0}, {1, 0}, {1, 1}}, 4)));
    }
}
