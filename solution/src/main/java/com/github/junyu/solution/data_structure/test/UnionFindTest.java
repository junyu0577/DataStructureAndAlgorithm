package com.github.junyu.solution.data_structure.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 用于测试并查集的效率
 *
 * @author ShaoJunyu
 * @since 2018/7/19 08:12
 */
public class UnionFindTest {

    public static final String PACKAGENAME = "com.github.junyu.solution.data_structure.union_find.";

    /**
     * 利用反射调用待测试的并查集类，并统计消耗的时长
     *
     * @param className 类名
     */
    private static void testUnionFind(String className, int n) {
        try {
            Class ufClass = Class.forName(className);

            Constructor cons = ufClass.getConstructor(new Class[]{int.class});

            Object ufObject = cons.newInstance(n);

            Method unionMethod = ufClass.getMethod("union", new Class[]{int.class, int.class});
            Method isConnectedMethod = ufClass.getMethod("isConnected", new Class[]{int.class, int.class});


            long startTime = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                int a = (int) (Math.random() * n);
                int b = (int) (Math.random() * n);
                unionMethod.invoke(ufObject, new Object[]{a, b});
            }

            for (int i = 0; i < n; i++) {
                int a = (int) (Math.random() * n);
                int b = (int) (Math.random() * n);
                isConnectedMethod.invoke(ufObject, new Object[]{a, b});
            }

            long endTime = System.currentTimeMillis();

            String ufName = ufClass.getSimpleName();


            System.out.println(ufName + " : " + (double) (endTime - startTime) / 1000 + "s");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int N = 100000;
        testUnionFind(PACKAGENAME + "UnionFind",  N );
        testUnionFind(PACKAGENAME + "UnionFind2",  N );
    }
}
