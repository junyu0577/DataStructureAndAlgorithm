package com.github.junyu.solution.data_structure.graph.weight;

import com.github.junyu.solution.data_structure.heap.MinHeap;
import com.github.junyu.solution.data_structure.heap.MinIndexHeap2;

import java.util.Vector;

/**
 * Prim算法求最小生成树
 * 在Lazy Prim算法的基础上进行优化，使用最小索引堆替代最小堆，堆只开辟了节点数空间
 * 时间复杂度O(ElogV)
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/25 20:53
 */
public class PrimMST<T extends Number & Comparable> {

    private WeightGraph graph;//图
    private MinIndexHeap2<T> pq;//存放可选的横切边的权值
    private Number weight;//最小生成树的权重总值
    private boolean[] marked;//标记所有的节点，false为未加入的节点
    private Vector<Edge<T>> mst;
    private Edge<T>[] edgeTo;//存放最短的横切边

    public PrimMST(WeightGraph graph) {
        this.graph = graph;
        pq = new MinIndexHeap2(graph.count());
        marked = new boolean[graph.count()];
        mst = new Vector<>();

        edgeTo = new Edge[graph.count()];

        //算法开始
        visit(0);
        while (!pq.isEmpty()){
           int i = pq.removeIndex();
           Edge e = edgeTo[i];
           mst.add(e);
           visit(i);
        }

        weight = mst.get(0).getWeight();
        for (int i = 1; i < mst.size(); i++) {
            weight = weight.doubleValue() + mst.get(i).getWeight().doubleValue();
        }
    }

    private void visit(int i) {
        marked[i] = true;
        for (Edge e : graph.adj(i)) {
            int j = e.other(i);
            if (!marked[j]){
                if (edgeTo[j]==null){
                    edgeTo[j] = e;
                    pq.insert(j,(T)e.getWeight());
                } else if (edgeTo[j].getWeight().compareTo(e.getWeight())>0){
                    edgeTo[j] = e;
                    pq.changeItem(j,(T)e.getWeight());
                }
            }
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