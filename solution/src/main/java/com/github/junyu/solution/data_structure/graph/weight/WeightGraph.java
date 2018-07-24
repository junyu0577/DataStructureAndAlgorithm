package com.github.junyu.solution.data_structure.graph.weight;

/**
 * @author ShaoJunyu
 * @since 2018/7/23 08:09
 */
public interface WeightGraph {

    int edges();

    int count();

    void addEdge(Edge edge);

    boolean hasEdge(int x, int y);

    Iterable<Edge> adj(int x);

    void show();
}
