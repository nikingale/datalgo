package com.github.nikingale.datastructures;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nikhil Ingale 01-01-2021
 */

public class ArrayTest {

    int[] array = {10, 20, 30};
    Array test = new Array(array);

    @Test
    public void testSearchArray() {
        int expected = 0;
        int actual = test.searchArray(10);
        Assert.assertEquals(expected, actual);

        expected = -1;
        actual = test.searchArray(1000);
        Assert.assertEquals(expected, actual);
    }

}