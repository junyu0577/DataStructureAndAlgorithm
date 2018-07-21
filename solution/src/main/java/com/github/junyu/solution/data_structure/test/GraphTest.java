package com.github.junyu.solution.data_structure.test;

import com.github.junyu.solution.data_structure.graph.DenseGraph;
import com.github.junyu.solution.data_structure.graph.SparseGraph;

import java.util.Iterator;

/**
 * 用于测试图的正确性
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/21 20:34
 */
public class GraphTest {

    public static void main(String[] args) {
        int N = 10;
        int M = 10;
        testDenseGraph(N,M);
//        testSparseGraph(N, M);

    }

    private static void testSparseGraph(int n, int m) {
        SparseGraph sparseGraph = new SparseGraph(n, false);

        for (int i = 0; i < m; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            sparseGraph.addEdge(a, b);
        }
        loop(sparseGraph, n);
        System.out.println("edges:" + sparseGraph.edges());
    }

    private static void loop(SparseGraph sparseGraph, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":");
            Iterator<Integer> graph = sparseGraph.adj(i).iterator();
            while (graph.hasNext()) {
                System.out.print(" " + graph.next());
            }
            System.out.println();
        }
    }

    private static void testDenseGraph(int n,int m) {
        DenseGraph denseGraph = new DenseGraph(n, false);
        for (int i = 0; i < m; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            denseGraph.addEdge(a, b);
        }
        loop(denseGraph, n);
    }

    private static void loop(DenseGraph denseGraph, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":");
            Iterator<Integer> graph = denseGraph.adj(i).iterator();
            while (graph.hasNext()) {
                System.out.print(" " + graph.next());
            }
            System.out.println();
        }
    }
}
