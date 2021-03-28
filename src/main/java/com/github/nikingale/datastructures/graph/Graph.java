package com.github.nikingale.datastructures.graph;

import java.util.List;

/**
 * @author Nikhil Ingale 06-01-2021
 */

public interface Graph {

    void addVertex(String label);

    void removeVertex(String label);

    void addEdge(String label1, String label2);

    void removeEdge(String label1, String label2);

    List<String> breadthFirstTraversal();

    List<String> deptFirstTraversal();

}