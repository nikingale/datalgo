package com.github.nikingale.datastructures.linkedlist;

/**
 * @author Nikhil Ingale 02-01-2021
 */

public class CircularLinkedList implements List {

    private Node head;

    public void addFirst(int element) {
        if (head == null) {
            head = new Node(element);
            head.setNext(head);
        }
        else {
            Node current = head;
            do {
                current = current.getNext();
            } while (current.getNext() != head);
            Node node = new Node(element);
            node.setNext(head);
            head = node;
            current.setNext(head);
        }
    }

    public void addLast(int element) {
        if (head == null) {
            head = new Node(element);
            head.setNext(head);
        }
        else {
            Node current = head;
            do {
                current = current.getNext();
            } while (current.getNext() != head);
            Node node = new Node(element);
            current.setNext(node);
            node.setNext(head);
        }
    }

    public void add(int element, int index) {
        if (head == null) {
            head = new Node(element);
            head.setNext(head);
        }
        else if (index > -1) {
            if (index == 0) {
                addFirst(element);
            }
            else {
                int count = 0;
                Node current = head, previous = head;
                do {
                    previous = current;
                    current = current.getNext();
                    count++;
                } while (count < index && current != head);

                if (current != head) {
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
            Node current = head;
            do {
                current = current.getNext();
            } while (current.getNext() != head);
            if (current != head) {
                head = head.getNext();
                current.setNext(head);
            }
            else head = null;
        }
        return value;
    }

    public int removeLast() {
        int value = -1;

        if (head != null) {
            Node current = head, previous;
            do {
                previous = current;
                current = current.getNext();
            } while (current.getNext() != head);
            value = current.getElement();
            if (current != head) {
                previous.setNext(head);
            }
            else head = null;
        }
        return value;
    }

    public int remove(int index) {
        int value = -1;

        if (head != null && index > -1) {
            if (index == 0) {
                value = removeFirst();
            }
            else {
                int count = 0;
                Node current = head, previous = head;
                do {
                    previous = current;
                    current = current.getNext();
                    count++;
                } while (count < index && current != head);
                if (current != head) {
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
                do {
                    current = current.getNext();
                    count++;
                } while (count < index && current != head);
                if (current != head) {
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
            do {
                size++;
                current = current.getNext();
            } while (current != head);
        }
        return size;
    }

    public void printList() {
        System.out.print("[ ");
        if (head != null) {
            Node current = head;
            do {
                System.out.print(current.getElement() + " ");
                current = current.getNext();
            } while (current != head);
        }
        System.out.println("]");
    }

    public void emptyList() {
        head = null;
    }

}