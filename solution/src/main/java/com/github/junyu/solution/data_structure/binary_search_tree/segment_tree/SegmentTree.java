package com.github.junyu.solution.data_structure.binary_search_tree.segment_tree;


/**
 * 线段树
 * 将二叉树视为满二叉树，所以空间需要开辟4*arr.length
 * 查询操作时间复杂度O(logN)
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/29 15:24
 */
public class SegmentTree<E> {

    private E data[];
    private E tree[];
    private Merge<E> merge;

    public SegmentTree(E arr[], Merge<E> merge) {

        this.merge = merge;
        data = (E[]) new Object[arr.length];

        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];

        tree = (E[]) new Object[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int index, int l, int r) {

        if (l == r) {
            tree[index] = data[l];
            return;
        }

        int mid = (r - l) / 2 + l;

        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);
        buildSegmentTree(leftChildIndex, l, mid);
        buildSegmentTree(rightChildIndex, mid + 1, r);

        tree[index] = merge.merge(tree[leftChildIndex], tree[rightChildIndex]);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append(tree[i]);
                if (i != tree.length - 1) {
                    sb.append(",");
                }
            } else {
                sb.append("null");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return data.length;
    }

    /**
     * 查询left和right区间的内容
     *
     * @param left
     * @param right
     */
    public E query(int left, int right) {
        if (left < 0 || left >= data.length || right < 0 || right >= data.length || left > right)
            throw new IllegalArgumentException("left or right is illegal");

        return query(0, 0, data.length - 1, left, right);
    }

    private E query(int index, int l, int r, int ql, int qr) {
        if (l==ql && r == qr)
            return tree[index];

        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);

        int mid  = (r-l)/2+l;

        if (ql>=mid+1)//要查询的内容在右边
            return query(rightChildIndex,mid+1,r,ql,qr);
        else if (qr<=mid)//位于左边
            return query(leftChildIndex,l,mid,ql,qr);

        E leftRes = query(leftChildIndex,l,mid,ql,mid);//部分位于左边
        E rightRes = query(rightChildIndex,mid+1,r,mid+1,qr);//部分位于右边

        return merge.merge(leftRes,rightRes);

    }

    /**
     * 从树中获取index节点的左孩子
     *
     * @param index
     * @return
     */
    public int getLeftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 从树中获取index节点的右孩子
     *
     * @param index
     * @return
     */
    public int getRightChild(int index) {
        return index * 2 + 2;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }


    public static void main(String[] args) {
        Integer arr[] = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, new Merge<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree.toString());

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2,5));
        System.out.println(segmentTree.query(0,5));
    }
}


