package com.github.junyu.solution.data_structure.graph.weight;

import com.github.junyu.solution.data_structure.heap.MinHeap;

import java.util.Vector;

/**
 * lazy prim算法求最小生成树
 * 切分定理：给定任意切边，横切边中权值最小的边必定属于最小生成树
 * 时间复杂度O(ElogE)
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/25 20:53
 */
public class LazyPrimMST<T extends Number & Comparable> {

    private WeightGraph graph;//图
    private MinHeap<Edge<T>> pq;//最小堆，存放处理到的和节点相连接的边
    private Number weight;//最小生成树的权重总值
    private boolean[] marked;//标记所有的节点，false为未加入的节点
    private Vector<Edge<T>> mst;

    public LazyPrimMST(WeightGraph graph) {
        this.graph = graph;
        pq = new MinHeap(graph.edges());
        marked = new boolean[graph.count()];
        mst = new Vector<>();

        //算法开始
        visit(0);
        while (!pq.isEmpty()){
            Edge<T> e =  pq.remove();
            if (marked[e.getY()] == marked[e.getX()])//两个节点都访问过
                continue;

            mst.add(e);

            if (!marked[e.getX()]){//通过新加入的节点找到新的边加入到最小堆
                visit(e.getX());
            } else {
                visit(e.getY());
            }

        }

        weight = mst.get(0).getWeight();
        for (int i=1;i<mst.size();i++){
            weight = weight.doubleValue()+mst.get(i).getWeight().doubleValue();
        }
    }

    private void visit(int i) {
        marked[i] = true;
        for (Edge<T> e : graph.adj(i)) {
            if (!marked[e.other(i)])
                pq.insert(e);

        }
    }

    /**
     * 获取最小生成树的权重总和
     *
     * @return
     */
    public Number getWeight() {
        return weight;
    }

    /**
     * 获取连接节点的边
     *
     * @return
     */
    public Vector<Edge<T>> getEdges() {
        return mst;
    }

}