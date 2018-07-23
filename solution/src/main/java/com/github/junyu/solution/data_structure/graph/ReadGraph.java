package com.github.junyu.solution.data_structure.graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 读取图的测试文件
 *
 * @author ShaoJunyu
 * @since 2018/7/23 08:17
 */
public class ReadGraph {

    private static Scanner scanner;

    public ReadGraph() {

    }

    public static void readGraph(Graph graph, String filename) {
        readFile(filename);

        try {
            int vertices = scanner.nextInt();
            if (vertices < 0) {
                throw new IllegalArgumentException("number of vertices in a graph must be larger or equals than 0");
            }

            int edges = scanner.nextInt();
            if (edges < 0) {
                throw new IllegalArgumentException("number of edges in a graph must be  must be larger or equals than 0");
            }

            for (int i = 0; i < edges; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                graph.addEdge(x, y);
            }
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
    }


    private static void readFile(String filename) {
        assert filename != null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                throw new IllegalArgumentException(filename + " doesn't exist.");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Couldn't open " + filename, ioe);
        }

    }


}
