package com.github.junyu.solution.data_structure.test;

import com.github.junyu.solution.data_structure.graph.DenseGraph;
import com.github.junyu.solution.data_structure.graph.SparseGraph;

import java.util.Vector;

/**
 * 用于测试图的正确性
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/21 20:34
 */
public class GraphTest {

    public static void main(String[] args) {
        int N = 2;
//        testDenseGraph(N);
        testSparseGraph(N);

    }

    private static void testSparseGraph(int n) {
        SparseGraph sparseGraph = new SparseGraph(n, false);
        loop(sparseGraph, n);
        sparseGraph.addEdge(0,1);
        System.out.println("---------");
        loop(sparseGraph, n);
        System.out.println("edges:"+sparseGraph.edges());
    }

    private static void loop(SparseGraph denseGraph, int n) {
        Vector<Integer>[] graph = denseGraph.getGraph();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.println(i + " " + graph[i].elementAt(j));
            }
        }
    }

    private static void testDenseGraph(int n) {
        DenseGraph denseGraph = new DenseGraph(n, false);
        loop(denseGraph, n);
        denseGraph.addEdge(1, 0);
        System.out.println("---------");
        loop(denseGraph, n);
    }

    private static void loop(DenseGraph denseGraph, int n) {
        boolean graph[][] = denseGraph.getGraph();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j + " " + graph[i][j]);
            }
        }
    }
}
