package com.github.nikingale.datastructures.heap;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Nikhil Ingale 07-01-2021
 */

public class MinHeapTest {

    MinHeap heap = new MinHeap();

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
        List<Integer> expected = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
        List<Integer> actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testSearch() {
        Assert.assertTrue(heap.search(30));
        Assert.assertFalse(heap.search(100));
    }

    @Test
    public void testAdd() {
        heap.add(80);
        List<Integer> expected = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
        List<Integer> actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.add(25);
        expected = Arrays.asList(10, 20, 30, 25, 50, 60, 70, 80, 40);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.add(5);
        expected = Arrays.asList(5, 10, 30, 25, 20, 60, 70, 80, 40, 50);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testRemove() {
        heap.remove(1000);
        List<Integer> expected = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
        List<Integer> actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.remove(70);
        expected = Arrays.asList(10, 20, 30, 40, 50, 60);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.remove(30);
        expected = Arrays.asList(10, 20, 60, 40, 50);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.remove(10);
        expected = Arrays.asList(20, 40, 60, 50);
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testPeek() {
        int expected = 10;
        int actual = heap.peek();
        Assert.assertEquals(expected, actual);

        heap.emptyHeap();
        expected = -1;
        actual = heap.peek();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEmptyHeap() {
        List<Integer> expected = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
        List<Integer> actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        heap.emptyHeap();
        expected = Collections.emptyList();
        actual = heap.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}