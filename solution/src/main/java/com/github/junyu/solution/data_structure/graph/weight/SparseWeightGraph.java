package com.github.junyu.solution.data_structure.graph.weight;


import java.util.Vector;

/**
 * 稀疏图-邻接表
 * 带权图
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/21 20:47
 */
public class SparseWeightGraph implements WeightGraph {
    private int n;//节点数
    private int m; //边数
    private boolean directed;//是否具有方向

    private Vector<Edge>[] graph;

    public SparseWeightGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;

        graph = (Vector<Edge>[]) new Vector[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Vector<>();
        }
    }

    /**
     * 返回边的个数
     *
     * @return
     */
    public int edges() {
        return m;
    }

    /**
     * 返回节点的个数
     *
     * @return
     */
    public int count() {
        return n;
    }

    public void addEdge(Edge edge) {
        if (edge.getX() < 0 || edge.getX() >= n || edge.getY() < 0 || edge.getX() >= n) {
            throw new RuntimeException("IndexOutOfBoundsException");
        }

        graph[edge.getX()].add(edge);
        if (!directed && edge.getX() != edge.getY())//如果是自环边就不需要再添加
            graph[edge.getY()].add(edge);

        m++;
    }

    //验证是否含有从x到y的边
    public boolean hasEdge(int x, int y) {
        for (int i = 0; i < graph[x].size(); i++) {
            Edge e = graph[x].elementAt(i);
            if (e.other(x) == y)
                return true;
        }
        return false;
    }

    /**
     * 返回图中x顶点所有的邻边
     *
     * @return
     */
    public Iterable<Edge> adj(int x) {
        return graph[x];
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":\t");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print("to:" + graph[i].elementAt(j).other(i) + " weight:" + graph[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }
}
