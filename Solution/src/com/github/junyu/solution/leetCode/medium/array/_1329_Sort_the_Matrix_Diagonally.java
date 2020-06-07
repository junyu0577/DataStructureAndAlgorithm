package com.github.junyu.solution.leetCode.medium.array;

import java.util.*;

public class _1329_Sort_the_Matrix_Diagonally {


   /* Given a m * n matrix mat of integers, sort it diagonally in ascending
    order from the top-left to the bottom-right then return the sorted array.

    Example 1:

    Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
    Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]


    Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
            1 <= mat[i][j] <= 100*/

    /**
     * 将对角线的元素按升序排序
     * 思路：将对角线的元素存在优先队列中，默认队列为升序排序。
     * 一个队列对应一条对角线。
     * 然后重新遍历矩阵，按顺序取出队列中的元素覆盖矩阵中的元素
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {
        int rowMax = mat.length;
        int columnMax = mat[0].length;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < columnMax; j++) {
                if (map.containsKey(i-j)){
                    map.get(i-j).offer(mat[i][j]);
                }else {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.offer(mat[i][j]);
                    map.put(i-j,pq);
                }
            }
        }

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < columnMax; j++) {
                mat[i][j] = map.get(i-j).poll();
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        _1329_Sort_the_Matrix_Diagonally test = new _1329_Sort_the_Matrix_Diagonally();
//        int[][] res = test.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}});
        int[][] res = test.diagonalSort(new int[][]{{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}});
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
