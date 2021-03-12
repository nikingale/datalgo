package com.github.nikingale.datastructures.stack;

/**
 * @author Nikhil Ingale 03-01-2021
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
public class StackTest {

    private Stack stack;

    public StackTest(Stack stack) {
        this.stack = stack;
    }

    @Parameters
    public static Collection<Stack> testStacks() {
        Stack[] stacks = {new ArrayStack(), new LinkedStack()};
        return Arrays.asList(stacks);
    }

    @Before
    public void setup() {
        stack.emptyStack();
    }

    @Test
    public void testPush() {
        assertTrue(stack.push(10));
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());

        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    public void testPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.peek());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertEquals(-1, stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.peek());
        stack.pop();
        assertEquals(20, stack.peek());
        stack.pop();
        assertEquals(10, stack.peek());
        stack.pop();
        assertEquals(-1, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        stack.push(10);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        stack.push(10);
        assertEquals(1, stack.size());

        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
    }

    @Test
    public void testEmptyStack() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(3, stack.size());
        stack.emptyStack();
        assertEquals(0, stack.size());
    }

}