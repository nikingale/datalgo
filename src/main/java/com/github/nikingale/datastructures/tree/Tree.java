package com.github.nikingale.datastructures.tree;

import java.util.List;

/**
 * @author Nikhil Ingale 05-01-2021
 */

public interface Tree {

    List<Integer> preOrder();

    List<Integer> inOrder();

    List<Integer> postOrder();

    List<Integer> breadthFirstTraversal();

    void add(int element);

    void remove(int element);

    boolean search(int element);

}