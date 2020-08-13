package com.github.junyu.solution.leetCode.medium.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _841_Keys_and_Rooms {

    /*There are N rooms and you start in room 0.  Each room has a distinct
    number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

    Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is
    an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

    Initially, all the rooms start locked (except for room 0).

    You can walk back and forth between rooms freely.

    Return true if and only if you can enter every room.

    Example 1:

    Input: [[1],[2],[3],[]]
    Output: true
    Explanation:
    We start in room 0, and pick up key 1.
    We then go to room 1, and pick up key 2.
    We then go to room 2, and pick up key 3.
    We then go to room 3.  Since we were able to go to every room, we return true.
    Example 2:

    Input: [[1,3],[3,0,1],[2],[0]]
    Output: false
    Explanation: We can't enter the room with number 2.
    Note:

            1 <= rooms.length <= 1000
            0 <= rooms[i].length <= 1000
    The number of keys in all rooms combined is at most 3000.*/

    private boolean[] visited;

    /**
     * 是否能到达所有的房间
     * 思路：起点是第一扇门，采用深度遍历从0的索引位开始遍历，并定义visited数组记录是否访问过房间，如果当前要访问的房间已经被访问则不再访问。
     * 最后在判断visited数组是否都为true，如果其中存在一个元素值为false，说明不能到达所有的房间。
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(0, rooms);
        for (boolean visit : visited) {
            if (!visit)
                return false;
        }
        return true;
    }

    private void dfs(int i, List<List<Integer>> rooms) {
        visited[i] = true;
        List<Integer> room = rooms.get(i);
        for (int j = 0; j < room.size(); j++) {
            if (!visited[room.get(j)]){
                dfs(room.get(j),rooms);
            }
        }
    }

    public static void main(String[] args) {
        _841_Keys_and_Rooms test = new _841_Keys_and_Rooms();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(1));
        list.add(Collections.singletonList(2));
        list.add(Collections.singletonList(3));
        list.add(new ArrayList<>());
        System.out.println(test.canVisitAllRooms(list));;

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(1, 3));
        list2.add(Arrays.asList(3, 0, 1));
        list2.add(Collections.singletonList(2));
        list2.add(Collections.singletonList(0));
        System.out.println(test.canVisitAllRooms(list2));;
    }
}
