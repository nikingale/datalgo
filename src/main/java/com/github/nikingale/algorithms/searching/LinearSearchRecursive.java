package com.github.nikingale.algorithms.searching;

/**
 * @author Nikhil Ingale 08-01-2021
 */

public class LinearSearchRecursive {

    public int linearSearchRecursive(int[] input, int key, int index) {
        if (index >= input.length) {
            return -1;
        }
        if (input[index] == key) {
            return index;
        }
        return linearSearchRecursive(input, key, ++index);
    }

}