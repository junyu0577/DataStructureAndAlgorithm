package com.github.junyu.solution.data_structure.graph.weight;

import java.util.Stack;
import java.util.Vector;

/**
 * BellmanFord算法求单源最短路径
 * 解决带有负权边的图的问题
 * 前提是图中不能有负权环,通常处理的是有向图,对于无向图很有可能形成负权环
 * 时间复杂度O(EV)
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/28 14:14
 */
public class BellmanFord<T extends Number & Comparable> {

    private WeightGraph graph;
    private int source;//源 起始点
    private Number distTo[];//存放到达目标路径的权重
    private Edge<T> from[];//存放到达目标的边
    private boolean isNegativeCycle;//是否形成环

    public BellmanFord(WeightGraph graph, int s) {
        this.source = s;
        this.graph = graph;
        distTo = new Number[graph.count()];
        from = new Edge[graph.count()];

        distTo[source] = 0.0;

        from[source] = new Edge<>(source, source, (T) (Number) 0.0);

        for (int pass = 1; pass < graph.count(); pass++) {
            for (int i = 0; i < graph.count(); i++) {
                for (Edge<T> e : graph.adj(i)) {
                    if (from[e.getY()] == null || distTo[e.getX()].doubleValue() + e.getWeight().doubleValue() < distTo[e.getY()].doubleValue()) {
                        distTo[e.getY()] = distTo[e.getX()].doubleValue() + e.getWeight().doubleValue();
                        from[e.getY()] = e;
                    }
                }
            }
        }

        isNegativeCycle = detectNegativeCycle();
    }

    private boolean detectNegativeCycle() {
        for (int i = 0; i < graph.count(); i++) {
            for (Edge e : graph.adj(i)) {
                int j = e.other(i);
                if (from[j] == null || distTo[i].doubleValue() + e.getWeight().doubleValue() < distTo[j].doubleValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNegativeCycle() {
        return isNegativeCycle;
    }

    /**
     * 返回通向v的权重
     *
     * @param v
     * @return
     */
    public Number shortestPathTo(int v) {
        return distTo[v];
    }

    /**
     * 判断是否有通向v的路径
     *
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return from[v] != null;
    }

    /**
     * 打印去向v节点的最短路径
     *
     * @param v
     */
    public void showPath(int v) {
        if (!hasPathTo(v)) {
            throw new RuntimeException("There is no path to " + v);
        }
        Vector<Edge<T>> vector = shortestPath(v);
        System.out.print(source);
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(" -> " + vector.get(i).getY());
        }
    }

    private Vector<Edge<T>> shortestPath(int v) {
        Vector<Edge<T>> paths = new Vector<>();
        Stack<Edge<T>> stack = new Stack<>();
        Edge<T> e = from[v];
        while (e.getY() != e.getX()) {
            stack.push(e);
            e = from[e.getX()];
        }
        while (!stack.isEmpty()) {
            paths.add(stack.pop());
        }
        return paths;
    }

}
