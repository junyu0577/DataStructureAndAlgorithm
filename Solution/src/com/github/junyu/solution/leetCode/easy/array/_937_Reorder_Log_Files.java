package com.github.junyu.solution.leetCode.easy.array;

import java.util.*;

public class _937_Reorder_Log_Files {

   /* You have an array of logs.  Each log is a space delimited string of words.

    For each log, the first word in each log is an alphanumeric identifier.  Then, either:

    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.
    We will call these two varieties of logs letter-logs and digit-logs.
    It is guaranteed that each log has at least one word after its identifier.

    Reorder the logs so that all of the letter-logs come before any digit-log.
    The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
    The digit-logs should be put in their original order.

    Return the final order of the logs.



    Example 1:

    Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
    Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]


    Note:

            0 <= logs.length <= 100
            3 <= logs[i].length <= 100
    logs[i] is guaranteed to have an identifier, and a word after the identifier.
    */

    /**
     * 重新排列logs数组，logs一共有两类纯字母和带数字的，纯字母的日志都要排在带数字之前。
     * 纯字母按字典序进行排序(字符串比较范围从第一个空格后的第一个字符开始至结尾)，带数字
     * 的按原来的先后顺序不动。
     * 定义两个list分别存放纯字母和带数字的，分类时使用空格进行split，然后判断第一个字符是否为数字。
     * 筛选完后使用交换排序对纯字母的list进行排序，最后将带数字的list添加进纯字母的list，转为数组返回结果。
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {

        if (logs == null || logs.length == 0)
            return new String[]{};


        List<String> nums = new ArrayList<>();
        List<String> letters = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String str = logs[i].split(" ",2)[1];
            if (isDigit(str.charAt(0)))
                nums.add(logs[i]);
            else
                letters.add(logs[i]);
        }

        Collections.sort(letters, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 =  o1.split(" ",2)[1];
                String s2 =  o2.split(" ",2)[1];
                return s1.compareTo(s2);
            }
        });


        letters.addAll(nums);

        return letters.toArray(new String[letters.size()]);
    }

    private boolean isDigit(char c){
        if (c >= '0' && c<='9')
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        _937_Reorder_Log_Files reorder_log_files = new _937_Reorder_Log_Files();
        System.out.println(Arrays.toString(reorder_log_files.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));

    }

}
