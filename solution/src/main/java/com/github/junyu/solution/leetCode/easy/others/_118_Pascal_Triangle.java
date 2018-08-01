package com.github.junyu.solution.leetCode.easy.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/8/1 19:42
 */
public class _118_Pascal_Triangle {

   /* Pascal's Triangle
    Go to Discuss
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

    Example:

    Input: 5
    Output:
            [
            [1],
            [1,1],
            [1,2,1],
            [1,3,3,1],
            [1,4,6,4,1]
            ]
*/

    /**
     * 定义row集合存放一行的数据，从第三行开始就需要对rows始终的元素进行更新
     * 这个更新操作也是由行数决定的。第一、二不会进行更新，从第三行开始以1为起始
     * 进行递增(第三行更新一个数，第四行更新两个数)，更新j位置的值为j+(j+1)
     * 每到新的一行必须要往rows的第一个位置插入1
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {//控制行数
            rows.add(0, 1);//头部位置插入1
            for (int j = 1; j < rows.size() - 1; j++) {//控制rows数组元素更新的次数
                rows.set(j, rows.get(j) + rows.get(j + 1));
            }
            res.add(new ArrayList<>(rows));
        }

        return res;
    }

    public static void main(String[] args) {
        _118_Pascal_Triangle pascal_triangle = new _118_Pascal_Triangle();
        List<List<Integer>> list = pascal_triangle.generate(5);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

}
