package com.github.junyu.solution.leetCode.easy.string;

public class _1507_Reformat_Date {

   /* Given a date string in the form Day Month Year, where:

    Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
    Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
    Year is in the range [1900, 2100].
    Convert the date string to the format YYYY-MM-DD, where:

    YYYY denotes the 4 digit year.
    MM denotes the 2 digit month.
    DD denotes the 2 digit day.


    Example 1:

    Input: date = "20th Oct 2052"
    Output: "2052-10-20"
    Example 2:

    Input: date = "6th Jun 1933"
    Output: "1933-06-06"
    Example 3:

    Input: date = "26th May 1960"
    Output: "1960-05-26"


    Constraints:

    The given dates are guaranteed to be valid, so no error handling is necessary.*/

    /**
     * 日期转换
     * 思路：按空格分割字符串，分别对月日进行处理。年不需要额外处理。
     * 月份根据月份数组查找到对应的索引+1进行转换。如果当前索引小于9表示10月份之前的月份需要补0。
     * 日根据字符串的前两位是否是数字来进行转换。
     * @param date
     * @return
     */
    public String reformatDate(String date) {
        String[] dateArr = date.split(" ");
        String[] monthArr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        StringBuilder sb = new StringBuilder();
        sb.append(dateArr[2]);
        sb.append("-");
        String month = dateArr[1];
        String day = dateArr[0];
        for (int i = 0; i < monthArr.length; i++) {
            if (monthArr[i].equals(month)) {
                if (i < 9) {
                    sb.append("0");
                }
                sb.append(i+1);
                break;
            }
        }
        sb.append("-");
        if (Character.isDigit(day.charAt(0)) && Character.isDigit(day.charAt(1))) {
            sb.append(day.charAt(0));
            sb.append(day.charAt(1));
        } else {
            sb.append('0');
            sb.append(day.charAt(0));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _1507_Reformat_Date test = new _1507_Reformat_Date();
        System.out.println(test.reformatDate("20th Oct 2052"));
        System.out.println(test.reformatDate("6th Jun 1933"));
        System.out.println(test.reformatDate("26th May 1960"));
        System.out.println(test.reformatDate("22nd Apr 2023"));
    }
}
