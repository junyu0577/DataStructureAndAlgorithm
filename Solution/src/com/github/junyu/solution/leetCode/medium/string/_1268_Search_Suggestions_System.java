package com.github.junyu.solution.leetCode.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1268_Search_Suggestions_System {

    /*Given an array of strings products and a string searchWord. We want to design a system that suggests
    at most three product names from products after each character of searchWord is typed. Suggested
    products should have common prefix with the searchWord. If there are more than three products with a
    common prefix return the three lexicographically minimums products.

    Return list of lists of the suggested products after each character of searchWord is typed.

    Example 1:

    Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
    Output: [
            ["mobile","moneypot","monitor"],
            ["mobile","moneypot","monitor"],
            ["mouse","mousepad"],
            ["mouse","mousepad"],
            ["mouse","mousepad"]
            ]
    Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
    After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
    After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
    Example 2:

    Input: products = ["havana"], searchWord = "havana"
    Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
    Example 3:

    Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
    Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
    Example 4:

    Input: products = ["havana"], searchWord = "tatiana"
    Output: [[],[],[],[],[],[],[]]


    Constraints:

            1 <= products.length <= 1000
    There are no repeated elements in products.
1 <= Σ products[i].length <= 2 * 10^4
    All characters of products[i] are lower-case English letters.
            1 <= searchWord.length <= 1000
    All characters of searchWord are lower-case English letters.
*/

    /**
     * 搜索推荐系统,超过三个按字典序返回最小的三个
     * 思路：对产品数组先进行按字典序排序，然后逐字累加searchWord去匹配产品数组。
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int len = searchWord.length();
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= len; i++) {
            String prefix = searchWord.substring(0,i);
            List<String> list = new ArrayList<>();
            for (String s : products) {
                if (s.startsWith(prefix)){
                    list.add(s);
                    if (list.size()==3)
                        break;
                }

            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        _1268_Search_Suggestions_System test = new _1268_Search_Suggestions_System();
        System.out.println(test.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"},
                "mouse"));
        System.out.println(test.suggestedProducts(new String[]{"havana"}, "havana"));
        System.out.println(test.suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
        System.out.println(test.suggestedProducts(new String[]{"havana"}, "tatiana"));
    }
}
