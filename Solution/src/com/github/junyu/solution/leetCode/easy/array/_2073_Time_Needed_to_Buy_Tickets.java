package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _2073_Time_Needed_to_Buy_Tickets {

/*

    There are n people in a line queuing to buy tickets, where the 0th person is at the front
     of the line and the (n - 1)th person is at the back of the line.

    You are given a 0-indexed integer array tickets of length n where the number of tickets that
     the ith person would like to buy is tickets[i].

    Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time
     and has to go back to the end of the line (which happens instantaneously) in order to buy more
      tickets. If a person does not have any tickets left to buy, the person will leave the line.

    Return the time taken for the person at position k (0-indexed) to finish buying tickets.



    Example 1:

    Input: tickets = [2,3,2], k = 2
    Output: 6
    Explanation:
            - In the first pass, everyone in the line buys a ticket and the line becomes [1, 2, 1].
            - In the second pass, everyone in the line buys a ticket and the line becomes [0, 1, 0].
    The person at position 2 has successfully bought 2 tickets and it took 3 + 3 = 6 seconds.


    Example 2:

    Input: tickets = [5,1,1,1], k = 0
    Output: 8
    Explanation:
            - In the first pass, everyone in the line buys a ticket and the line becomes [4, 0, 0, 0].
            - In the next 4 passes, only the person in position 0 is buying tickets.
    The person at position 0 has successfully bought 5 tickets and it took 4 + 1 + 1 + 1 + 1 = 8 seconds.


            Constraints:

    n == tickets.length
1 <= n <= 100
            1 <= tickets[i] <= 100
            0 <= k < n

*/

    /**
     * 优化方案，不使用对象，不断的遍历数组，每次遍历同时减少票数，当票数大于0的时候需要累加time。然后再对减后的
     * 当前元素进行判断，如刚好是第k个且票数为0则返回time。
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了44.23%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了55.97%的用户
     * @param tickets
     * @param k
     * @return
     */
    public int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0;
        while (true) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    time++;
                }
                if (tickets[k] == 0)
                    return time;
            }
        }

    }

//    /**
//     * 买票需要的时间
//     * 通过自定义对象，标记目标target。
//     * 每次循环time都需要增加1秒。取出队列的第一个对象，减去票数以后判断剩余的数量，如果恰好为0并且是目标对象，则直接返回time。
//     * 否则继续判断当前对象是否有余票，如果有则将其从队首移到队尾。
//     * 直到循环到目标的票数为0为止。
//     *
//     * Runtime: 6 ms, faster than 44.44% of Java online submissions for Time Needed to Buy Tickets.
//     * Memory Usage: 36.8 MB, less than 66.67% of Java online submissions for Time Needed to Buy Tickets.
//     * @param tickets
//     * @param k
//     * @return
//     */
//    public int timeRequiredToBuy(int[] tickets, int k) {
//        List<Target> list = new ArrayList<>();
//        for (int i=0;i<tickets.length;i++){
//            Target targetBean = new Target(false,tickets[i]);
//            list.add(targetBean);
//        }
//        list.get(k).isTarget = true;
//
//        int time = 0;
//        while (true){
//            time++;
//            Target target = list.get(0);
//            target.tickets--;
//            if (target.isTarget && target.tickets==0)
//                return time;
//
//            if (target.tickets>0){
//                list.add(target);
//            }
//            list.remove(0);
//        }
//
//    }

    class Target {
        public boolean isTarget;
        public int tickets;

        public Target(boolean isTarget, int tickets) {
            this.isTarget = isTarget;
            this.tickets = tickets;
        }
    }

    public static void main(String[] args) {
        _2073_Time_Needed_to_Buy_Tickets test = new _2073_Time_Needed_to_Buy_Tickets();
        System.out.println(test.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(test.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
    }

}
