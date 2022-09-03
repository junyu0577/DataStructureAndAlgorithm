package com.github.junyu.solution.data_structure.utils;

public class ArrayMaker {

    public static void print2DArray(int [][] array,int row,int col){
        if (array.length==0){
            System.out.println("illegal array");
            return;
        }

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void print2DArray(int [][] array){
        if (array.length==0){
            System.out.println("illegal array");
            return;
        }

        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
