package com.github.nikingale.datastructures.queue;

/**
 * @author Nikhil Ingale 04-01-2021
 */

public interface Queue {

    void enqueue(int element);

    int dequeue();

    int front();

    int rear();

    boolean isEmpty();

    int size();

    void printQueue();

    void emptyQueue();

}