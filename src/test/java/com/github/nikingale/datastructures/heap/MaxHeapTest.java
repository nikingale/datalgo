package com.github.nikingale.datastructures.heap;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Nikhil Ingale 07-01-2021
 */

public class MaxHeapTest {

    MaxHeap heap = new MaxHeap();

    @Before
    public void setup() {
        heap.emptyHeap();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(50);
        heap.add(60);
        heap.add(70);
    }

    @Test
    public void testBFS() {
        List<Integer> expected = Arrays.asList(70, 40, 60, 10, 30, 20, 50);
        List<Integer> actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testSearch() {
        Assert.assertTrue(heap.search(30));
        Assert.assertFalse(heap.search(1000));
    }

    @Test
    public void testAdd() {
        heap.add(5);
        List<Integer> expected = Arrays.asList(70, 40, 60, 10, 30, 20, 50, 5);
        List<Integer> actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.add(45);
        expected = Arrays.asList(70, 45, 60, 40, 30, 20, 50, 5, 10);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.add(100);
        expected = Arrays.asList(100, 70, 60, 40, 45, 20, 50, 5, 10, 30);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testRemove() {
        heap.remove(1000);
        List<Integer> expected = Arrays.asList(70, 40, 60, 10, 30, 20, 50);
        List<Integer> actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.remove(50);
        expected = Arrays.asList(70, 40, 60, 10, 30, 20);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.remove(40);
        expected = Arrays.asList(70, 30, 60, 10, 20);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.remove(70);
        expected = Arrays.asList(60, 30, 20, 10);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testPeek() {
        int expected = 70;
        int actual = heap.peek();
        Assert.assertEquals(expected, actual);

        heap.remove(70);
        expected = 60;
        actual = heap.peek();
        Assert.assertEquals(expected, actual);

        heap.emptyHeap();
        expected = -1;
        actual = heap.peek();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEmptyHeap() {
        List<Integer> expected = Arrays.asList(70, 40, 60, 10, 30, 20, 50);
        List<Integer> actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.emptyHeap();
        expected = Collections.emptyList();
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}