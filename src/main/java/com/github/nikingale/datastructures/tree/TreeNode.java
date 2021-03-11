package com.github.nikingale.datastructures.tree;

/**
 * @author Nikhil Ingale 05-01-2021
 */

public class TreeNode {

    private int element;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}