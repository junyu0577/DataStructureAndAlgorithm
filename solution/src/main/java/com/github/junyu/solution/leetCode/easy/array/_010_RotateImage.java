package com.github.junyu.solution.leetCode.easy.array;



/**
 * @author ShaoJunyu
 * @since 2018/6/21 17:00
 */
public class _010_RotateImage {

  /*
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Note:

    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    DO NOT allocate another 2D matrix and do the rotation.

    Example 1:

    Given input matrix =
            [
            [1,2,3],
            [4,5,6],
            [7,8,9]
            ],

    rotate the input matrix in-place such that it becomes:
            [
            [7,4,1],
            [8,5,2],
            [9,6,3]
            ]
    Example 2:

    Given input matrix =
            [
            [ 5, 1, 9,11],
            [ 2, 4, 8,10],
            [13, 3, 6, 7],
            [15,14,12,16]
            ],

    rotate the input matrix in-place such that it becomes:
            [
            [15,13, 2, 5],
            [14, 3, 4, 1],
            [12, 6, 8, 9],
            [16, 7,10,11]
            ]
    */


    public static void rotate(int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l / 2; i++) {
            for (int j = i; j < l - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[l - 1 - j][i];
                matrix[l - 1 - j][i] = matrix[l - 1 - i][l - 1 - j];
                matrix[l - 1 - i][l - 1 - j] = matrix[j][l - 1 - i];
                matrix[j][l - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
       for (int i=0;i<arr.length;i++){
           for (int j=0;j<arr.length;j++){
               System.out.print(arr[i][j]);
           }
           System.out.println();
       }
    }

    //    public static void rotate(int[][] matrix) {
//// [3,0] [0,0] - [ 2,0][0,1] -  [1,0][0,2] -[0,0] [0,3]
//        int x;
//        int size = matrix.length;
//        int [][] arr = new int[size][size];
//        for (int i =0;i<matrix.length;i++){
//            for (int j = 0;j<matrix.length;j++){
//                arr[i][j] = matrix[i][j];
//            }
//        }
//
//        for (int i = 0; i < size; i++) {
//            x = size-1;
//            for (int j = 0; j < size; j++) {
//                System.out.println(matrix[i][j]);
//                matrix[i][j] = arr[x][i];
//                x--;
//            }
//        }
//    }

}
