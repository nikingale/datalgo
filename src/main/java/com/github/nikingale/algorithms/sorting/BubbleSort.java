package com.github.nikingale.algorithms.sorting;

/**
 * @author Nikhil Ingale 10-01-2021
 */

public class BubbleSort {

    public int[] bubbleSort(int[] input) {
        boolean didSwap = true;
        int n = input.length;

        while (didSwap && n > 0) {
            didSwap = false;
            for (int i = 0; i < n - 1; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    didSwap = true;
                }
            }
            n--;
        }
        return input;
    }

}