package com.github.nikingale.algorithms.sorting;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 * @author Nikhil Ingale 10-01-2021
 */

public class SortTest {

    private int[] input = {5, 3, 4, 2, 1};
    private int[] expected = {1, 2, 3, 4, 5};

    @Before
    public void setup() {
        input = new int[]{5, 3, 4, 2, 1};
    }

    @Test
    public void testBubbleSort() {
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testInsertionSort() {
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testSelectionSort() {
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSort() {
        MergeSort sort = new MergeSort();
        int[] actual = sort.mergeSort(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testQuickSort() {
        QuickSort sort = new QuickSort();
        int[] actual = sort.quickSort(input);
        Assert.assertArrayEquals(expected, actual);
    }

}