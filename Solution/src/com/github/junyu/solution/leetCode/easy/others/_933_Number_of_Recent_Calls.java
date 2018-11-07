package com.github.junyu.solution.leetCode.easy.others;


import java.util.LinkedList;
import java.util.Queue;

public class _933_Number_of_Recent_Calls {


    /*Write a class RecentCounter to count recent requests.

    It has only one method: ping(int t), where t represents some time in milliseconds.

    Return the number of pings that have been made from 3000 milliseconds ago until now.

    Any ping with time in [t - 3000, t] will count, including the current ping.

    It is guaranteed that every call to ping uses a strictly larger value of t than before.



            Example 1:

    Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
    Output: [null,1,2,3,3]


    Note:

    Each test case will have at most 10000 calls to ping.
    Each test case will call ping with strictly increasing values of t.
    Each call to ping will have 1 <= t <= 10^9.*/

    private Queue<Integer> list;

    /**
     * 最近3秒内的ping数量
     * 使用队列，每次有新的pin时，遍历队列，如果当前的t-当前的元素大于3000，就删掉
     * 元素。最后剩下的元素的之间的pin时间都小于3秒
     *
     */
    public _933_Number_of_Recent_Calls() {
        list = new LinkedList<>();
    }

    public int ping(int t) {

        while (!list.isEmpty() && t - list.peek() > 3000) {
            list.poll();
        }
        list.add(t);

        return list.size();

    }

    public static void main(String[] args) {
        _933_Number_of_Recent_Calls number_of_recent_calls = new _933_Number_of_Recent_Calls();
        System.out.println(number_of_recent_calls.ping(1));
        System.out.println(number_of_recent_calls.ping(100));
        System.out.println(number_of_recent_calls.ping(3001));
        System.out.println(number_of_recent_calls.ping(3002));
    }


}
