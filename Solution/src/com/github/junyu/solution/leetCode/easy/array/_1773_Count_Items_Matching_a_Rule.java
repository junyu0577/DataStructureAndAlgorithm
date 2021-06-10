package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1773_Count_Items_Matching_a_Rule {

    /*
    You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of
     the ith item.
    You are also given a rule represented by two strings, ruleKey and ruleValue.

    The ith item is said to match the rule if one of the following is true:

    ruleKey == "type" and ruleValue == typei.
            ruleKey == "color" and ruleValue == colori.
            ruleKey == "name" and ruleValue == namei.
    Return the number of items that match the given rule.



    Example 1:

    Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey =
    "color",
    ruleValue = "silver"
    Output: 1
    Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
    Example 2:

    Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey =
    "type", ruleValue = "phone"
    Output: 2
    Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"]
    and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.


            Constraints:

            1 <= items.length <= 104
            1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
    ruleKey is equal to either "type", "color", or "name".
    All strings consist only of lowercase letters.
        */

    /**
     * 统计匹配检索规则的物品数量 items[i] = [typei, colori, namei]
     * 根据不同的key取对应索引位置的内容与value进行比较。
     *
     * Runtime: 4 ms, faster than 44.42% of Java online submissions for Count Items Matching a Rule.
     * Memory Usage: 43.7 MB, less than 58.57% of Java online submissions for Count Items Matching a Rule.
     *
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        for (int i = 0; i < items.size(); i++) {
            if ("type".equals(ruleKey) && items.get(i).get(0).equals(ruleValue)) {
                ans++;
            } else if ("color".equals(ruleKey)&& items.get(i).get(1).equals(ruleValue)) {
                ans++;
            } else if ("name".equals(ruleKey)&& items.get(i).get(2).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1773_Count_Items_Matching_a_Rule test = new _1773_Count_Items_Matching_a_Rule();
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("phone", "blue", "pixel"));
        list.add(Arrays.asList("computer", "silver", "lenovo"));
        list.add(Arrays.asList("phone", "gold", "iphone"));

        System.out.println(test.countMatches(list, "color", "silver"));

        List<List<String>> list2 = new ArrayList<>();
        list2.add(Arrays.asList("phone", "blue", "pixel"));
        list2.add(Arrays.asList("computer", "silver", "phone"));
        list2.add(Arrays.asList("phone", "gold", "iphone"));
        System.out.println(test.countMatches(list2, "type", "phone"));

    }
}
