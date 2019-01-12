package com.github.junyu.solution.leetCode.medium.sort;

import java.util.ArrayList;
import java.util.List;

public class _969_Pancake_Sorting {

    /*Given an array A, we can perform a pancake flip:
    We choose some positive integer k <= A.length,
    then reverse the order of the first k elements of A.
    We want to perform zero or more pancake flips
            (doing them one after another in succession) to sort the array A.

    Return the k-values corresponding to a sequence of
    pancake flips that sort A.  Any valid answer that sorts
    the array within 10 * A.length flips will be judged as correct.



            Example 1:

    Input: [3,2,4,1]
    Output: [4,2,4,3]
    Explanation:
    We perform 4 pancake flips, with k values 4, 2, 4, and 3.
    Starting state: A = [3, 2, 4, 1]
    After 1st flip (k=4): A = [1, 4, 2, 3]
    After 2nd flip (k=2): A = [4, 1, 2, 3]
    After 3rd flip (k=4): A = [3, 2, 1, 4]
    After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
            Example 2:

    Input: [1,2,3]
    Output: []
    Explanation: The input is already sorted, so there is no need to flip anything.
    Note that other answers, such as [3, 3], would also be accepted.


    Note:

            1 <= A.length <= 100
    A[i] is a permutation of [1, 2, ..., A.length]*/


    /**
     * 煎饼排序
     * 排序的思路为每次从数组中找到最大的元素，然后翻转子数组(0和最大元素)，使得位于第一个位置。
     * 再翻转一次，让其位于最后的位置，这样保证了最大值被放置在末尾。
     * 然后在从未排好序的子数组中寻找最大值，重复上述的翻转操作。
     *
     * @param A
     * @return
     */
    public List<Integer> pancakeSort(int[] A) {
        int curLargestIndex = A.length - 1;
        List<Integer> ans = new ArrayList<>();
        while (curLargestIndex > 0) {
            int index = findLargestIndex(A,curLargestIndex);
            if (index!=curLargestIndex){
                swap(0,index,A);
                swap(0,curLargestIndex,A);
                ans.add(index+1);
                ans.add(curLargestIndex+1);
            }
            curLargestIndex--;
        }
        return ans;

    }

    private void swap(int start, int end, int[] A) {

       while (start<end){
           int temp = A[start];
           A[start] = A[end];
           A[end] = temp;
           start++;
           end--;
       }
    }

    private int findLargestIndex(int[] A, int end) {
        int max = 0;
        for (int i=1;i<=end;i++){
            if (A[max]<A[i])
                max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        _969_Pancake_Sorting pancake_sorting = new _969_Pancake_Sorting();
        System.out.println(pancake_sorting.pancakeSort(new int[]{1,2,3}));
//        System.out.println(pancake_sorting.pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
