package com.github.nikingale.datastructures.heap;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Nikhil Ingale 07-01-2021
 */

public class MaxHeap implements Heap {

    private int[] maxHeap;
    private int capacity;
    private int last = -1;

    public MaxHeap() {
        capacity = 10;
        maxHeap = new int[capacity];
    }

    public List<Integer> breadthFirstTraversal() {
        List<Integer> heap = new LinkedList<>();
        for (int i = 0; i <= last; i++) {
            heap.add(maxHeap[i]);
        }
        return heap;
    }

    public boolean search(int element) {
        for (int i = 0; i <= last; i++) {
            if (element == maxHeap[i]) {
                return true;
            }
        }
        return false;
    }

    //To increase heap(array) capacity when full
    private void ensureCapacity() {
        if (last == capacity - 1) {
            maxHeap = Arrays.copyOf(maxHeap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    private void swap(int index1, int index2) {
        int temp = maxHeap[index1];
        maxHeap[index1] = maxHeap[index2];
        maxHeap[index2] = temp;
    }

    public void add(int element) {
        ensureCapacity();
        maxHeap[++last] = element;
        heapifyUp(last);
    }

    private void heapifyUp(int index) {
        int parent = (int) Math.floor((index - 1) / 2);
        while (parent > -1 && maxHeap[index] > maxHeap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (int) Math.floor((index - 1) / 2);
        }
    }

    public void remove(int element) {
        if (last > -1 && search(element)) {
            int index = 0;
            for (int i = 0; i <= last; i++) {
                if (element == maxHeap[i]) {
                    index = i;
                    break;
                }
            }

            if (index == last) {
                last--;
            }
            else {
                maxHeap[index] = maxHeap[last];
                last--;
                heapifyDown(index);
            }
        }
    }

    private void heapifyDown(int index) {
        int largest;
        while (index <= last) {
            largest = index;
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if (left <= last && maxHeap[left] > maxHeap[largest]) {
                largest = left;
            }
            if (right <= last && maxHeap[right] > maxHeap[largest]) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            }
            else break;
        }
    }

    public int peek() {
        int value = -1;
        if (last > -1) {
            value = maxHeap[0];
        }
        return value;
    }

    public void emptyHeap() {
        last = -1;
    }

}