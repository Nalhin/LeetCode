package com.leetcode.tree.medium;

// Given a binary tree root and a linked list with head as the first node.
//
// Return True if all the elements in the linked list starting from the head cor
// respond to some downward path connected in the binary tree otherwise return Fals
// e.
//
// In this context downward path means a path that starts at some node and goes
// downwards.
//
//
// Example 1:
//
//
//
//
// Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,n
// ull,1,3]
// Output: true
// Explanation: Nodes in blue form a subpath in the binary Tree.
//
//
// Example 2:
//
//
//
//
// Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null
// ,null,1,3]
// Output: true
//
//
// Example 3:
//
//
// Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,nu
// ll,null,1,3]
// Output: false
// Explanation: There is no path in the binary tree that contains all the element
// s of the linked list from head.
//
//
//
// Constraints:
//
//
// 1 <= node.val <= 100 for each node in the linked list and binary tree.
// The given linked list will contain between 1 and 100 nodes.
// The given binary tree will contain between 1 and 2500 nodes.
//
// Related Topics Linked List Dynamic Programming Tree
// 👍 636 👎 25

// leetcode submit region begin(Prohibit modification and deletion)
/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
import com.leetcode.utils.BinaryTree.TreeNode;
import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n^2) Runtime: 1 ms, faster than 99.54% of Java online submissions for Linked List in Binary Tree.
 O(n)  Memory Usage: 39 MB, less than 95.27% of Java online submissions for Linked List in Binary Tree
*/
// leetcode submit region end(Prohibit modification and deletion)
public class LinkedListInABinaryTree_1367 {
  public boolean isSubPath(ListNode head, TreeNode root) {
    return isSubPathDfs(head, root);
  }

  private boolean isSubPathDfs(ListNode head, TreeNode root) {
    if (root == null) {
      return false;
    }

    if (head.val == root.val && matchDfs(head, root)) {
      return true;
    }
    return isSubPathDfs(head, root.left) || isSubPathDfs(head, root.right);
  }

  private boolean matchDfs(ListNode head, TreeNode root) {
    if (head == null) {
      return true;
    }
    if (root == null) {
      return false;
    }
    if (head.val != root.val) {
      return false;
    }

    return matchDfs(head.next, root.left) || matchDfs(head.next, root.right);
  }
}
