package com.github.nikingale.datastructures.linkedlist;

/**
 * @author Nikhil Ingale 02-01-2021
 */

public interface List {

    void addFirst(int element);

    void addLast(int element);

    void add(int element, int index);

    int removeFirst();

    int removeLast();

    int remove(int index);

    int get(int index);

    boolean isEmpty();

    int size();

    void printList();

    void emptyList();
}