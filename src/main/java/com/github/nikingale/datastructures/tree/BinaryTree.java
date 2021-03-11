package com.github.nikingale.datastructures.tree;

import java.util.*;
import java.util.Queue;

/**
 * @author Nikhil Ingale 05-01-2021
 */

public class BinaryTree implements Tree {

    private TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void preOrder(List treeList, TreeNode root) {
        if (root != null) {
            treeList.add(root.getElement());
            preOrder(treeList, root.getLeft());
            preOrder(treeList, root.getRight());
        }
    }

    public void inOrder(List treeList, TreeNode root) {
        if (root != null) {
            inOrder(treeList, root.getLeft());
            treeList.add(root.getElement());
            inOrder(treeList, root.getRight());
        }
    }

    public void postOrder(List treeList, TreeNode root) {
        if (root != null) {
            postOrder(treeList, root.getLeft());
            postOrder(treeList, root.getRight());
            treeList.add(root.getElement());
        }
    }

    public void breadthFirstSearch(List treeList, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            treeList.add(treeNode.getElement());
            if (treeNode.getLeft() != null) {
                queue.add(treeNode.getLeft());
            }
            if (treeNode.getRight() != null) {
                queue.add(treeNode.getRight());
            }
        }
    }

    public boolean search(int element, TreeNode root) {
        boolean result = false;
        if (root != null) {
            if (root.getElement() == element) {
                return true;
            }
            result = search(element, root.getLeft());
            result = result || search(element, root.getRight());
        }
        return result;
    }

    public void add(int element) {
        TreeNode treeNode = new TreeNode(element);
        if (root == null) {
            root = treeNode;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
            if (current.getLeft() == null) {
                current.setLeft(treeNode);
                return;
            }
            else if (current.getRight() == null) {
                current.setRight(treeNode);
                return;
            }
        }
    }

    public void remove(int element) {
        TreeNode target = null, last = null, prev = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current.getElement() == element) {
                target = current;
            }

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }

            if (current.getLeft() == null) {
                last = prev;
                break;
            }
            else if (current.getRight() == null) {
                last = current;
                break;
            }
            prev = current;
        }
        if (last.getRight() != null) {
            target.setElement(last.getRight().getElement());
            last.setRight(null);
        }
        else {
            target.setElement(last.getLeft().getElement());
            last.setLeft(null);
        }
    }

}