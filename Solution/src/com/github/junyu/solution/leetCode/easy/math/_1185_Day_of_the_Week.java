package com.github.junyu.solution.leetCode.easy.math;

public class _1185_Day_of_the_Week {

    /*Given a date, return the corresponding day of the week for that date.

    The input is given as three integers representing the day, month and year respectively.

    Return the answer as one of the following values {"Sunday", "Monday",
            "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.



    Example 1:

    Input: day = 31, month = 8, year = 2019
    Output: "Saturday"
    Example 2:

    Input: day = 18, month = 7, year = 1999
    Output: "Sunday"
    Example 3:

    Input: day = 15, month = 8, year = 1993
    Output: "Sunday"


    Constraints:

    The given dates are valid dates between the years 1971 and 2100.*/

    /**
     * 给定的日期是星期几
     * 根据基姆拉尔森的日期公式
     * @param day
     * @param month
     * @param year
     * @return
     */
    public String dayOfTheWeek(int day, int month, int year) {
        String[] ans = new String[]{ "Monday",
                "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday",};
        if ((month == 1) || (month == 2)) {
            month += 12;
            year--;
        }
        return ans[(day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7];
    }

    public static void main(String[] args) {
        _1185_Day_of_the_Week test = new _1185_Day_of_the_Week();
        System.out.println(test.dayOfTheWeek(31, 8, 2019));
        System.out.println(test.dayOfTheWeek(18, 7, 1999));
        System.out.println(test.dayOfTheWeek(15, 8, 1993));
    }
}
