package com.github.junyu.solution.data_structure.union_find;


/**
 * 并查集,基于size的优化，定义一个sizes数组，sizes[i]存放的是以i为根的元素的个数
 * 每次union前先判断一下哪边的层级少，然后将层级多的一方指向少的一方的根
 *
 * @author ShaoJunyu
 */
public class UnionFind3 {
    private int parents[];
    private int sizes[];
    private int count;

    public UnionFind3(int size) {
        count = size;
        parents = new int[size];
        sizes = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
            sizes[i] = 1;
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

        if (rootP == rootQ)
            return;

        if (sizes[rootP] > sizes[rootQ]) {
            parents[rootQ] = rootP;
            sizes[rootP] += sizes[rootQ];
        } else {
            parents[rootP] = rootQ;
            sizes[rootQ] += sizes[rootP];
        }


    }
}
