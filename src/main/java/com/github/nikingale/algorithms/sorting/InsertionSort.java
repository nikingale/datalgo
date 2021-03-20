package com.github.nikingale.algorithms.sorting;

/**
 * @author Nikhil Ingale 11-01-2021
 */

public class InsertionSort {

    public void insertionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {

            int j, element = input[i];
            for (j = 0; j < i; j++) {
                if (input[i] < input[j]) {
                    break;
                }
            }
            for (int k = i; k > j; k--) {
                input[k] = input[k - 1];
            }
            input[j] = element;
        }
    }

}