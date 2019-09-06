package com.github.junyu.solution.leetCode.medium.backtracking;


public class _1079_Letter_Tile_Possibilities {

   /*
    You have a set of tiles, where each tile has one letter tiles[i] printed on it.
    Return the number of possible non-empty sequences of letters you can make.

    Example 1:

    Input: "AAB"
    Output: 8
    Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
    Example 2:

    Input: "AAABBC"
    Output: 188

    Note:

      1 <= tiles.length <= 7
    tiles consists of uppercase English letters.
    */

    /**
     * 求字符串字符能够组成的非空序列的总数，排列问题
     * 总体思路利用hash表记录字母出现的次数，这样做的好处是既统计到了字母个数，也建立的字母顺序。
     * 然后对这个hash表中做深度优先搜索，每一层都会遍历到26个字母。
     * 从第一层开始，得到'A'，那么sum++；由于这个'A'已经被我们累加进行一次，所以在往下一层
     * 递归之前，需要排除掉'A'。
     * 递归到第二层，这时hash表中有'A'和'B'两个字符，按字母顺序，我们又取到了'A'，同样再往第三层走。
     * 第三层，这时只剩下'B'，往第四层走。
     * 到了第四层，由于已经没有元素了，那么自然sum返回0；
     * 回溯到第三层，'B'以后也没有元素，回溯到第二层，把第三层得到的sum=1返回，然后需要把'B'重新添回hash表。
     * 回溯到第二层后，index+1后取到了'B',得到一个新的组合'AB'，以此类推。
     * 取值过程：A AA AAB  AB ABA B BA BAA
     * 由于在整个过程中，我们是按字典序进行循环和递归的，并且在递归前排除了当前的元素，因此不存在重复的排列可能。
     *
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        int bucket[] = new int[26];
        char[] cs = tiles.toCharArray();
        for (char c : cs) {
            bucket[c - 'A']++;
        }
        return dfs(bucket);
    }

    private int dfs(int[] bucket) {
        int sum = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0)
                continue;

            sum++;
            bucket[i]--;
            sum += dfs(bucket);
            bucket[i]++;
        }
        return sum;
    }

    public static void main(String[] args) {
        _1079_Letter_Tile_Possibilities letter_tile_possibilities = new _1079_Letter_Tile_Possibilities();
        System.out.println(letter_tile_possibilities.numTilePossibilities("AAB"));
        System.out.println(letter_tile_possibilities.numTilePossibilities("AAABBC"));
    }
}
