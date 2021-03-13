package com.github.nikingale.datastructures.tree;

/**
 * @author Nikhil Ingale 05-01-2021
 */

public class BinarySearchTree extends BinaryTree implements Tree {

    public BinarySearchTree(TreeNode root) {
        super(root);
    }

    public boolean search(int element) {
        TreeNode current = root;
        while (current != null) {
            if (current.getElement() == element) {
                return true;
            }
            else if (element < current.getElement()) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        return false;
    }

    public void add(int element) {
        TreeNode node = new TreeNode(element);
        TreeNode current = root, previous = root;
        while (current != null) {
            previous = current;
            if (node.getElement() < current.getElement()) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        if (node.getElement() < previous.getElement()) {
            previous.setLeft(node);
        }
        else {
            previous.setRight(node);
        }
    }

    public void remove(int element) {
        TreeNode current = root, previous = root;
        while (current != null) {
            if (element < current.getElement()) {
                previous = current;
                current = current.getLeft();
            }
            else if (element > current.getElement()) {
                previous = current;
                current = current.getRight();
            }
            else {
                deleteNode(current, previous);
                break;
            }
        }
    }

    private void deleteNode(TreeNode current, TreeNode previous) {
        //leaf node
        if (current.getLeft() == null && current.getRight() == null) {
            if (current != root) {
                if (previous.getLeft() == current) {
                    previous.setLeft(null);
                }
                else previous.setRight(null);
            }
            else root = null;
        }
        //node having just right child
        else if (current.getLeft() == null) {
            current.setElement(current.getRight().getElement());
            current.setRight(null);
        }
        //node having just left child
        else if (current.getRight() == null) {
            current.setElement(current.getLeft().getElement());
            current.setLeft(null);
        }
        //node having both child
        else {
            current.setElement(findMax(current.getLeft(), current));
        }
    }

    private int findMax(TreeNode node, TreeNode previous) {
        while (node.getRight() != null) {
            previous = node;
            node = node.getRight();
        }
        int max = node.getElement();
        if (previous.getLeft() == node) {
            previous.setLeft(null);
        }
        else if (previous.getRight() == node) {
            previous.setRight(null);
        }
        return max;
    }

}