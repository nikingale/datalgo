    package com.github.nikingale.algorithms.sorting;

/**
 * @author Nikhil Ingale 12-01-2021
 */

public class SelectionSort {

    public void selectionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
        }
    }

}