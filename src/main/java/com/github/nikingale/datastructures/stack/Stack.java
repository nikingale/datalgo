package com.github.nikingale.datastructures.stack;

/**
 * @author Nikhil Ingale 03-01-2021
 */

public interface Stack {

    boolean push(int element);

    int pop();

    int peek();

    boolean isEmpty();

    int size();

    void printStack();

    void emptyStack();

}