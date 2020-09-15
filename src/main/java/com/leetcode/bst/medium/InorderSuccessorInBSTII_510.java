package com.leetcode.bst.medium;

public class InorderSuccessorInBSTII_510 {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        while (node.parent != null && node.parent.left != node) {
            node = node.parent;
        }

        return node.parent;
    }
}
