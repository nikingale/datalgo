package com.github.nikingale.datastructures.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author Nikhil Ingale 05-01-2021
 */

public class TreeTest {
    BinaryTree tree;
    TreeNode root;

    @Before
    public void setup() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);

        root = treeNode1;
        tree = new BinaryTree(treeNode1);
    }

    @Test
    public void testPreOrder() {
        List<Integer> expected = Arrays.asList(1, 2, 4, 5, 3);
        List<Integer> actual = tree.preOrder();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testInOrder() {
        List<Integer> expected = Arrays.asList(4, 2, 5, 1, 3);
        List<Integer> actual = tree.inOrder();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testPostOrder() {
        List<Integer> expected = Arrays.asList(4, 5, 2, 3, 1);
        List<Integer> actual = tree.postOrder();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testBFS() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> actual = tree.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testSearch() {
        Assert.assertTrue(tree.search(3));
        Assert.assertFalse(tree.search(10));
    }

    @Test
    public void testAdd() {
        tree = new BinaryTree();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);

        List<Integer> expected = Arrays.asList(10, 20, 30, 40);
        List<Integer> actual = tree.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testRemove() {
        tree.remove(3);
        List<Integer> expected = Arrays.asList(1, 2, 5, 4);
        List<Integer> actual = tree.breadthFirstTraversal();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}