package com.github.junyu.solution.data_structure.union_find;


/**
 * 并查集
 *
 * @author ShaoJunyu
 * @since 2018/7/19 07:57
 */
public class UnionFind {
    private int ids[];
    private int count;

    public UnionFind(int size) {
        count = size;
        ids = new int[size];

        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    /**
     * 查看p元素对应的集合
     * @param p
     * @return
     */
    public int find(int p) {
        if (p < 0 || p > count)
            throw new RuntimeException("IndexOutOfBoundsException");
        return ids[p];
    }

    /**
     * 查看p和q元素是否属于一个集合
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return;

        for (int i = 0; i < count; i++) {
            if (pId == ids[i]) {
                ids[i] = qId;
            }
        }
    }
}
