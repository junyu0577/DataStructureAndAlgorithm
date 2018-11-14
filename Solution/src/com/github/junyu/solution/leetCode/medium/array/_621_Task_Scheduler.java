package com.github.junyu.solution.leetCode.medium.array;

import java.util.Arrays;

public class _621_Task_Scheduler {

   /* Given a char array representing tasks CPU need to do. It contains capital
    letters A to Z where different letters represent different tasks.Tasks
    could be done without original order. Each task could be done in one interval.
    For each interval, CPU could finish one task or just be idle.

            However, there is a non-negative cooling interval n that means between
    two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

    You need to return the least number of intervals the CPU will take to finish all the given tasks.



            Example:

    Input: tasks = ['A','A','A','B','B','B'], n = 2
    Output: 8
    Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.


            Note:

    The number of tasks is in the range [1, 10000].
    The integer n is in the range [0, 100].*/

    /**
     * 计算完成任务需要的最短时间
     * 首先定义一个hash表统计各任务的次数，然后对hash进行一个排序。
     * 从数量最多的任务开始执行，里循环的目的是为了更合理的消除执行不同任务需要等待的冷却时间。
     * 里循环每次从最后依次往前执行任务，熬过冷却时间，那么又可以从数量最多的任务开始再重复上述的流程。
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (n < 1)
            return tasks.length;

        int arr[] = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            arr[tasks[i] - 'A']++;
        }
        Arrays.sort(arr);
        int duration = 0;
        while (arr[25]>0){
            int i=0;
            while (i<=n){
                if (arr[25]<=0)
                    break;

                if (i<26 && arr[25-i]>0)
                    arr[25-i]--;

                duration++;
                i++;
            }
            Arrays.sort(arr);
        }

        return duration;

    }

    public static void main(String[] args) {
        _621_Task_Scheduler task_scheduler = new _621_Task_Scheduler();
        System.out.println(task_scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

}
