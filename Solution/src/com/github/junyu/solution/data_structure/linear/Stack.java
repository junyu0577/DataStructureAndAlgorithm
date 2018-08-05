package com.github.junyu.solution.data_structure.linear;

/**
 * @author ShaoJunyu
 * @since 2018/8/1 09:28
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E top();

    boolean isEmpty();

    int size();

    int getCapacity();

}
