package com.github.nikingale.datastructures.queue;

/**
 * @author Nikhil Ingale 04-01-2021
 */

public class LinkedQueue implements Queue {

    private Node front;
    private Node rear;

    public void enqueue(int element) {
        if (front == null) {
            front = new Node(element);
            rear = front;
        }
        else {
            Node node = new Node(element);
            rear.setNext(node);
            rear = node;
        }
    }

    public int dequeue() {
        int value = -1;

        if (front != null) {
            value = front.getElement();
            front = front.getNext();
        }
        else {
            System.out.println("Queue empty");
        }
        return value;
    }

    public int front() {
        if (front != null) {
            return front.getElement();
        }
        return -1;
    }

    public int rear() {
        if (rear != null) {
            return rear.getElement();
        }
        return -1;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        int size = 0;
        Node current = front;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void printQueue() {
        System.out.print("[ ");
        Node current = front;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println("]");
    }

    public void emptyQueue() {
        front = rear = null;
    }

}