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
        int element = -1;
        if (head != null) {
            element = head.getElement();
            head = head.getNext();
        }
        return element;
    }

    public int removeLast() {
        int element = -1;
        if (head != null) {
            Node current = head, previous = null;
            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
            element = current.getElement();
            if (previous == null) {
                head = null;
            }
            else {
                previous.setNext(null);
            }
        }
        return element;
    }

    public int remove(int index) {
        int element = -1;
        if (head != null) {
            if (index == 0) {
                element = removeFirst();
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
                    element = current.getElement();
                    previous.setNext(current.getNext());
                }
            }
        }
        return element;
    }

    public int get(int index) {
        int element = -1;
        if (head != null && index > -1) {
            if (index == 0) {
                element =  head.getElement();
            }
            else {
                int count = 0;
                Node current = head;
                while (count < index && current != null) {
                    current = current.getNext();
                    count++;
                }
                if (current != null) {
                    element =  current.getElement();
                }
            }
        }
        return element;
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