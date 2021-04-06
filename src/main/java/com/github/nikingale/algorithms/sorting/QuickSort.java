package com.github.nikingale.algorithms.sorting;

import java.util.Arrays;

/**
 * @author Nikhil Ingale 14-01-2021
 */

public class QuickSort {

    public int[] quickSort(int[] input) {
        input = Arrays.copyOf(input, input.length + 1);
        input[input.length - 1] = Integer.MAX_VALUE;
        int low = 0;
        int high = input.length - 1;
        quickSorter(low, high, input);
        return Arrays.copyOf(input, input.length - 1);
    }

    public void quickSorter(int low, int high, int[] input) {
        if (low < high) {
            int j = partition(low, high, input);
            quickSorter(low, j, input);
            quickSorter(j + 1, high, input);
        }
    }

    private int partition(int low, int high, int[] input) {
        int pivot = low;
        int i = low;
        int j = high;

        while (i < j) {
            do {
                i++;
            } while (input[i] <= input[pivot]);

            do {
                j--;
            } while (input[j] > input[pivot]);

            if (i < j) {
                swap(i, j, input);
            }
        }
        swap(pivot, j, input);
        return j;
    }

    private void swap(int i, int j, int[] input) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}