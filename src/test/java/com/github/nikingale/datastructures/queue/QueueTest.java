package com.github.nikingale.datastructures.queue;

/**
 * @author Nikhil Ingale 04-01-2021
 */

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class QueueTest {

    private Queue queue;

    public QueueTest(Queue queue) {
        this.queue = queue;
    }

    @Parameters
    public static Collection<Queue> testQueues() {
        Queue[] queues = {new ArrayQueue()};
        return Arrays.asList(queues);
    }

    @Before
    public void setQueue() {
        queue.emptyQueue();
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(10);
        assertEquals(1, queue.size());
        assertEquals(10, queue.front());

        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(3, queue.size());
        assertEquals(10, queue.front());
        assertEquals(30, queue.rear());
    }

    @Test
    public void testDequeue() {
        assertEquals(-1, queue.dequeue());

        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());
        assertEquals(10, queue.dequeue());
        assertEquals(1, queue.size());
    }

    @Test
    public void testFront() {
        assertEquals(-1, queue.front());
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.front());
    }

    @Test
    public void testRear() {
        assertEquals(-1, queue.rear());
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(20, queue.rear());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());

        queue.enqueue(10);
        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(10);
        assertEquals(1, queue.size());
    }

    @Test
    public void testEmptyQueue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(3, queue.size());
        queue.emptyQueue();
        assertEquals(0, queue.size());
    }

}