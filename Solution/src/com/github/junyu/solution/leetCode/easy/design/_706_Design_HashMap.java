package com.github.junyu.solution.leetCode.easy.design;

public class _706_Design_HashMap {

    /*Design a HashMap without using any built-in hash table libraries.

    To be specific, your design should include these functions:

    put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
    get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

    Example:

    MyHashMap hashMap = new MyHashMap();
    hashMap.put(1, 1);
    hashMap.put(2, 2);
    hashMap.get(1);            // returns 1
    hashMap.get(3);            // returns -1 (not found)
    hashMap.put(2, 1);          // update the existing value
    hashMap.get(2);            // returns 1
    hashMap.remove(2);          // remove the mapping for 2
    hashMap.get(2);            // returns -1 (not found)

    Note:

    All keys and values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashMap library.*/

    /**
     * 设计HashMap
     * 思路：由于key和value的范围从0-1000000，那么可以定义一个长度为1000001的数组，初始时内容均为0，put进来的元素，按key插入指定
     * 索引位，并且将value+1进行存储，这样每次get出来的元素如果为0，说明是不存在的元素，因为存的value值最小为1，否则返回的value需要减去1。
     */
    static class  MyHashMap {

        private int [] hash;

        /** Initialize your data structure here. */
        public MyHashMap() {
            hash = new int[1000001];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            hash[key] = value+1;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return hash[key]==0?-1:hash[key]-1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            hash[key] = 0;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));;            // returns 1
        System.out.println(myHashMap.get(3));;            // returns -1 (not found)
        myHashMap.put(2, 1);          // update the existing value
        System.out.println(myHashMap.get(2));;            // returns 1
        myHashMap.remove(2);          // remove the mapping for 2
        System.out.println( myHashMap.get(2));            // returns -1 (not found)
    }

}
