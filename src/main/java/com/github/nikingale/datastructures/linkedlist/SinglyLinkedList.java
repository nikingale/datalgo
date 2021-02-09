package com.github.nikingale.datastructures.linkedlist;

/**
 * @author Nikhil Ingale 02-01-2021
 */

public class SinglyLinkedList implements List {

    private Node head;

    public void addFirst(int element) {
        if (head == null) {
            head = new Node(element);
        }
        else {
            Node node = new Node(element);
            node.setNext(head);
            head = node;
        }
    }

    public void addLast(int element) {
        if (head == null) {
            head = new Node(element);
        }
        else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            Node node = new Node(element);
            current.setNext(node);
        }
    }

    public void add(int element, int index) {
        if (head == null) {
            head = new Node(element);
        }
        else {
            if (index == 0) {
                addFirst(element);
            }
            else {
                Node current = head, previous = head;
                int count = 0;
                while (count < index && current != null) {
                    previous = current;
                    current = current.getNext();
                    count++;
                }
                if (current != null) {
                    Node node = new Node(element);
                    previous.setNext(node);
                    node.setNext(current);
                }
            }
        }
    }

    public int removeFirst() {
        int value = -1;

        if (head != null) {
            value = head.getElement();
            head = head.getNext();
        }
        return value;
    }

    public int removeLast() {
        int value = -1;

        if (head != null) {
            Node current = head, previous = null;
            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
            value = current.getElement();
            if (previous == null) {
                head = null;
            }
            else {
                previous.setNext(null);
            }
        }
        return value;
    }

    public int remove(int index) {
        int value = -1;

        if (head != null) {
            if (index == 0) {
                value = removeFirst();
            }
            else {
                Node current = head, previous = head;
                int count = 0;
                while (count < index && current != null) {
                    previous = current;
                    current = current.getNext();
                    count++;
                }
                if (current != null) {
                    value = current.getElement();
                    previous.setNext(current.getNext());
                }
            }
        }
        return value;
    }

    public int get(int index) {
        int value = -1;

        if (head != null && index > -1) {
            if (index == 0) {
                value = head.getElement();
            }
            else {
                int count = 0;
                Node current = head;
                while (count < index && current != null) {
                    current = current.getNext();
                    count++;
                }
                if (current != null) {
                    value = current.getElement();
                }
            }
        }
        return value;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        int size = 0;

        if (head != null) {
            Node current = head;
            while (current != null) {
                size++;
                current = current.getNext();
            }
        }
        return size;
    }

    public void printList() {
        Node current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println("]");
    }

    public void emptyList() {
        head = null;
    }

}