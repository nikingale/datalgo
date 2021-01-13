package com.github.nikingale.datastructures;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nikhil Ingale 01-01-2021
 */

public class ArrayTest {

    int[] testArray = {10, 20, 30};
    Array testObject = new Array(testArray);

    @Test
    public void testSearchArray() {
        int expected = 0;
        int actual = testObject.searchArray(10);
        Assert.assertEquals(expected, actual);
    }
}