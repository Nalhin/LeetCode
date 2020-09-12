package utils;

import java.util.*;

public class BinaryTree {

  public static TreeNode of(Integer first, Integer... args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(args));
    list.add(0, first);

    TreeNode root = new TreeNode(first);

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < list.size()) {
      TreeNode currentNode = q.poll();
      Integer left = list.get(i++);
      if (left != null) {
        currentNode.left = new TreeNode(left);
        q.add(currentNode.left);
      }
      if (i < list.size()) {
        Integer right = list.get(i++);
        if (right != null) {
          currentNode.right = new TreeNode(right);
          q.add(currentNode.right);
        }
      }
    }

    return root;
  }

  public static TreeNode empty() {
    return null;
  }

  public static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
      this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
