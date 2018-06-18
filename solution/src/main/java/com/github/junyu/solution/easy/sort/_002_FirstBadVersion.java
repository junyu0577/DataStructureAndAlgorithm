package com.github.junyu.solution.easy.sort;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/18 10:15
 */
public class _002_FirstBadVersion {

   /* You are a product manager and currently leading a team to develop a new product. Unfortunately,
    the latest version of your product fails the quality check.
    Since each version is developed based on the previous version, all the versions after a bad version are also bad.
    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
    which causes all the following ones to be bad.

    You are given an API bool isBadVersion(version) which will return whether version is bad.
    Implement a function to find the first bad version. You should minimize the number of calls to the API.*/

   /* Example:

    Given n = 5, and version = 4 is the first bad version.

    call isBadVersion(3) -> false
    call isBadVersion(5) -> true
    call isBadVersion(4) -> true

    Then 4 is the first bad version.*/

    private static boolean isBadVersion(int version) {
        if (version >= 3) {
            return true;
        }
        return false;
    }

    /**
     * 思路：利用二分查找，每次计算mid值后判断是否是badVersion,如果不是则区间落到[mid+1, ... , right],否则落在[left, ... , mid]
     * 当left>=right时，left的值就是我们要寻找的
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid;

        while (left < right) {
            mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
