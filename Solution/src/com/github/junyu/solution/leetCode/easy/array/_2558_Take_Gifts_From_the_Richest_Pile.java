package com.github.junyu.solution.leetCode.easy.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _2558_Take_Gifts_From_the_Richest_Pile {


//    给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：
//
//    选择礼物数量最多的那一堆。
//    如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
//    选中的那一堆留下平方根数量的礼物（向下取整），取走其他的礼物。
//    返回在 k 秒后剩下的礼物数量。
//
//             
//
//    示例 1：
//
//    输入：gifts = [25,64,9,4,100], k = 4
//    输出：29
//    解释：
//    按下述方式取走礼物：
//            - 在第一秒，选中最后一堆，剩下 10 个礼物。
//            - 接着第二秒选中第二堆礼物，剩下 8 个礼物。
//            - 然后选中第一堆礼物，剩下 5 个礼物。
//            - 最后，再次选中最后一堆礼物，剩下 3 个礼物。
//    最后剩下的礼物数量分别是 [5,8,9,4,3] ，所以，剩下礼物的总数量是 29 。
//    示例 2：
//
//    输入：gifts = [1,1,1,1], k = 4
//    输出：4
//    解释：
//    在本例中，不管选中哪一堆礼物，都必须剩下 1 个礼物。
//    也就是说，你无法获取任一堆中的礼物。
//    所以，剩下礼物的总数量是 4 。
//             
//
//    提示：
//
//            1 <= gifts.length <= 103
//            1 <= gifts[i] <= 109
//            1 <= k <= 103
//

    /**
     * 从数量最多的堆取走礼物
     * 将数组的元素添加到优先队列中，降序排序。然后循环k次，每次对队列的第一个元素进行开根处理，如果为1则直接跳出循环。
     * poll出来的元素处理后还需要入队，最后遍历队列计算元素和。
     * @param gifts
     * @param k
     * @return
     */
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < gifts.length; i++) {
            pq.offer(gifts[i]);
        }
        for (int i = 0; i < k; i++) {
            int num = pq.poll();
            if (num == 1) {
                pq.offer(num);
                break;
            }
            pq.offer((int) Math.sqrt(num));

        }
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }


    public static void main(String[] args) {
        _2558_Take_Gifts_From_the_Richest_Pile test = new _2558_Take_Gifts_From_the_Richest_Pile();
        System.out.println(test.pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
        System.out.println(test.pickGifts(new int[]{1, 1, 1, 1}, 4));
    }
}
