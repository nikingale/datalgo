package com.github.nikingale.datastructures.queue;

/**
 * @author Nikhil Ingale 04-01-2021
 */

public class ArrayQueue implements Queue {

    int[] queue;
    int front = -1, rear = -1, size = 0;

    public ArrayQueue() {
        queue = new int[3];
    }

    public ArrayQueue(int size) {
        queue = new int[size];
    }

    public void enqueue(int element) {
        if (rear == queue.length - 1) {
            System.out.println("Queue full");
        }
        else {
            rear = rear + 1;
            queue[rear] = element;
            size = size + 1;
        }
        if (front == -1) {
            front = front + 1;
        }
    }

    public int dequeue() {
        int value = -1;

        if (size > 0) {
            value = queue[front];
            size = size - 1;
            front = front + 1;
        }
        else {
            System.out.println("Queue empty");
        }
        return value;
    }

    public int front() {
        int value = -1;

        if (size > 0) {
            value = queue[front];
        }
        else {
            System.out.println("Queue empty");
        }
        return value;
    }

    public int rear() {
        int value = -1;

        if (size > 0) {
            value = queue[rear];
        }
        else {
            System.out.println("Queue empty");
        }
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        System.out.print("[ ");
        for (int i = front; i <= rear && i < queue.length; i++) {
            if (i > -1) {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println("]");
    }

    public void emptyQueue() {
        front = rear = -1;
        size = 0;
    }

}