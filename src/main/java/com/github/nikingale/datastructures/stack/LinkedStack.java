package com.github.nikingale.datastructures.stack;

/**
 * @author Nikhil Ingale 03-01-2021
 */

public class LinkedStack implements Stack {

    private Node top;
    private int size;
    private int cap = 0;

    public LinkedStack() {
        this.size = 3;
    }

    public LinkedStack(int size) {
        this.size = size;
    }

    public boolean push(int element) {
        if (cap < size) {
            if (top == null) {
                top = new Node(element);
            }
            else {
                Node node = new Node(element);
                node.setNext(top);
                top = node;
            }
            cap = cap + 1;
            return true;
        }
        System.out.println("Stack overflow");
        return false;
    }

    public int pop() {
        int element = -1;

        if (top != null) {
            element = top.getElement();
            Node node = top;
            top = top.getNext();
            node.setNext(null);
            cap = cap - 1;
        }
        else {
            System.out.println("Stack is Empty");
        }
        return element;
    }

    public int peek() {
        int element = -1;

        if (top != null) {
            element = top.getElement();
        }
        else {
            System.out.println("Stack is Empty");
        }
        return element;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int size = 0;
        Node current = top;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void printStack() {
        //list left to right indicates stack top to bottom
        System.out.print("[ ");
        Node current = top;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println("]");
    }

    public void emptyStack() {
        top = null;
        cap = 0;
    }

}