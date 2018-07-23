package com.github.junyu.solution.data_structure.graph;

import java.util.Vector;

/**
 * 稀疏图-邻接表
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/21 20:47
 */
public class SparseGraph implements Graph{
    private int n;//节点数
    private int m; //边数
    private boolean directed;//是否具有方向

    private Vector<Integer>[] graph;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;

        graph = (Vector<Integer>[]) new Vector[n];
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

    public void addEdge(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            throw new RuntimeException("IndexOutOfBoundsException");
        }

        graph[x].add(y);
        if (!directed && x != y)//如果是自环边就不需要再添加
            graph[y].add(x);

        m++;
    }

    //验证是否含有从x到y的边
    public boolean hasEdge(int x, int y) {
        for (int i = 0; i < graph[x].size(); i++) {
            if (graph[x].elementAt(i) == y)
                return true;
        }
        return false;
    }

    /**
     * 返回图中x顶点所有的邻边
     *
     * @return
     */
    public Iterable<Integer> adj(int x) {
        return graph[x];
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":\t");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }
}
