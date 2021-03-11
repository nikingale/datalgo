package com.github.nikingale.datastructures.tree;

import java.util.List;

/**
 * @author Nikhil Ingale 05-01-2021
 */

public interface Tree {

    void preOrder(List list, TreeNode root);

    void inOrder(List list, TreeNode root);

    void postOrder(List list, TreeNode root);

    void breadthFirstSearch(List list, TreeNode root);

    void add(int element);

    void remove(int element);

    boolean search(int element, TreeNode root);

}