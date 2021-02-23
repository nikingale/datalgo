package com.github.nikingale.algorithms.searching;

/**
 * @author Nikhil Ingale 09-01-2021
 */

public class BinarySearch {

    public int binarySearch(int[] input, int key, int beg, int end) {

        if (beg > end) {
            return -1;
        }

        int mid = (beg + end) / 2;

        if (input[mid] == key) {
            return mid;
        }
        else if (input[mid] > key) {
            return binarySearch(input, key, beg, mid - 1);
        }
        else if (input[mid] < key) {
            return binarySearch(input, key, mid + 1, end);
        }

        return -1;
    }

}