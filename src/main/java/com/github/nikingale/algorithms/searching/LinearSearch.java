package com.github.nikingale.algorithms.searching;

/**
 * @author Nikhil Ingale 08-01-2021
 */

public class LinearSearch {

    public int linearSearch(int[] input, int key) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == key) {
                return i;
            }
        }
        return -1;
    }

}