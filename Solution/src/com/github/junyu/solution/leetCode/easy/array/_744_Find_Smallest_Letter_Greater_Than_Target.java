package com.github.junyu.solution.leetCode.easy.array;

public class _744_Find_Smallest_Letter_Greater_Than_Target {

/*
    Given a list of sorted characters letters containing only lowercase letters, and given a
    target letter target, find the smallest element in the list that is larger than the given target.

    Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

    Examples:
    Input:
    letters = ["c", "f", "j"]
    target = "a"
    Output: "c"

    Input:
    letters = ["c", "f", "j"]
    target = "c"
    Output: "f"

    Input:
    letters = ["c", "f", "j"]
    target = "d"
    Output: "f"

    Input:
    letters = ["c", "f", "j"]
    target = "g"
    Output: "j"

    Input:
    letters = ["c", "f", "j"]
    target = "j"
    Output: "c"

    Input:
    letters = ["c", "f", "j"]
    target = "k"
    Output: "c"
    Note:
    letters has a length in range [2, 10000].
    letters consists of lowercase letters, and contains at least 2 unique letters.
    target is a lowercase letter.
    */

//    /**
//     * 在数组中找出仅大于target的字符，如果给定的target大于等于最后一个字符，那么就取第一个元素作为答案
//     * 遍历数组挨个比较，如果当前的大于target，就找到目标了，
//     * 如果到最后都没有大于target的，那么第0个就是
//     * @param letters
//     * @param target
//     * @return
//     */
//    public char nextGreatestLetter(char[] letters, char target) {
//        for (int i = 0; i < letters.length; i++) {
//            if (letters[i] > target)
//                return letters[i];
//        }
//        return letters[0];
//    }

    /**
     * 用二分查找法 时间复杂度为O（logn）
     * 和常规的二分查找不同的点是，由于在查找的时候，如果当前比target大，那么当前的这个元素我们需要继续考虑。但是这样就需要我们的循环终止条件为left<right，不然
     * 就会进入死循环。
     * 起始地right需要在数组的长度处开始而不是长度-1，如果是长度-1，最后一个元素就不会被考虑进来
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (letters[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }
        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        _744_Find_Smallest_Letter_Greater_Than_Target find_smallest_letter_greater_than_target = new _744_Find_Smallest_Letter_Greater_Than_Target();
        System.out.println(find_smallest_letter_greater_than_target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(find_smallest_letter_greater_than_target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(find_smallest_letter_greater_than_target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(find_smallest_letter_greater_than_target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'f'));
        System.out.println(find_smallest_letter_greater_than_target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'z'));
        System.out.println(find_smallest_letter_greater_than_target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
    }
}
