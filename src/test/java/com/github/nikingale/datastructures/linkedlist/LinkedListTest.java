package com.github.nikingale.datastructures.linkedlist;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

/**
 * @author Nikhil Ingale 02-01-2021
 */

@RunWith(Parameterized.class)
public class LinkedListTest {

    private List list;

    public LinkedListTest(List list) {
        this.list = list;
    }

    @Parameters
    public static Collection<List> testLists() {
        List[] lists = {new SinglyLinkedList(), new DoublyLinkedList(), new CircularLinkedList()};
        return Arrays.asList(lists);
    }

    @Before
    public void setList() {
        list.emptyList();
    }

    @Test
    public void testAddFirst() {

        list.addFirst(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));

        list.addFirst(20);
        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
        assertEquals(10, list.get(1));
    }

    @Test
    public void testAddLast() {

        list.addLast(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));

        list.addLast(20);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    public void testAdd() {
        list.add(10, 0);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));

        list.add(20, 0);
        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
        assertEquals(10, list.get(1));

        list.add(30, 1);
        assertEquals(3, list.size());
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));
        assertEquals(10, list.get(2));
        assertEquals(-1, list.get(15));
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(10);
        list.addLast(20);

        int removed = list.removeFirst();
        assertEquals(1, list.size());
        assertEquals(10, removed);

        removed = list.removeFirst();
        assertEquals(0, list.size());
        assertEquals(20, removed);

        assertEquals(-1, list.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        list.addFirst(10);
        list.addLast(20);

        int removed = list.removeLast();
        assertEquals(1, list.size());
        assertEquals(20, removed);

        removed = list.removeLast();
        assertEquals(0, list.size());
        assertEquals(10, removed);

        assertEquals(-1, list.removeLast());
    }

    @Test
    public void testRemove() {
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(-1, list.remove(10));
        assertEquals(-1, list.remove(-3));
        assertEquals(3, list.size());

        int removed = list.remove(2);
        assertEquals(2, list.size());
        assertEquals(30, removed);

        removed = list.remove(1);
        assertEquals(1, list.size());
        assertEquals(20, removed);
    }

    @Test
    public void testGet() {
        assertEquals(0, list.size());
        assertEquals(-1, list.get(0));

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));

        assertEquals(-1, list.get(-5));
        assertEquals(-1, list.get(15));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());

        list.addFirst(10);
        assertEquals(1, list.size());

        list.addLast(20);
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.addFirst(10);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testEmptyList() {
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(3, list.size());
        list.emptyList();
        assertEquals(0, list.size());
    }

}