package com.github.junyu.solution.data_structure.graph.weight;

/**
 * 边
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/24 20:39
 */
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {

    private int x, y;//两个相连的节点
    private Weight weight;//边的权重

    public Edge(int x, int y, Weight weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    /**
     * 返回第一个节点
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * 返回第二个节点
     *
     * @return
     */
    public int getY() {
        return y;
    }

    public Weight getWeight() {
        return weight;
    }

    public int other(int a) {
        if (a != x && a != y) {
            throw new RuntimeException("illegal vertex");
        }
        return a == x ? y : x;
    }

    public String toString() {
        return "" + weight;
    }

    @Override
    public int compareTo(Edge edge) {
        if (weight.compareTo(edge.getWeight()) < 0)
            return -1;
        else if (weight.compareTo(edge.getWeight()) > 0)
            return 1;
        return 0;
    }
}
