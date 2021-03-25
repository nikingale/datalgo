package com.github.nikingale.datastructures.heap;

import java.util.List;

/**
 * @author Nikhil Ingale 07-01-2021
 */

public interface Heap {

    List<Integer> breadthFirstTraversal();

    boolean search(int element);

    void add(int element);

    void remove(int element);

    int peek();

    void emptyHeap();

}