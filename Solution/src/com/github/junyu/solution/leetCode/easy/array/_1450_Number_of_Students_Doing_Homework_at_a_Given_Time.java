package com.github.junyu.solution.leetCode.easy.array;

public class _1450_Number_of_Students_Doing_Homework_at_a_Given_Time {

   /* Given two integer arrays startTime and endTime and given an integer queryTime.

    The ith student started doing their homework at the time startTime[i] and finished
    it at time endTime[i].

    Return the number of students doing their homework at time queryTime. More formally,
    return the number of students where queryTime lays in the interval [startTime[i],
    endTime[i]] inclusive.



    Example 1:

    Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
    Output: 1
    Explanation: We have 3 students where:
    The first student started doing homework at time 1 and finished at time 3
    and wasn't doing anything at time 4.
    The second student started doing homework at time 2 and finished at time 2
    and also wasn't doing anything at time 4.
    The third student started doing homework at time 3 and finished at time 7
    and was the only student doing homework at time 4.
    Example 2:

    Input: startTime = [4], endTime = [4], queryTime = 4
    Output: 1
    Explanation: The only student was doing their homework at the queryTime.
    Example 3:

    Input: startTime = [4], endTime = [4], queryTime = 5
    Output: 0
    Example 4:

    Input: startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
    Output: 0
    Example 5:

    Input: startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
    Output: 5


    Constraints:

    startTime.length == endTime.length
    1 <= startTime.length <= 100
            1 <= startTime[i] <= endTime[i] <= 1000
            1 <= queryTime <= 1000*/

    /**
     * 统计数组中queryTime处在startTime和endTime区间的数量
     * 思路：只要开始时间小于等于queryTime，结束时间大于queryTime就符合。
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i=0;i<startTime.length;i++){
            if (startTime[i]<=queryTime && queryTime<=endTime[i])
                count++;
        }
        return count;
    }


    public static void main(String [] args) {
        _1450_Number_of_Students_Doing_Homework_at_a_Given_Time test = new _1450_Number_of_Students_Doing_Homework_at_a_Given_Time();
        System.out.println(test.busyStudent(new int[]{1,2,3},new int[]{3,2,7},4));
        System.out.println(test.busyStudent(new int[]{4},new int[]{4},4));
        System.out.println(test.busyStudent(new int[]{4},new int[]{4},5));
        System.out.println(test.busyStudent(new int[]{1,1,1,1},new int[]{1,3,2,4},7));
        System.out.println(test.busyStudent(new int[]{9,8,7,6,5,4,3,2,1},new int[]{10,10,10,10,10,10,10,10,10},5));
    }

}
