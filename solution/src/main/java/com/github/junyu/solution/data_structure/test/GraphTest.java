package com.github.junyu.solution.data_structure.test;

import com.github.junyu.solution.data_structure.graph.DenseGraph;
import com.github.junyu.solution.data_structure.graph.ReadGraph;
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
//        testDenseGraph(N,M);
//        testSparseGraph(N, M);

        String filename = gePath("testG1.txt");
        System.out.println();

        System.out.println("denseGraph:");
        DenseGraph denseGraph = new DenseGraph(13, false);
        ReadGraph.readGraph(denseGraph, filename);
        denseGraph.show();

        System.out.println();

        System.out.println("denseGraph:");
        SparseGraph sparseGraph = new SparseGraph(13, false);
        ReadGraph.readGraph(sparseGraph, filename);
        sparseGraph.show();


    }

    private static String gePath(String fileName) {
        String mainPath = Class.class.getClass().getResource("/").getPath();
        mainPath = mainPath.substring(0, mainPath.indexOf("/build"));
        mainPath = mainPath + "/src/main/java/com/github/junyu/solution/data_structure/graph/data/" + fileName;
        return mainPath;
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
        sparseGraph.show();
    }

    private static void loop(SparseGraph sparseGraph, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":" + "\t");
            Iterator<Integer> graph = sparseGraph.adj(i).iterator();
            while (graph.hasNext()) {
                System.out.print(graph.next() + "\t");
            }
            System.out.println();
        }
    }

    private static void testDenseGraph(int n, int m) {
        DenseGraph denseGraph = new DenseGraph(n, false);
        for (int i = 0; i < m; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            denseGraph.addEdge(a, b);
        }
        loop(denseGraph, n);
        denseGraph.show();
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
