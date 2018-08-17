package com.github.junyu.solution.leetCode.easy.array;

public class _027_Remove_Element {

/*    Given an array nums and a value val, remove all instances of that value in-place
    and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the
    input array in-place with O(1) extra memory.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.

    Example 1:

    Given nums = [3,2,2,3], val = 3,

    Your function should return length = 2, with the first two elements of nums being 2.

    It doesn't matter what you leave beyond the returned length.
    Example 2:

    Given nums = [0,1,2,2,3,0,4,2], val = 2,

    Your function should return length = 5, with the first five elements of nums
    containing 0, 1, 3, 0, and 4.

    Note that the order of those five elements can be arbitrary.

    It doesn't matter what values are set beyond the returned length.
    Clarification:

    Confused why the returned value is an integer but your answer is an array?

    Note that the input array is passed in by reference, which means modification to the
    input array will be known to the caller as well.

    Internally you can think of this:

    // nums is passed in by reference. (i.e., without making a copy)
    int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
        print(nums[i]);
    }*/

//    /**
//     * 删除数组中元素为val的数组，其他的元素需要往前移，但是排序不做要求
//     * 定义一个指针指向末尾，在遍历数组的时候，每当遇到一个待删除的元素，就用末尾的数组覆盖待删除的元素，然后维护下末尾指针--,
//     * 最后返回删除元素后的数组长度，这时可以定义一个count变量，每当遇到要替换的元素，就递增count值，最后用数组的长度-count就是
//     * 需要的答案
//     *
//     * @param nums
//     * @param val
//     * @return
//     */
//    public int removeElement(int[] nums, int val) {
//        if (nums == null || nums.length == 0)
//            return 0;
//        int count = 0;
//        int tail = nums.length - 1;
//        for (int i = 0; i < nums.length && i <= tail; i++) {
//            if (nums[i] == val) {
//                while (nums[tail] == val) {
//                    nums[tail] = val ^ 1;
//                    count++;
//                    if (tail == i)
//                        return nums.length - count;
//                    tail--;
//                }
//                nums[i] = nums[tail];
//                tail--;
//                count++;
//            }
//        }
//
//        return nums.length - count;
//
//    }

    /**
     * 解法二
     * 定义一个index指针指向头部，遍历数组的时候，遇到不是要删除的元素，就将第i个位置的元素赋值给index，然后递增index，如果是待删除的元素，
     * 那么他不变，等遇到下一个不是待删除元素的时候，将值赋给index指向的位置，然后递增index，最终index所指的位置就是删除元素后的数组
     * 长度
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        int arr[] = {3, 2, 2, 3};
        int arr[] = {0, 1, 2, 2, 3, 0, 4, 2};
        _027_Remove_Element remove_element = new _027_Remove_Element();
        System.out.println(remove_element.removeElement(arr, 2));
    }
}
