package com.github.junyu.solution.leetCode.medium.string;

public class _1419_Minimum_Number_of_Frogs_Croaking {


    /*Given the string croakOfFrogs, which represents a combination of the string "croak" from
    different frogs, that is, multiple frogs can croak at the same time, so multiple “croak” are mixed.
    Return the minimum number of different frogs to finish all the croak in the given string.

    A valid "croak" means a frog is printing 5 letters ‘c’, ’r’, ’o’, ’a’, ’k’ sequentially. The frogs
    have to print all five letters to finish a croak. If the given string is not a combination of valid "croak"
    return -1.

    Example 1:

    Input: croakOfFrogs = "croakcroak"
    Output: 1
    Explanation: One frog yelling "croak" twice.

    Example 2:

    Input: croakOfFrogs = "crcoakroak"
    Output: 2
    Explanation: The minimum number of frogs is two.
    The first frog could yell "crcoakroak".
    The second frog could yell later "crcoakroak".
    Example 3:

    Input: croakOfFrogs = "croakcrook"
    Output: -1
    Explanation: The given string is an invalid combination of "croak" from different frogs.
            Example 4:

    Input: croakOfFrogs = "croakcroa"
    Output: -1


    Constraints:

            1 <= croakOfFrogs.length <= 10^5
    All characters in the string are: 'c', 'r', 'o', 'a' or 'k'.
*/

    /**
     * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，
     * 所以 croakOfFrogs 中会混合多个 “croak”
     * 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
     * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
     * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1
     *
     * 这里我们需要定义一个数组去保存出现的字符的数量，通过这个数组里的元素，我们可以提前排除一些无效的组合比如aoocrrackk，在这种组合中，由于不是以c开头的
     * 即是不符合要求的。
     * 定义charCount数组去保存'c','r','o','a'出现的数量。
     * 遍历字符串时，只要出现'c'就意味着当前有效的可能增加1。当出现'r'时，我们需要先检查合法性，通过查看之前是否有出现过c，如果未出现过(charCount[0]==0)，
     * 则不合法。如果出现过那么就将c的数量-1，因为在最后遍历完数组以后，还需要查看charCount的中所有的元素的数量都归零了，如果有未归零的比如多一个'c'的情况，那么
     * 也是不合法的。
     * 遍历到'r'，那么需要减去'c'的数量，遍历到'o'需要减去'r'的数量,遍历到'a'减去'o'的数量，遍历到'k'减去'a'的数量，同时先通过比较curCount和maxCount获取到
     * 当前可能存在的最大值，然后将curCount进行递减，因为'k'是一个结束符，已经有一组蛙鸣符合条件。
     *
     * @param croakOfFrogs
     * @return
     */
    public int minNumberOfFrogs(String croakOfFrogs) {
        int maxCount = 0;
        int charCount[] = new int[4];
        int curCount = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            switch (croakOfFrogs.charAt(i)) {
                case 'c':
                    charCount[0]++;
                    curCount++;
                    break;
                case 'r':
                    if (charCount[0] == 0)
                        return -1;
                    charCount[0]--;
                    charCount[1]++;
                    break;
                case 'o':
                    if (charCount[1] == 0)
                        return -1;
                    charCount[1]--;
                    charCount[2]++;
                    break;
                case 'a':
                    if (charCount[2] == 0)
                        return -1;
                    charCount[2]--;
                    charCount[3]++;
                    break;
                case 'k':
                    if (charCount[3] == 0)
                        return -1;
                    charCount[3]--;
                    maxCount = Math.max(maxCount, curCount);
                    curCount--;
                    break;
            }
        }

        for (int count : charCount) {
            if (count != 0)
                return -1;
        }

        return maxCount;
    }

    public static void main(String[] args) {
        _1419_Minimum_Number_of_Frogs_Croaking test = new _1419_Minimum_Number_of_Frogs_Croaking();
        System.out.println(test.minNumberOfFrogs("croakcroak"));
        System.out.println(test.minNumberOfFrogs("crcoakroak"));
        System.out.println(test.minNumberOfFrogs("croakcrook"));
        System.out.println(test.minNumberOfFrogs("croakcroa"));
        System.out.println(test.minNumberOfFrogs("aoocrrackk"));
    }
}
