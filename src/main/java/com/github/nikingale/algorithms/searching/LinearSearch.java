package com.github.nikingale.algorithms.searching;

/**
 * @author Nikhil Ingale 08-01-2021
 */

public class LinearSearch {

    public int linearSearch(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return index;
            }
        }
        return -1;
    }

}