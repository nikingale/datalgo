package com.github.nikingale.algorithms.searching;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nikhil Ingale 11-01-2021
 */

public class LinearSearchTest {

    int[] array = {10, 20, 30};
    LinearSearch search = new LinearSearch();

    @Test
    public void testLinearSearch() {
        int expected = 2;
        int actual = search.linearSearch(array, 30);
        Assert.assertEquals(expected, actual);

        expected = -1;
        actual = search.linearSearch(array, 100);
        Assert.assertEquals(expected, actual);
    }
}