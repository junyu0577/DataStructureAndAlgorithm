package com.github.junyu.solution.leetCode.easy.math;

/**
 * @author ShaoJunyu
 * @since 2018/7/25 15:38
 */
public class _001_Count_Primes {

    /*Count the number of prime numbers less than a non-negative number, n.

    Example:

    Input: 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.*/


    /**
     * 埃拉托斯特尼筛法
     * 剔除掉所有不大于根号n的素数的倍数
     *  marked数组标记当前索引位置的数是否已经被剔除，默认都为false表示没有被剔除
     *  第0个元素为自然数1
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        if (n < 3)
            return 0;
        boolean marked[] = new boolean[n - 1];
        marked[0] = true;
        int size = (int) Math.sqrt(n);
        for (int i=2;i<=size;i++){
            if (!marked[i-1]){//未被剔除,遍历数组去剔除i的倍数
                for (int j=i+i;j<n;j+=i){
                    marked[j-1] = true;
                }
            }
        }
        int count = 0;
        for (int i=0;i<marked.length;i++)
            if (!marked[i])
                count++;
        return count;
    }

    public static void main(String args[]) {
        System.out.println(countPrimes(10));
    }
}
