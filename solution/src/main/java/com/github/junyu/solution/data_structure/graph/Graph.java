package com.github.junyu.solution.data_structure.graph;

/**
 * @author ShaoJunyu
 * @since 2018/7/23 08:09
 */
public interface Graph {

    int edges();

    int count();

    void addEdge(int x, int y);

    boolean hasEdge(int x, int y);

    Iterable<Integer> adj(int x);

    void show();
}
