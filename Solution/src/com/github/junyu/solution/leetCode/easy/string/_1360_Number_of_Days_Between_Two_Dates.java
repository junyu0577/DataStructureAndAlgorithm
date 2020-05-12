package com.github.junyu.solution.leetCode.easy.string;

public class _1360_Number_of_Days_Between_Two_Dates {

    /*Write a program to count the number of days between two dates.

    The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.

    Example 1:

    Input: date1 = "2019-06-29", date2 = "2019-06-30"
    Output: 1
    Example 2:

    Input: date1 = "2020-01-15", date2 = "2019-12-31"
    Output: 15

    Constraints:

    The given dates are valid dates between the years 1971 and 2100.*/

    /**
     * 计算给定的两个日期的间隔天数
     * 思路：分别统计从当前日期开始到1971-00-00的天数，统计期间注意闰年是366天，闰年的二月是29天，
     * 统计到两个日期的天数后，相减的绝对值即是两者间隔的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getDays(date1) - getDays(date2));
    }

    private int getDays(String date) {
        int monthlyDays[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int days = 0;
        for (int i = 1971; i < year; i++) {
            days += 365;
            if (isLeapYear(i))
                days++;
        }

        for (int i = 1; i < month; i++) {
            days += monthlyDays[i - 1];

            if (i == 2 && isLeapYear(year))
                days++;
        }

        return days + day;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
            return true;
        return false;
    }


    public static void main(String[] args) {
        _1360_Number_of_Days_Between_Two_Dates test = new _1360_Number_of_Days_Between_Two_Dates();
        System.out.println(test.daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(test.daysBetweenDates("2020-01-15", "2019-12-31"));

    }
}
