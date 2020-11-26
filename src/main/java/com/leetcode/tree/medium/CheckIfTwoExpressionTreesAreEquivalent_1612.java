package com.leetcode.tree.medium;

// A binary expression tree is a kind of binary tree used to represent arithmetic
// expressions. Each node of a binary expression tree has either zero or two child
// ren. Leaf nodes (nodes with 0 children) correspond to operands (variables), and
// internal nodes (nodes with two children) correspond to the operators. In this pr
// oblem, we only consider the '+' operator (i.e. addition).
//
// You are given the roots of two binary expression trees, root1 and root2. Retu
// rn true if the two binary expression trees are equivalent. Otherwise, return fal
// se.
//
// Two binary expression trees are equivalent if they evaluate to the same value
// regardless of what the variables are set to.
//
// Follow up: What will you change in your solution if the tree also supports th
// e '-' operator (i.e. subtraction)?
//
//
// Example 1:
//
//
// Input: root1 = [x], root2 = [x]
// Output: true
//
//
// Example 2:
//
//
//
//
// Input: root1 = [+,a,+,null,null,b,c], root2 = [+,+,b,c,a]
// Output: true
// Explaination: a + (b + c) == (b + c) + a
//
// Example 3:
//
//
//
//
// Input: root1 = [+,a,+,null,null,b,c], root2 = [+,+,b,d,a]
// Output: false
// Explaination: a + (b + c) != (b + d) + a
//
//
//
// Constraints:
//
//
// The number of nodes in both trees are equal, odd and, in the range [1, 4999].
//
// Node.val is '+' or a lower-case English letter.
// It's guaranteed that the tree given is a valid binary expression tree.
//
// Related Topics Hash Table Tree
// 👍 39 👎 4

// leetcode submit region begin(Prohibit modification and deletion)
/*
 * Definition for a binary tree node. class Node { char val; Node left; Node right; Node() {this.val
 * = ' ';} Node(char val) { this.val = val; } Node(char val, Node left, Node right) { this.val =
 * val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 5 ms, faster than 87.98% of Java online submissions for Check If Two Expression Trees are Equivalent.
 O(h) Memory Usage: 42.8 MB, less than 51.37% of Java online submissions for Check If Two Expression Trees are Equivalent.
*/
public class CheckIfTwoExpressionTreesAreEquivalent_1612 {
  public boolean checkEquivalence(Node root1, Node root2) {
    char[] count = new char[26];

    populateValues(root1, count);
    return validate(root2, count);
  }

  private void populateValues(Node root, char[] count) {
    if (root == null) {
      return;
    }
    if (root.val != '+') {
      count[root.val - 'a']++;
    }
    populateValues(root.left, count);
    populateValues(root.right, count);
  }

  private boolean validate(Node root, char[] count) {
    if (root == null) {
      return true;
    }

    if (root.val != '+') {
      if (count[root.val - 'a'] <= 0) {
        return false;
      }
      count[root.val - 'a']--;
    }

    return validate(root.left, count) && validate(root.right, count);
  }

  private static class Node {
    char val;
    Node left;
    Node right;

    Node() {
      this.val = ' ';
    }

    Node(char val) {
      this.val = val;
    }

    Node(char val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
