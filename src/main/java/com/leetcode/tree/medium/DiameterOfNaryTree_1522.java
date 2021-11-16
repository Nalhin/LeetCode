package com.leetcode.tree.medium;

import java.util.ArrayList;
import java.util.List;

class Node {
  public int val;
  public List<Node> children;

  public Node() {
    children = new ArrayList<>();
  }

  public Node(int _val) {
    val = _val;
    children = new ArrayList<>();
  }

  public Node(int _val, ArrayList<Node> _children) {
    val = _val;
    children = _children;
  }
}

/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of N-Ary Tree.
  O(h) Memory Usage: 39.3 MB, less than 54.34% of Java online submissions for Diameter of N-Ary Tree.
*/

public class DiameterOfNaryTree_1522 {
  private int result = 0;

  public int diameter(Node root) {
    return Math.max(diameterDfs(root), result) - 1;
  }

  private int diameterDfs(Node root) {
    if (root == null) {
      return 0;
    }

    if (root.children.isEmpty()) {
      return 1;
    }

    int[] maxAndSecondMax = findMaxAndSecondMax(root.children);
    int max = maxAndSecondMax[0];
    int secondMax = maxAndSecondMax[1];

    if (max != -1 && secondMax != -1) {
      result = Math.max(max + secondMax + 1, result);
    }

    return max + 1;
  }

  private int[] findMaxAndSecondMax(List<Node> children) {
    int max = -1;
    int secondMax = -1;

    for (Node n : children) {
      int score = diameterDfs(n);

      if (score > max) {
        secondMax = max;
        max = score;
      } else if (score > secondMax) {
        secondMax = score;
      }
    }

    return new int[] {max, secondMax};
  }
}
