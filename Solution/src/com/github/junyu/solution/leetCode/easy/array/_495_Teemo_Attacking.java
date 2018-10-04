package com.github.junyu.solution.leetCode.easy.array;

public class _495_Teemo_Attacking {

 /*   In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe
    be in poisoned condition. Now, given the Teemo's attacking ascending time series towards
    Ashe and the poisoning time duration per Teemo's attacking, you need to output the total
    time that Ashe is in poisoned condition.

    You may assume that Teemo attacks at the very beginning of a specific time point, and makes
    Ashe be in poisoned condition immediately.

    Example 1:
    Input: [1,4], 2
    Output: 4
    Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
    This poisoned status will last 2 seconds until the end of time point 2.
    And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
    So you finally need to output 4.
    Example 2:
    Input: [1,2], 2
    Output: 3
    Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
    This poisoned status will last 2 seconds until the end of time point 2.
    However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
    Since the poisoned status won't add up together, though the second poisoning attack will still work at time
    point 2, it will stop at the end of time point 3.
    So you finally need to output 3.
    Note:
    You may assume the length of given time series array won't exceed 10000.
    You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking
    are non-negative integers, which won't exceed 10,000,000.*/

    /**
     * 提莫的攻击，计算毒药的总体持续时间，需要减去叠加部分
     * 首先计算一下整个攻击序列与duration产生的总体持续时间，这个时间是包含叠加部分的。
     * 所以我们需要通过遍历整个攻击序列，减去重叠的部分时间。
     * 从第二个元素开始判断，如果前面的一个元素的攻击时间+duration>第二个元素，就表示有重叠时间在里边。
     * 而前面的一个元素的攻击时间+duration-当前元素的攻击时间就是重叠部分的时间，我们拿total一减，就是去除重叠时间
     * 后的有效时间。如此反复，就得到最后的total。
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = duration * timeSeries.length;

        if (timeSeries.length == 1)
            return total;

        for (int i = 1; i < timeSeries.length; i++) {
           if (timeSeries[i-1]+duration>timeSeries[i]){
               total-=timeSeries[i-1]+duration-timeSeries[i];
           }
        }

        return total;
    }


    public static void main(String [] args) {
        _495_Teemo_Attacking teemo_attacking = new _495_Teemo_Attacking();
        System.out.println(teemo_attacking.findPoisonedDuration(new int[]{1,2},2));
    }


}
