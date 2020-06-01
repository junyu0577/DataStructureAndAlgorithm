package com.github.junyu.solution.leetCode.easy.design;

public class _705_Design_HashSet {

    /*Design a HashSet without using any built-in hash table libraries.

    To be specific, your design should include these functions:

    add(value): Insert a value into the HashSet.
    contains(value) : Return whether the value exists in the HashSet or not.
    remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

            Example:

    MyHashSet hashSet = new MyHashSet();
    hashSet.add(1);
    hashSet.add(2);
    hashSet.contains(1);    // returns true
    hashSet.contains(3);    // returns false (not found)
    hashSet.add(2);
    hashSet.contains(2);    // returns true
    hashSet.remove(2);
    hashSet.contains(2);    // returns false (already removed)

    Note:

    All values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashSet library.*/

    /**
     * 设计HashSet
     * 思路：类型设计HashMap,建立一个长度为1000001的数组，如果是插入操作，则将key对应索引位的元素改为1。
     * 如果移除则将该索引位的值变为0。
     * 判断是否存在则通过索引位的元素是否为0，为0则不存在。
     */
    static class MyHashSet {
        private int[] hash;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            hash = new int[1000001];
        }

        public void add(int key) {
            hash[key] = 1;
        }

        public void remove(int key) {
            hash[key] = 0;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return hash[key] != 0;
        }
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}
