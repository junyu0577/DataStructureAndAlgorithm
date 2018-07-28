package com.github.junyu.solution.data_structure.graph.weight;

import com.github.junyu.solution.data_structure.heap.MinHeap;
import com.github.junyu.solution.data_structure.union_find.UnionFind5;

import java.util.Vector;

/**
 * kruskal算法求最小生成树
 * 和prim算法一样同属于贪心算法
 * 时间复杂度O(ElogE)
 * @author ShaoJunyu
 * @since 2018/7/27 13:02
 */
public class KruskalMST<T extends Number & Comparable> {
    private Number weight;
    private Vector<Edge<T>> mst;

    public KruskalMST(WeightGraph graph) {
        mst = new Vector<>();

        //算法开始
        UnionFind5 unionFind = new UnionFind5(graph.count());//用来判断节点是否形成还
        MinHeap minHeap = new MinHeap(graph.edges());//存放所有的边
        for (int i = 0; i < graph.count(); i++) {
            for (Edge<T> e : graph.adj(i)) {
                if (e.getX() < e.getY())//由于是无向图，需要过滤重复的边
                    minHeap.insert(e);
            }
        }

        while (!minHeap.isEmpty() && mst.size() < graph.count() - 1) {
            Edge<T> e = (Edge<T>) minHeap.remove();
            if (unionFind.isConnected(e.getX(), e.getY()))
                continue;

            mst.add(e);
            unionFind.union(e.getX(), e.getY());
        }

        weight = mst.get(0).getWeight();
        for (int i = 1; i < mst.size(); i++) {
            weight = weight.doubleValue() + mst.get(i).getWeight().doubleValue();
        }
    }


    public Number getWeight() {
        return weight;
    }

    public Vector<Edge<T>> getEdges() {
        return mst;
    }
}
