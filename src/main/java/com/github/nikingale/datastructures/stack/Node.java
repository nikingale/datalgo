package com.github.nikingale.datastructures.stack;

/**
 * @author Nikhil Ingale 03-01-2021
 */

public class Node {

    private int element;
    private Node next;

    public Node() {
    }

    public Node(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}