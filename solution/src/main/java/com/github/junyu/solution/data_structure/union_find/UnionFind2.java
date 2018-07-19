package com.github.junyu.solution.data_structure.union_find;


/**
 * 并查集,每个元素存储parent的位置，
 * 提升union时的效率
 *
 * @author ShaoJunyu
 * @since 2018-07-19 20:17
 */
public class UnionFind2 {
    private int parents[];
    private int count;

    public UnionFind2(int size) {
        count = size;
        parents = new int[size];

        for (int i = 0; i < size; i++) {
            parents[i] = i;
        }
    }

    /**
     * 查看p元素对应的集合
     *
     * @param p
     * @return
     */
    public int find(int p) {
        if (p < 0 || p > count)
            throw new RuntimeException("IndexOutOfBoundsException");
        while (p != parents[p]) {
            p = parents[p];
        }
        return p;
    }

    /**
     * 查看p和q元素是否属于一个集合
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP==rootQ)
            return;
        parents[rootP] = rootQ;
    }
}
