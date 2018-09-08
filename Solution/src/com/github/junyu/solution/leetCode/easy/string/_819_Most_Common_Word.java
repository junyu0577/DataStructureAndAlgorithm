package com.github.junyu.solution.leetCode.easy.string;

import java.util.*;

public class _819_Most_Common_Word {


  /*  Given a paragraph and a list of banned words, return the most frequent word that
    is not in the list of banned words.  It is guaranteed there is at least one word
    that isn't banned, and that the answer is unique.

    Words in the list of banned words are given in lowercase, and free of punctuation.
    Words in the paragraph are not case sensitive.  The answer is in lowercase.

            Example:
    Input:
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]
    Output: "ball"
    Explanation:
            "hit" occurs 3 times, but it is a banned word.
            "ball" occurs twice (and no other word does), so it is the most frequent non-banned
    word in the paragraph.
    Note that words in the paragraph are not case sensitive,
    that punctuation is ignored (even if adjacent to words, such as "ball,"),
    and that "hit" isn't the answer even though it occurs more because it is banned.


    Note:

            1 <= paragraph.length <= 1000.
            1 <= banned.length <= 100.
            1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may
            have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    Different words in paragraph are always separated by a space.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.*/

    /**
     * 判断除禁用列表单词外，出现频率最高的单词。
     * 通过stringBuild组合单词，然后判断是否在禁用列表，如果不存在，就将其统计在map中，最后如果统计的字数超过了当前
     * 最大的count值，那么更新count值并更新res，res就是频率最高的单词。为了防止有单词被漏统计，在最开始paragraph的末尾添加上
     * 一个'.'标识结束符。
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph += '.';

        Map<String, Integer> map = new HashMap<>();

        String res = "";
        int count = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (c == ' ' || c == '!' || c == '?' || c == ',' || c == ';' || c == '.' || c == '\'') {
                String s = sb.toString();
                if (s.length() == 0)
                    continue;

                if (checkBanned(s, banned)){
                    sb = new StringBuilder();
                    continue;
                }

                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }

                if (map.get(s) > count) {
                    count = map.get(s);
                    res = s;
                }

                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }


        return res;

    }

    private boolean checkBanned(String str, String[] banned) {
        for (int i = 0; i < banned.length; i++) {
            if (str.equals(banned[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] b = {"hit"};
//        String[] b = {""};
//        String[] b = {"bot", "hit"};
//        String[] b = {"m", "q", "e", "l", "c", "i", "z", "j", "g", "t", "w", "v", "h", "p", "d", "b", "a", "r", "x", "n"};
        System.out.println(new _819_Most_Common_Word().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", b));
//        System.out.println(new _819_Most_Common_Word().mostCommonWord("Bob", b));
//        System.out.println(new _819_Most_Common_Word().mostCommonWord("Bob. hIt, baLl", b));
//        System.out.println(new _819_Most_Common_Word().mostCommonWord("j. t? T. z! R, v, F' x! L; l! W. M; S. y? r! n; O. q; I? h; w. t; y; X? y, p. k! k, h, J, r? w! U! V; j' u; R! z. s. T' k. P? M' I' j! y. P, T! e; X. w? M! Y, X; G; d, X? S' F, K? V, r' v, v, D, w, K! S? Q! N. n. V. v. t? t' x! u. j; m; n! F, V' Y! h; c! V, v, X' X' t? n; N' r; x. W' P? W; p' q, S' X, J; R. x; z; z! G, U; m. P; o. P! Y; I, I' l' J? h; Q; s? U, q, x. J, T! o. z, N, L; u, w! u, S. Y! V; S? y' E! O; p' X, w. p' M, h! R; t? K? Y' z? T? w; u. q' R, q, T. R? I. R! t, X, s? u; z. u, Y, n' U; m; p? g' P? y' v, o? K? R. Q? I! c, X, x. r' u! m' y. t. W; x! K? B. v; m, k; k' x; Z! U! p. U? Q, t, u' E' n? S' w. y; W, x? r. p! Y? q, Y. t, Z' V, S. q; W. Z, z? x! k, I. n; x? z; V? s! g, U; E' m! Z? y' x? V! t, F. Z? Y' S! z, Y' T? x? v? o! l; d; G' L. L, Z? q. w' r? U! E, H. C, Q! O? w! s? w' D. R, Y? u. w, N. Z? h. M? o, B, g, Z! t! l, W? z, o? z, q! O? u, N; o' o? V; S! z; q! q. o, t! q! w! Z? Z? w, F? O' N' U' p? r' J' L; S. M; g' V. i, P, v, v, f; W? L, y! i' z; L? w. v, s! P?"
//                , b));
    }
}
