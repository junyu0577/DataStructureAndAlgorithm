package com.github.junyu.solution.leetCode.easy.string;

public class _1154_Day_of_the_Year {

    /*Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of
    the year.

    Example 1:

    Input: date = "2019-01-09"
    Output: 9
    Explanation: Given date is the 9th day of the year in 2019.
    Example 2:

    Input: date = "2019-02-10"
    Output: 41
    Example 3:

    Input: date = "2003-03-01"
    Output: 60
    Example 4:

    Input: date = "2004-03-01"
    Output: 61


    Constraints:

    date.length == 10
    date[4] == date[7] == '-', and all other date[i]'s are digits
    date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.*/

    /**
     * 一年中的第几天
     * 思路：定义月的天数哈希表，然后获取字符串中的年月日，累加各月份的天数（从1月到month-1月），如果是闰年并且已经到3月之后，还需要额外增加一天。
     * 最后在加上当前月的天数
     * @param date
     * @return
     */
    public int dayOfYear(String date) {
        int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int sum = 0;
        for (int i = 0; i < month-1; i++) {
            sum += dayOfMonth[i];
            if (i == 1 && isLeapYear(year)) {
                sum++;
            }
        }
        sum += day;
        return sum;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        _1154_Day_of_the_Year test = new _1154_Day_of_the_Year();
        System.out.println(test.dayOfYear("2019-01-09"));
        System.out.println(test.dayOfYear("2019-02-10"));
        System.out.println(test.dayOfYear("2003-03-01"));
        System.out.println(test.dayOfYear("2004-03-01"));
    }
}
