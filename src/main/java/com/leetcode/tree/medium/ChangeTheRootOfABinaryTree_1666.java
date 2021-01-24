package com.leetcode.tree.medium;

// Given the root of a binary tree and a leaf node, reroot the tree so that the l
// eaf is the new root.
//
// You can reroot the tree with the following steps for each node cur on the pat
// h starting from the leaf up to the root excluding the root:
//
//
// If cur has a left child, then that child becomes cur's right child.
// cur's original parent becomes cur's left child. Note that in this process the
// original parent's pointer to cur becomes null, making it have at most one child
// .
//
//
// Return the new root of the rerooted tree.
//
// Note: Ensure that your solution sets the Node.parent pointers correctly after
// rerooting or you will receive "Wrong Answer".
//
//
// Example 1:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], leaf = 7
// Output: [7,2,null,5,4,3,6,null,null,null,1,null,null,0,8]
//
//
// Example 2:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], leaf = 0
// Output: [0,1,null,3,8,5,null,null,null,6,2,null,null,7,4]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 100].
// -109 <= Node.val <= 109
// All Node.val are unique.
// leaf exist in the tree.
//
// Related Topics Tree Depth-first Search
// 👍 21 👎 45

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
/*
 O(h) Runtime: 12 ms, faster than 65.72% of Java online submissions for Change the Root of a Binary Tree.
 O(h) Memory Usage: 38.4 MB, less than 47.42% of Java online submissions for Change the Root of a Binary Tree.
*/
public class ChangeTheRootOfABinaryTree_1666 {
  public Node flipBinaryTree(Node root, Node leaf) {
    reRoot(root, root, leaf);
    leaf.parent = null;
    return leaf;
  }

  private Node reRoot(Node root, Node prev, Node curr) {

    Node parent = curr.parent;

    if (curr.left != prev) {
      curr.right = curr.left;
    } else {
      curr.parent = curr.left;
    }

    if (parent == root) {
      if (root.left == curr) {
        root.left = null;
      } else {
        root.right = null;
      }
      root.parent = curr;
      curr.left = root;
      curr.parent = prev;
      return curr;
    }

    curr.left = reRoot(root, curr, parent);

    return curr;
  }

  private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
