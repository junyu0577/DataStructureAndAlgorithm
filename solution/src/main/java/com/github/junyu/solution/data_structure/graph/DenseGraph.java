package com.github.junyu.solution.data_structure.graph;


import java.util.Vector;

/**
 * 稠密图-邻接矩阵
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/21 20:18
 */
public class DenseGraph {
    private int n;//节点数
    private int m; //边数
    private boolean directed;//是否具有方向

    private boolean[][] graph;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;

        graph = new boolean[n][n];
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

    public void addEdge(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            throw new RuntimeException("IndexOutOfBoundsException");
        }

        if (hasEdge(x, y))
            return;

        graph[x][y] = true;
        if (!directed) {
            graph[y][x] = true;
        }

        m++;
    }

    //验证是否含有从x到y的边
    private boolean hasEdge(int x, int y) {
        return graph[x][y];
    }

    /**
     * 返回图中x顶点所有的邻边
     * @return
     */
    public Iterable<Integer> adj(int x){
        Vector<Integer> vector = new Vector<>();
        for (int i=0;i<n;i++){
            if (graph[x][i])
                vector.add(i);
        }
        return vector;
    }

}


