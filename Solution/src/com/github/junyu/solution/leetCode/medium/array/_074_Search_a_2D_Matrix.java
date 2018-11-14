package com.github.junyu.solution.leetCode.medium.array;

public class _074_Search_a_2D_Matrix {

    /*Write an efficient algorithm that searches for a value in an m x n matrix.
    This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    Example 1:

    Input:
    matrix = [
            [1,   3,  5,  7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
            ]
    target = 3
    Output: true
    Example 2:

    Input:
    matrix = [
            [1,   3,  5,  7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
            ]
    target = 13
    Output: false*/

    /**
     * 在二维数组中寻找target，存在返回true
     * 利用二分查找在二维数组中进行查找。起始left为0，right为（行数×列数-1）
     * 每次获取mid后，进行元素位置的获取，mid/列数就是当前元素所在的行，mid%列数就是当前元素所在的列。
     * 然后就元素与target进行比较，小于target就将范围改为[mid+1,right],大于target就改范围为[left,mid-1]
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int cols = matrix[0].length;
        int rows = matrix.length;

        int left = 0;
        int right = (rows * cols) - 1;


        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (matrix[mid / cols][mid % cols] == target)
                return true;
            else if (matrix[mid / cols][mid % cols] < target)
                left = mid + 1;
            else
                right = mid - 1;

        }

        return false;
    }

    public static void main(String[] args) {
        _074_Search_a_2D_Matrix search_a_2D_matrix = new _074_Search_a_2D_Matrix();
        System.out.println(search_a_2D_matrix.searchMatrix(new int[][]{}, 3));
        System.out.println(search_a_2D_matrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
        System.out.println(search_a_2D_matrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13));
    }

}
