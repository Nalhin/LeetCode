package com.leetcode.tree.medium;

// Given a root of an N-ary tree, return a deep copy (clone) of the tree.
//
// Each node in the n-ary tree contains a val (int) and a list (List[Node]) of i
// ts children.
//
//
// class Node {
//    public int val;
//    public List<Node> children;
// }
//
//
// Nary-Tree input serialization is represented in their level order traversal,
// each group of children is separated by the null value (See examples).
//
// Follow up: Can your solution work for the graph problem?
//
//
// Example 1:
//
//
//
//
// Input: root = [1,null,3,2,4,null,5,6]
// Output: [1,null,3,2,4,null,5,6]
//
//
// Example 2:
//
//
//
//
// Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
// ,12,null,13,null,null,14]
// Output: [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,nu
// ll,13,null,null,14]
//
//
//
// Constraints:
//
//
// The depth of the n-ary tree is less than or equal to 1000.
// The total number of nodes is between [0, 10^4].
//
// Related Topics Hash Table Tree Depth-first Search Breadth-first Search
// 👍 95 👎 5

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/

import java.util.ArrayList;
import java.util.List;
/*
 O(n) Runtime: 1 ms, faster than 91.40% of Java online submissions for Clone N-ary Tree.
 O(n) Memory Usage: 40.9 MB, less than 33.70% of Java online submissions for Clone N-ary Tree.
*/
public class CloneNaryTree_1490 {
  public Node cloneTree(Node root) {
    if (root == null) {
      return null;
    }

    Node clone = new Node(root.val, new ArrayList<>());

    for (Node child : root.children) {
      clone.children.add(cloneTree(child));
    }

    return clone;
  }

  private static class Node {
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
}
// leetcode submit region end(Prohibit modification and deletion)
