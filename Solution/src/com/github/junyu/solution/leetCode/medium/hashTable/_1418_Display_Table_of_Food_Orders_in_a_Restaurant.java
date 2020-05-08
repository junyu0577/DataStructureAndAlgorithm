package com.github.junyu.solution.leetCode.medium.hashTable;

import java.util.*;

public class _1418_Display_Table_of_Food_Orders_in_a_Restaurant {

   /* Given the array orders, which represents the orders that customers have done in a restaurant. More specifically
   orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the name of the customer, tableNumberi is the
   table customer sit at, and foodItemi is the item customer orders.

    Return the restaurant's “display table”. The “display table” is a table whose row entries denote how many of each
     food
    item each table ordered. The first column is the table number and the remaining columns correspond to each food
    item in
    alphabetical order. The first row should be a header whose first column is “Table”, followed by the names of the
    food items.
     Note that the customer names are not part of the table. Additionally, the rows should be sorted in numerically
     increasing order.

    Example 1:

    Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla",
    "5","Water"],
    ["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
    Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],
    ["10","1","0","0","0"]]
    Explanation:
    The displaying table looks like:
      Table,Beef Burrito,Ceviche,   Fried Chicken,Water
        3    ,0           ,2        ,1            ,0
        5    ,0           ,1        ,0            ,1
        10   ,1           ,0        ,0            ,0
    For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "Ceviche".
    For the table 5: Carla orders "Water" and "Ceviche".
    For the table 10: Corina orders "Beef Burrito".
    Example 2:

    Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],
    ["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
    Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
    Explanation:
    For the table 1: Adam and Brianna order "Canadian Waffles".
    For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
    Example 3:

    Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
    Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]


    Constraints:

    1 <= orders.length <= 5 * 10^4
    orders[i].length == 3
    1 <= customerNamei.length, foodItemi.length <= 20
    customerNamei and foodItemi consist of lowercase and uppercase English letters and the space character.
    tableNumberi is a valid integer between 1 and 500.*/

    /**
     * 生成菜单 利用hashSet元素的唯一性首先得到所有的桌号以及食物，然后定义一个map，通过桌号（key）获取这个桌所点过的所有食物的数量Map<String,Integer>，
     * 通过遍历给定的菜单list将数据封装进我们的menuMap，由于食物以及桌号讲究字典序，我们需要一个list将原来set中的元素进行一次排序。
     * 最后就可以通过遍历桌号的list，根据桌号查找所点的食物的数量
     *
     * @param orders
     * @return
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodSet = new HashSet<>();
        Set<Integer> tableSet = new HashSet<>();
        Map<String, Map<String, Integer>> menuMap = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            String table = orders.get(i).get(1);
            String food = orders.get(i).get(2);
            tableSet.add(Integer.parseInt(table));
            foodSet.add(food);
            if (menuMap.get(table) == null) {
                Map<String, Integer> addNew = new HashMap<>();
                addNew.put(food, 1);
                menuMap.put(table, addNew);
            } else {
                Map<String, Integer> recordMap = menuMap.get(table);
                recordMap.merge(food, 1, Integer::sum);

                menuMap.put(table, recordMap);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");

        List<String> foodList = new ArrayList<>();
        List<Integer> tableList = new ArrayList<>();
        foodList.addAll(foodSet);
        Collections.sort(foodList);
        firstRow.addAll(foodList);
        ans.add(firstRow);

        tableList.addAll(tableSet);
        Collections.sort(tableList);

        for (int i = 0; i < tableList.size(); i++) {
            List<String> rowList = new ArrayList<>();
            String tableNum = String.valueOf(tableList.get(i));
            rowList.add(tableNum);
            Map<String, Integer> tableMenu = menuMap.get(tableNum);
            for (int j = 0; j < foodList.size(); j++) {
                if (tableMenu.get(foodList.get(j)) == null) {
                    rowList.add("0");
                } else {
                    rowList.add(String.valueOf(tableMenu.get(foodList.get(j))));
                }
            }
            ans.add(rowList);
        }

        return ans;

    }
//    Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
//    Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]

    public static void main(String[] args) {
        _1418_Display_Table_of_Food_Orders_in_a_Restaurant test =
                new _1418_Display_Table_of_Food_Orders_in_a_Restaurant();
        System.out.println(test.displayTable(test.array2List(new String[][]{{"David", "3", "Ceviche"}, {"Corina", "10"
                , "Beef Burrito"}, {"David", "3", "Fried Chicken"}, {"Carla", "5", "Water"},
                {"Carla", "5", "Ceviche"}, {"Rous", "3", "Ceviche"}})));

        System.out.println(test.displayTable(test.array2List(new String[][]{{"Laura", "2", "Bean Burrito"}, {"Jhon",
                "2", "Beef Burrito"}, {"Melissa", "2", "Soda"}})));
    }

    private List<List<String>> array2List(String arr[][]) {
        List<List<String>> result = new ArrayList<>();

        for (String[] subArr : arr) {
            result.add(Arrays.asList(subArr));
        }

        return result;
    }
}
