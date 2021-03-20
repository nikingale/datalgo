package com.github.nikingale.algorithms.sorting;

/**
 * @author Nikhil Ingale 10-01-2021
 */

public class BubbleSort {

    public void bubbleSort(int[] input) {
        boolean isSwap;
        int n = input.length;

        while (n > 0) {
            isSwap = false;
            for (int i = 0; i < n - 1; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
            n--;
        }
    }

}