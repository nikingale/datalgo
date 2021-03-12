package com.github.nikingale.datastructures.tree;

import java.util.*;

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

    public List<Integer> preOrder() {
        List<Integer> treeList = new LinkedList<>();
        preOrderRecursive(this.root, treeList);
        return treeList;
    }

    public void preOrderRecursive(TreeNode root, List<Integer> treeList) {
        if (root != null) {
            treeList.add(root.getElement());
            preOrderRecursive(root.getLeft(), treeList);
            preOrderRecursive(root.getRight(), treeList);
        }
    }

    public List<Integer> inOrder() {
        List<Integer> treeList = new LinkedList<>();
        inOrderRecursive(this.root, treeList);
        return treeList;
    }

    public void inOrderRecursive(TreeNode root, List<Integer> treeList) {
        if (root != null) {
            inOrderRecursive(root.getLeft(), treeList);
            treeList.add(root.getElement());
            inOrderRecursive(root.getRight(), treeList);
        }
    }

    public List<Integer> postOrder() {
        List<Integer> treeList = new LinkedList<>();
        postOrderRecursive(this.root, treeList);
        return treeList;
    }

    public void postOrderRecursive(TreeNode root, List<Integer> treeList) {
        if (root != null) {
            postOrderRecursive(root.getLeft(), treeList);
            postOrderRecursive(root.getRight(), treeList);
            treeList.add(root.getElement());
        }
    }

    public List<Integer> breadthFirstTraversal() {
        List<Integer> treeList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
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
        return treeList;
    }

    public boolean search(int element) {
        return searchRecursive(element, this.root);
    }

    public boolean searchRecursive(int element, TreeNode root) {
        boolean result = false;
        if (root != null) {
            if (root.getElement() == element) {
                return true;
            }
            result = searchRecursive(element, root.getLeft());
            result = result || searchRecursive(element, root.getRight());
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
        TreeNode target = null, lastParent = null, previous = null;
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

            if (lastParent == null && current.getLeft() == null) {
                lastParent = previous;
            }
            else if (lastParent == null && current.getRight() == null) {
                lastParent = current;
            }
            previous = current;
        }
        if (lastParent.getRight() != null) {
            target.setElement(lastParent.getRight().getElement());
            lastParent.setRight(null);
        }
        else {
            target.setElement(lastParent.getLeft().getElement());
            lastParent.setLeft(null);
        }
    }

}