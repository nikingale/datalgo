package com.github.nikingale.algorithms.searching;

/**
 * @author Nikhil Ingale 09-01-2021
 */

public class BinarySearchRecursive {

    public int binarySearchRecursive(int[] input, int key, int beg, int end) {
        if (beg > end) {
            return -1;
        }

        int mid = (beg + end) / 2;

        if (key == input[mid]) {
            return mid;
        }
        else if (key < input[mid]) {
            return binarySearchRecursive(input, key, beg, mid - 1);
        }
        else {
            return binarySearchRecursive(input, key, mid + 1, end);
        }
    }

}