package com.github.junyu.solution.data_structure.graph.weight;


import com.github.junyu.solution.data_structure.heap.MinIndexHeap2;

import java.util.Stack;
import java.util.Vector;

/**
 * dijkstra 单源最短路径算法
 * 前提图中不能有负权边
 * 时间复杂度O(ElogV)
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/28 09:28
 */
public class Dijkstra<T extends Number & Comparable> {
    private int source;//源 起始位置

    private boolean marked[];//存放是否有到达目标路径的标记
    private Number distTo[];//存放到达目标路径的权重
    private Edge<T> from[];//存放到达目标的边

    public Dijkstra(WeightGraph graph, int s) {
        this.source = s;

        marked = new boolean[graph.count()];
        distTo = new Number[graph.count()];
        from = new Edge[graph.count()];

        for (int i = 0; i < graph.count(); i++) {
            distTo[i] = 0.0;
        }

        from[source] = new Edge<>(source,source,(T) (Number)0.0);
        MinIndexHeap2 ipg = new MinIndexHeap2(graph.count());
        ipg.insert(source,(T)distTo[source]);

        //松弛操作
        while (!ipg.isEmpty()){
            int i = ipg.removeIndex();
            marked[i] = true;

            for (Edge e : graph.adj(i)){
                int j = e.other(i);
                if (!marked[j]){
                    if (from[j] == null || distTo[i].doubleValue()+e.getWeight().doubleValue()<distTo[j].doubleValue()){
                        distTo[j] = distTo[i].doubleValue()+e.getWeight().doubleValue();//达到目标的路径为空或者有更短的就替换
                        from[j] = e;
                    }

                    if (ipg.contain(j)){//如果已经包含则更新
                        ipg.changeItem(j,(T)distTo[j]);
                    } else {
                        ipg.insert(j,(T)distTo[j]);
                    }
                }
            }
        }

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
        return marked[v];
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
