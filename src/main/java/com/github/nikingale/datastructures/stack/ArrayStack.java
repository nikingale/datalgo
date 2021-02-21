package com.github.nikingale.datastructures.stack;

/**
 * @author Nikhil Ingale 03-01-2021
 */

public class ArrayStack implements Stack {

    int[] stack;
    int top = -1;

    public ArrayStack() {
        stack = new int[3];
    }

    public ArrayStack(int size) {
        stack = new int[size];
    }

    public boolean push(int element) {
        if (top == stack.length - 1) {
            System.out.println("Stack overflow");
            return false;
        }
        top = top + 1;
        stack[top] = element;
        return true;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        int element = stack[top];
        top = top - 1;
        return element;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public int size() {
        return top + 1;
    }

    public void printStack() {
        System.out.print("[ ");
        for (int index = 0; index <= top; index++) {
            System.out.print(stack[index] + " ");
        }
        System.out.println("]");
    }

    public void emptyStack() {
        top = -1;
    }

}