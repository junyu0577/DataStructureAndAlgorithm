package com.github.junyu.solution.leetCode.medium.array;

import java.util.*;

public class _056_Merge_Intervals {

    /*Given a collection of intervals, merge all overlapping intervals.

    Example 1:

    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    Example 2:

    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considerred overlapping.*/

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * 合并所有重叠区间
     * 先对区间集合根据start属性进行一次排序。遍历排完序的区间，每一次判断结果链表,如果当前区间的开始值位于链表的最后一个元素
     * 的区间（有交集），则更新链表末尾区别的结束值（取当前末尾的结束值和链表末尾的结束值中的最大值）。
     * 如果没有交集，则往链表中插入当前的区间。
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        LinkedList<Interval> res = new LinkedList<>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > res.getLast().end) {
                res.add(intervals.get(i));
            } else {
                res.getLast().end = Math.max(intervals.get(i).end, res.getLast().end);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        _056_Merge_Intervals merge_intervals = new _056_Merge_Intervals();
        List<Interval> list = new ArrayList<>();
//        list.add(new Interval(1, 3));
//        list.add(new Interval(2, 6));
//        list.add(new Interval(8, 10));
//        list.add(new Interval(15, 18));


//        list.add(new Interval(1, 4));
//        list.add(new Interval(0, 4));

//        list.add(new Interval(1, 4));
//        list.add(new Interval(2, 3));

//        list.add(new Interval(1, 4));
//        list.add(new Interval(0,2));
//        list.add(new Interval(3,5));

        list.add(new Interval(2, 3));
        list.add(new Interval(2,2));
        list.add(new Interval(3,3));
        list.add(new Interval(1,3));
        list.add(new Interval(5,7));
        list.add(new Interval(2,2));
        list.add(new Interval(4,6));

        List<Interval> res = merge_intervals.merge(list);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).start + "," + res.get(i).end);
        }
    }
}
