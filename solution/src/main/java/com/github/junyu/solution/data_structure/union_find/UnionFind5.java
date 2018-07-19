package com.github.junyu.solution.data_structure.union_find;

/**
 * 并查集,路径压缩，通过在find时压缩树的高度实现在效率上的提升
 *
 * @author ShaoJunyu
 */
public class UnionFind5 {
    private int parents[];
    private int ranks[];
    private int count;

    public UnionFind5(int size) {
        count = size;
        parents = new int[size];
        ranks = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
            ranks[i] = 1;
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
            parents[p] = parents[parents[p]];
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

        if (rootP == rootQ)
            return;

        if (ranks[rootP] > ranks[rootQ]) {
            parents[rootQ] = rootP;
        } else if (ranks[rootP] < ranks[rootQ]) {
            parents[rootP] = rootQ;
        } else {
            parents[rootP] = rootQ;
            ranks[rootQ]++;
        }


    }
}
