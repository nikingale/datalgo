package com.github.nikingale.algorithms.sorting;

/**
 * @author Nikhil Ingale 13-01-2021
 */

public class MergeSort {

    public int[] mergeSort(int[] input) {
        return divide(input);
    }

    private int[] divide(int[] input) {
        if (input.length == 1) {
            return input;
        }

        int mid = input.length / 2;
        int[] left = new int[mid];
        int[] right = new int[input.length - mid];

        for (int i = 0; i < input.length; i++) {
            if (i < mid) {
                left[i] = input[i];
            }
            else {
                right[i - mid] = input[i];
            }
        }

        left = divide(left);
        right = divide(right);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                merged[i] = left[l];
                l++;
            }
            else {
                merged[i] = right[r];
                r++;
            }
            i++;
        }
        while (l < left.length) {
            merged[i] = left[l];
            i++;
            l++;
        }
        while (r < right.length) {
            merged[i] = right[r];
            i++;
            r++;
        }
        return merged;
    }

}