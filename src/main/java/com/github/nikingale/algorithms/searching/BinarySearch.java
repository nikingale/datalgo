package com.github.nikingale.algorithms.searching;

/**
 * @author Nikhil Ingale 09-01-2021
 */

public class BinarySearch {

    public int binarySearch(int[] input, int key) {
        int beg = 0;
        int end = input.length - 1;
        int mid;

        while (beg <= end) {
            mid = (beg + end) / 2;

            if (key == input[mid]) {
                return mid;
            }
            else if (key < input[mid]) {
                end = mid - 1;
            }
            else {
                beg = mid + 1;
            }
        }
        return -1;
    }

}