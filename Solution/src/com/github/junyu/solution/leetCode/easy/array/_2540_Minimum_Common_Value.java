package com.github.junyu.solution.leetCode.easy.array;

public class _2540_Minimum_Common_Value {


//    给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。
//
//    如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。
//
//             
//
//    示例 1：
//
//    输入：nums1 = [1,2,3], nums2 = [2,4]
//    输出：2
//    解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
//    示例 2：
//
//    输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
//    输出：2
//    解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
//             
//
//    提示：
//
//            1 <= nums1.length, nums2.length <= 105
//            1 <= nums1[i], nums2[j] <= 109
//    nums1 和 nums2 都是 非降序 的。


    /**
     * 最小公共值
     * 根据题目已知是升序数组，使用双指针，
     * 从两个数组的头部开始进行比较。将较小的一边的指针向右移动，如果相等就已经找到了最小公共值。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int getCommon(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2])
                return nums1[p1];
            if (nums1[p1] < nums2[p2])
                p1++;
            else
                p2++;
        }

        return -1;
    }

    public static void main(String[] args) {
        _2540_Minimum_Common_Value test = new _2540_Minimum_Common_Value();
        System.out.println(test.getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
        System.out.println(test.getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5}));

    }
}
