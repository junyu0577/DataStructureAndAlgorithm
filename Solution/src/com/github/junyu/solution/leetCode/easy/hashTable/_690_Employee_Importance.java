package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.*;

public class _690_Employee_Importance {

   /* You are given a data structure of employee information, which includes
    the employee's unique id, his importance value and his direct subordinates' id.

    For example, employee 1 is the leader of employee 2, and employee 2 is
    the leader of employee 3. They have importance value 15, 10 and 5, respectively.
    Then employee 1 has a data structure like [1, 15, [2]], and employee 2
    has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is
    also a subordinate of employee 1, the relationship is not direct.

    Now given the employee information of a company, and an employee id, you need
        to return the total importance value of this employee and all his subordinates.

            Example 1:
    Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
    Output: 11
    Explanation:
    Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
    They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
    Note:
    One employee has at most one direct leader and may have several subordinates.
    The maximum number of employees won't exceed 2000.*/

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    /**
     * solution1
     * 统一指定id的员工及其所有下属员工的总重要值
     * 使用hashMap先将所有的员工对象存储起来，根据id进行索引。然后先从map中获取指定id的员工对象，累加他的重要值，并将他的下属集合
     * 添加进队列。最后遍历队列，每次从队列中移除一个员工，并累加他的重要值，如果他也有下属，就再添加进队列。
     *
     * @param employees
     * @param id
     * @return
     */
//    public int getImportance(List<Employee> employees, int id) {
//        Map<Integer, Employee> map = new HashMap<>();
//        for (int i = 0; i < employees.size(); i++) {
//            map.put(employees.get(i).id, employees.get(i));
//        }
//
//        int res = map.get(id).importance;
//        Queue<Integer> subordinates = new LinkedList<>();
//        subordinates.addAll(map.get(id).subordinates);
//        while (subordinates.size() > 0) {
//            int curId = subordinates.poll();
//            Employee employee  =  map.get(curId);
//            res += employee.importance;
//            if (employee.subordinates.size()>0)
//                subordinates.addAll(employee.subordinates);
//        }
//
//        return res;
//
//    }

    /**
     *  solution2
     *  同solution1，利用递归dfs免去了开辟额外空间。
     *
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }

        return dfs(map, id);

    }

    private int dfs(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int res = employee.importance;
        for (Integer i : employee.subordinates) {
            res += dfs(map,i);
        }

        return res;

    }

    public static void main(String[] args) {

    }

}
