package com.github.junyu.solution.data_structure.binary_search_tree.segment_tree;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/29 15:48
 */
public interface Merge<E> {
    E merge(E a, E b);
}
