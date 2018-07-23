package com.github.junyu.solution.data_structure.graph;


/**
 * DFS求连通分量
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/23 21:32
 */
public class Component {
    private int cCount;//连通数
    private Graph graph;
    private boolean[] visited;//记录已经访问过的节点
    private int ids[];//节点对应的连通分量

    public Component(Graph graph) {
        cCount = 0;
        this.graph = graph;
        visited = new boolean[graph.count()];
        ids = new int[graph.count()];
        for (int i = 0; i < graph.count(); i++) {
            visited[i] = false;
            ids[i] = -1;
        }
        for (int i = 0; i < graph.count(); i++) {
            if (!visited[i]) {
                dfs(i);
                cCount++;
            }
        }
    }

    /**
     * 深度优先遍历图
     *
     * @param v
     */
    private void dfs(int v) {
        ids[v] = cCount;
        visited[v] = true;

        for (int i : graph.adj(v)) {
            if (!visited[i])
                dfs(i);
        }
    }

    /**
     * 返回图的连通分量个数
     *
     * @return
     */
    public int count() {
        return cCount;
    }

    /**
     * 判断节点x和节点y是否连通
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isConnected(int x, int y) {
        if (x < 0 || x >= graph.count() || y < 0 || y >= graph.count()) {
            throw new RuntimeException("IndexOutOfBoundsException");
        }
        return ids[x] == ids[y];
    }
}
