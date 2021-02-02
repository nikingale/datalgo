package com.github.nikingale.algorithms.searching;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nikhil Ingale 08-01-2021
 */

public class LinearSearchTest {

    int[] array = {10, 20, 30};
    LinearSearch search = new LinearSearch();

    @Test
    public void testLinearSearch() {
        int expected = 0;
        int actual = search.linearSearch(array, 10);
        Assert.assertEquals(expected, actual);

        expected = -1;
        actual = search.linearSearch(array, 1000);
        Assert.assertEquals(expected, actual);
    }

}