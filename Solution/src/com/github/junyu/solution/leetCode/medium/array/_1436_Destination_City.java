package com.github.junyu.solution.leetCode.medium.array;

import java.util.*;

public class _1436_Destination_City {

   /* You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from
   cityAi to cityBi.
    Return the destination city, that is, the city without any path outgoing to another city.
    It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one
    destination city.

    Example 1:

    Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
    Output: "Sao Paulo"
    Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
    Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
    Example 2:

    Input: paths = [["B","C"],["D","B"],["C","A"]]
    Output: "A"
    Explanation: All possible trips are:
            "D" -> "B" -> "C" -> "A".
            "B" -> "C" -> "A".
            "C" -> "A".
            "A".
    Clearly the destination city is "A".
    Example 3:

    Input: paths = [["A","Z"]]
    Output: "Z"


    Constraints:

            1 <= paths.length <= 100
    paths[i].length == 2
            1 <= cityAi.length, cityBi.length <= 10
    cityAi != cityBi
    All strings consist of lowercase and uppercase English letters and the space character.*/

    /**
     * 找到目的地城市
     * 我的思路是定义start和end两个集合分别存储cityAi，和cityBi，并且边存边去找到一个起点，这个起点不一定是
     * 最初的起点，可能是末尾的起点，也可能是中部的某一个起点，总之，只要找到一个起点，我们就需要在去存start和end，
     * 以及进行起点的判断。
     * 起点的判断是通过利用paths[i]中的元素cityAi和cityBi，如果cityAi在end集合中已经出现或者cityBi在start集合
     * 中已经出现，说明已经形成了连接路径。我们就可以将当前paths[i]中的cityBi直接做为起点。
     * 在遍历的过程中，将cityAi和cityBi以键值对的形式存在map中，这样就可以通过之前找到的起点，在这个map中进行键值对的
     * 反复查找，直接获取的value为空时，当前的key就是目的地。
     *
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        String startPlace = null;

        for (int i = 0; i < paths.size(); i++) {

            if (startPlace == null) {
                if (start.contains(paths.get(i).get(1))) {
                    startPlace = paths.get(i).get(1);
                } else if (end.contains(paths.get(i).get(0))) {
                    startPlace = paths.get(i).get(1);
                }
                start.add(paths.get(i).get(0));
                end.add(paths.get(i).get(1));
            }

            map.put(paths.get(i).get(0), paths.get(i).get(1));
        }
        while (map.get(startPlace) != null) {
            startPlace = map.get(startPlace);
        }

        return startPlace == null ? paths.get(0).get(1) : startPlace;

    }


    private List<List<String>> array2List(String arr[][]) {
        List<List<String>> result = new ArrayList<>();

        for (String[] subArr : arr) {
            result.add(Arrays.asList(subArr));
        }

        return result;
    }

    public static void main(String[] args) {
        _1436_Destination_City test = new _1436_Destination_City();

        System.out.println(test.destCity(test.array2List(new String[][]{{"London", "New York"}, {"New York", "Lima"},
                {"Lima", "Sao Paulo"}})));

        System.out.println(test.destCity(test.array2List(new String[][]{{"B", "C"}, {"D", "B"}, {"C", "A"}})));
        System.out.println(test.destCity(test.array2List(new String[][]{{"a", "b"}, {"b", "c"}})));
        System.out.println(test.destCity(test.array2List(new String[][]{{"b", "c"}, {"a", "b"}})));
    }
}
