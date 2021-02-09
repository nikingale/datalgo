package com.github.nikingale.datastructures.linkedlist;

/**
 * @author Nikhil Ingale 02-01-2021
 */

public class DoublyLinkedList implements List {

    private DNode head;

    public void addFirst(int element) {
        if (head == null) {
            head = new DNode(element);
        }
        else {
            DNode node = new DNode(element);
            node.setNext(head);
            node.setPrevious(null);
            head = node;
        }
    }

    public void addLast(int element) {
        if (head == null) {
            head = new DNode(element);
        }
        else {
            DNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            DNode node = new DNode(element);
            current.setNext(node);
            node.setPrevious(current);
            node.setNext(null);
        }
    }

    public void add(int element, int index) {
        if (head == null) {
            head = new DNode(element);
        }
        else {
            if (index == 0) {
                addFirst(element);
            }
            else {
                DNode current = head, previous = head;
                int count = 0;
                while (count < index && current != null) {
                    previous = current;
                    current = current.getNext();
                    count++;
                }
                if (current != null) {
                    DNode node = new DNode(element);
                    previous.setNext(node);
                    node.setPrevious(previous);
                    node.setNext(current);
                    current.setPrevious(node);
                }
            }
        }
    }

    public int removeFirst() {
        int value = -1;

        if (head != null) {
            value = head.getElement();
            DNode node = head;
            head = head.getNext();
            node.setNext(null);
            head.setPrevious(null);
        }
        return value;
    }

    public int removeLast() {
        int value = -1;

        if (head != null) {
            DNode current = head, previous = head;
            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
            value = current.getElement();
            previous.setNext(null);
            current.setPrevious(null);
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
                DNode current = head, previous = head;
                int count = 0;
                while (count < index && current != null) {
                    previous = current;
                    current = current.getNext();
                    count++;
                }
                if (current != null) {
                    value = current.getElement();
                    previous.setNext(current.getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrevious(previous);
                    }
                    else current.setPrevious(null);
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
                DNode current = head;
                int count = 0;
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
            DNode current = head;
            while (current != null) {
                size++;
                current = current.getNext();
            }
        }
        return size;
    }

    public void printList() {
        System.out.print("[ ");
        DNode current = head;
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