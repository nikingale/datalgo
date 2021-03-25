package com.github.nikingale.datastructures.heap;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Nikhil Ingale 07-01-2021
 */

public class MinHeap implements Heap {

    private int[] minHeap;
    private int capacity;
    private int last = -1;

    public MinHeap() {
        capacity = 10;
        minHeap = new int[capacity];
    }

    public List<Integer> breadthFirstTraversal() {
        List<Integer> heap = new LinkedList<>();
        for (int i = 0; i <= last; i++) {
            heap.add(minHeap[i]);
        }
        return heap;
    }

    public boolean search(int element) {
        for (int i = 0; i <= last; i++) {
            if (element == minHeap[i]) {
                return true;
            }
        }
        return false;
    }

    //To increase heap(array) capacity when full
    private void ensureCapacity() {
        if (last == capacity - 1) {
            minHeap = Arrays.copyOf(minHeap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    private void swap(int index1, int index2) {
        int temp = minHeap[index1];
        minHeap[index1] = minHeap[index2];
        minHeap[index2] = temp;
    }

    public void add(int element) {
        ensureCapacity();
        minHeap[++last] = element;
        heapifyUp(last);
    }

    private void heapifyUp(int index) {
        int parent = (int) Math.floor((index - 1) / 2);
        while (parent > -1 && minHeap[index] < minHeap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (int) Math.floor((index - 1) / 2);
        }
    }

    public void remove(int element) {
        if (last > -1 && search(element)) {
            int index = 0;
            for (int i = 0; i <= last; i++) {
                if (element == minHeap[i]) {
                    index = i;
                    break;
                }
            }

            if (index == last) {
                last--;
            }
            else {
                minHeap[index] = minHeap[last];
                last--;
                heapifyDown(index);
            }
        }
    }

    private void heapifyDown(int index) {
        int smallest;
        while (index <= last) {
            smallest = index;
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if (left <= last && minHeap[left] < minHeap[smallest]) {
                smallest = left;
            }
            if (right <= last && minHeap[right] < minHeap[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            }
            else break;
        }
    }

    public int peek() {
        int value = -1;
        if (last > -1) {
            value = minHeap[0];
        }
        return value;
    }

    public void emptyHeap() {
        last = -1;
    }

}