package com.github.junyu.solution.offer;

public class _017_PrintNumber {


//    /**
//     * 输入数字n，按顺序打印出从1到最大的n位十进制。比如3，则打印1、2、3一直到最大的3位数999。
//     * solution 1
//     * 建立一个n长度的字符数组，如果是2位，那么字符数组最大的表示就是cs[0]=9,cs[1] = 9
//     *
//     * @param n
//     */
//    public void printToMaxOfDigits(int n) {
//        if (n <= 0)
//            return;
//
//        int cs[] = new int[n];
//
//        while (!increaseNum(cs)) {
//            printNum(cs);
//        }
//    }

//    /**
//     * 定义一个sum用于对尾数进行+1处理，takeOver为进位，当sum超过9时，takeOver就会被赋值为1。
//     * 遍历字符数组时，从尾部开始逐个处理，如果当前是最后一位，那么直接做+1处理。其他位数则是加上takeOver的值，处理进位后的问题。
//     * 当递增后有进位，会有两种情况，一种是当前已经是位数的最高位，那么无需处理，直接返回true，表示已经超出了n位数，停止程序。如果不是高位，那么将sum-10，takeover置为1，
//     * 然后将sum赋值给当前的元素，然后进行下一个位数的处理。
//     * 递增后没有进位，那么就将sum赋值给当前元素，后面的高位不需要处理。
//     *
//     * @param cs
//     * @return
//     */
//    private boolean increaseNum(int[] cs) {
//        int sum;
//        int takeOver = 0;
//        for (int i = cs.length - 1; i >= 0; i--) {
//
//            if (i == cs.length - 1) {
//                sum = cs[i] + 1;
//            } else {
//                sum = cs[i] + takeOver;
//            }
//            if (sum > 9) {//累加超过10
//                if (i == 0)//超过n位数
//                    return true;
//
//                sum -= 10;
//                takeOver = 1;
//                cs[i] = sum;
//            } else {
//                cs[i] = sum;
//                break;
//            }
//
//
//        }
//        return false;
//    }

    /**
     * solution2
     * 将问题转为求全排列，求n个由0-9组成的数，他们的全排列，利用递归求解
     * 从最高位开始往最低位进行递归，递归到底也就是个位数的时候，进行打印输出
     *
     * @param n
     */
    public void printToMaxOfDigits(int n) {
        if (n <= 0)
            return;

        int cs[] = new int[n];

        for (int i = 0; i < 10; i++) {
            cs[0] = i;
            increaseRecursively(n, cs, 0);
        }
    }

    private void increaseRecursively(int length, int[] cs, int index) {
        if (length - 1 == index) {
            printNum(cs);
            return;
        }

        for (int j = 0; j < 10; j++) {
            cs[index + 1] = j;
            increaseRecursively(length, cs, index + 1);
        }
    }

    /**
     * 打印的时候由于存在以0开头，为了不影响阅读，需要去除0。
     *
     * @param cs
     */
    private void printNum(int[] cs) {
        boolean isStartWith0 = true;
        for (int i = 0; i < cs.length; i++) {
            if (isStartWith0 && cs[i] != 0) {
                isStartWith0 = false;
            }

            if (!isStartWith0) {
                System.out.print(cs[i]);
            }
        }
        System.out.print("\t");
    }


    public static void main(String[] args) {
        new _017_PrintNumber().printToMaxOfDigits(3);
    }
}
