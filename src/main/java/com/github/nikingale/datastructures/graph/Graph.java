package com.github.nikingale.datastructures.graph;

import java.util.List;

/**
 * @author Nikhil Ingale 06-01-2021
 */

public interface Graph {

    List<Integer> breadthFirstTraversal();

    List<Integer> deptFirstTraversal();

}