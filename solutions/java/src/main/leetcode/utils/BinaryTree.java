package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree {

  public static TreeNode of(Integer first, Integer... args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(args));
    list.add(0, first);
    return insert(0, list);
  }

  private static TreeNode insert(int pos, List<Integer> args) {
    Integer val = args.get(pos);
    TreeNode root = null;

    if (val != null) {
      root = new TreeNode(val);
      int left = pos * 2 + 1;
      int right = pos * 2 + 2;
      if (left < args.size()) {
        root.left = insert(left, args);
      }
      if (right < args.size()) {
        root.right = insert(right, args);
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
