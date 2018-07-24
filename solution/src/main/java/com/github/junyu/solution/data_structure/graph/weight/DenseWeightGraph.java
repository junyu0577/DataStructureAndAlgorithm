package com.github.junyu.solution.data_structure.graph.weight;


import java.util.Vector;

/**
 * 稠密图-邻接矩阵
 * 带权图
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/21 20:18
 */
public class DenseWeightGraph implements WeightGraph {
    private int n;//节点数
    private int m; //边数
    private boolean directed;//是否具有方向

    private Edge[][] graph;

    public DenseWeightGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;

        graph = new Edge[n][n];
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

        if (hasEdge(edge.getX(), edge.getY()))
            return;

        graph[edge.getX()][edge.getY()] = edge;
        if (edge.getX() != edge.getY() && !directed) {
            graph[edge.getY()][edge.getX()] = edge;
        }

        m++;
    }

    //验证是否含有从x到y的边
    public boolean hasEdge(int x, int y) {
        return graph[x][y] != null;
    }

    /**
     * 返回图中x顶点所有的邻边
     *
     * @return
     */
    public Iterable<Edge> adj(int x) {
        Vector<Edge> vector = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (graph[x][i] != null)
                vector.add(graph[x][i]);
        }
        return vector;
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
    }

}


