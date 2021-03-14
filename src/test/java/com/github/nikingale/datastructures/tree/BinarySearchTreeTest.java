package com.github.nikingale.datastructures.tree;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nikhil Ingale 05-01-2021
 */

public class BinarySearchTreeTest {
    BinarySearchTree bst;
    TreeNode root;

    @Before
    public void setup() {
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(30);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(25);
        TreeNode node7 = new TreeNode(40);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        root = node1;
        bst = new BinarySearchTree(root);
    }

    @Test
    public void testPreOrder() {
        List<Integer> expected = Arrays.asList(20, 10, 5, 15, 30, 25, 40);
        List<Integer> actual = bst.preOrder();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testInOrder() {
        List<Integer> expected = Arrays.asList(5, 10, 15, 20, 25, 30, 40);
        List<Integer> actual = bst.inOrder();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testPostOrder() {
        List<Integer> expected = Arrays.asList(5, 15, 10, 25, 40, 30, 20);
        List<Integer> actual = bst.postOrder();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testBFS() {
        List<Integer> expected = Arrays.asList(20, 10, 30, 5, 15, 25, 40);
        List<Integer> actual = bst.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testSearch() {
        Assert.assertTrue(bst.search(15));
        Assert.assertFalse(bst.search(17));
    }

    @Test
    public void testAdd() {
        bst.add(3);
        bst.add(7);
        bst.add(45);

        List<Integer> expected = Arrays.asList(20, 10, 30, 5, 15, 25, 40, 3, 7, 45);
        List<Integer> actual = bst.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testRemove() {
        bst.remove(20);
        List<Integer> expected = Arrays.asList(15, 10, 30, 5, 25, 40);
        List<Integer> actual = bst.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        bst.remove(10);
        expected = Arrays.asList(15, 5, 30, 25, 40);
        actual = bst.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        bst.remove(30);
        expected = Arrays.asList(15, 5, 25, 40);
        actual = bst.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        bst.remove(5);
        expected = Arrays.asList(15, 25, 40);
        actual = bst.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}