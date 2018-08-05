package com.github.junyu.solution.data_structure.test;

import com.github.junyu.solution.data_structure.graph.Component;
import com.github.junyu.solution.data_structure.graph.DenseGraph;
import com.github.junyu.solution.data_structure.graph.ReadGraph;
import com.github.junyu.solution.data_structure.graph.SparseGraph;
import com.github.junyu.solution.data_structure.graph.weight.BellmanFord;
import com.github.junyu.solution.data_structure.graph.weight.DenseWeightGraph;
import com.github.junyu.solution.data_structure.graph.weight.Dijkstra;
import com.github.junyu.solution.data_structure.graph.weight.Edge;
import com.github.junyu.solution.data_structure.graph.weight.KruskalMST;
import com.github.junyu.solution.data_structure.graph.weight.LazyPrimMST;
import com.github.junyu.solution.data_structure.graph.weight.PrimMST;
import com.github.junyu.solution.data_structure.graph.weight.SparseWeightGraph;

import java.util.Iterator;
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
        int N = 10;
        int M = 10;
//        testDenseGraph(N,M);
//        testSparseGraph(N, M);

//        testNonWeightGraph();

//        testWeightGraph();

//        testMST();

//        testShortPath();

        testBellmanFord();
    }

    private static void testBellmanFord() {
        String filename = gePath("testG5.txt");

        System.out.println("BellmanFord:");
        SparseWeightGraph sparseWeightGraph = new SparseWeightGraph(5, true);
        ReadGraph.readWeightGraph(sparseWeightGraph, filename);
        BellmanFord bellmanFord = new BellmanFord(sparseWeightGraph,0);
        if (bellmanFord.isNegativeCycle()){
            System.out.println("the graph contain negative cycle.");
            return;
        }
        for (int i=1;i<sparseWeightGraph.count();i++){
            System.out.println("to " + i + " the shortest path is "+ bellmanFord.shortestPathTo(i));
            bellmanFord.showPath(i);
            System.out.println();
        }
    }

    private static void testShortPath() {
        String filename = gePath("testG4.txt");

        System.out.println("Dijkstra:");
        SparseWeightGraph sparseWeightGraph = new SparseWeightGraph(5, true);
        ReadGraph.readWeightGraph(sparseWeightGraph, filename);
        Dijkstra dijkstra = new Dijkstra(sparseWeightGraph,0);
        for (int i=1;i<sparseWeightGraph.count();i++){
            System.out.println("to " + i + " the shortest path is "+ dijkstra.shortestPathTo(i));
            dijkstra.showPath(i);
            System.out.println();
        }

    }

    private static void testMST() {
        String filename = gePath("testG3.txt");

        System.out.println("LazyPrim:");
        SparseWeightGraph sparseWeightGraph = new SparseWeightGraph(8, false);
        ReadGraph.readWeightGraph(sparseWeightGraph, filename);
        LazyPrimMST lazyPrimMST = new LazyPrimMST(sparseWeightGraph);
        System.out.println(lazyPrimMST.getWeight());
        Vector<Edge> edges = lazyPrimMST.getEdges();
        for (int i = 0; i < edges.size()-1; i++) {
            System.out.println(edges.get(i).getX() + "-" + edges.get(i).getY() + " weight: " + edges.get(i).getWeight());
        }

        System.out.println("Prim:");
        SparseWeightGraph sparseWeightGraph2 = new SparseWeightGraph(8, false);
        ReadGraph.readWeightGraph(sparseWeightGraph2, filename);
        PrimMST primMST = new PrimMST(sparseWeightGraph2);
        System.out.println(primMST.getWeight());
        Vector<Edge> edges2 = primMST.getEdges();
        for (int i = 0; i < edges2.size(); i++) {
            System.out.println(edges2.get(i).getX() + "-" + edges2.get(i).getY() + " weight: " + edges2.get(i).getWeight());
        }

        System.out.println("Kruskal:");
        SparseWeightGraph sparseWeightGraph3 = new SparseWeightGraph(8, false);
        ReadGraph.readWeightGraph(sparseWeightGraph3, filename);
        KruskalMST kruskalMST = new KruskalMST(sparseWeightGraph3);
        System.out.println(kruskalMST.getWeight());
        Vector<Edge> edges3 = kruskalMST.getEdges();
        for (int i = 0; i < edges3.size(); i++) {
            System.out.println(edges3.get(i).getX() + "-" + edges3.get(i).getY() + " weight:" + edges3.get(i).getWeight());
        }
    }

    private static void testWeightGraph() {
        String filename = gePath("testG3.txt");

        System.out.println("DenseWeightGraph:");
        DenseWeightGraph denseWeightGraph = new DenseWeightGraph(8, false);
        ReadGraph.readWeightGraph(denseWeightGraph, filename);
        denseWeightGraph.show();

        System.out.println("SparseWeightGraph:");
        SparseWeightGraph sparseWeightGraph = new SparseWeightGraph(8, false);
        ReadGraph.readWeightGraph(sparseWeightGraph, filename);
        sparseWeightGraph.show();
    }

    private static void testNonWeightGraph() {
        String filename = gePath("testG1.txt");
        System.out.println();

        System.out.println("denseGraph:");
        DenseGraph denseGraph = new DenseGraph(13, false);
        ReadGraph.readGraph(denseGraph, filename);
        Component component1 = new Component(denseGraph);
        denseGraph.show();
        System.out.println("component count: " + component1.count());
        System.out.println();

        String filename2 = gePath("testG2.txt");
        System.out.println("denseGraph:");
        SparseGraph sparseGraph = new SparseGraph(7, false);
        ReadGraph.readGraph(sparseGraph, filename2);
        Component component2 = new Component(sparseGraph);
        sparseGraph.show();
        System.out.println("component count: " + component2.count());
    }

    private static String gePath(String fileName) {
        String mainPath = Class.class.getClass().getResource("/").getPath();
//        mainPath = mainPath.substring(0, mainPath.indexOf("/out"));
        mainPath = mainPath + "com/github/junyu/solution/data_structure/graph/data/" + fileName;
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
