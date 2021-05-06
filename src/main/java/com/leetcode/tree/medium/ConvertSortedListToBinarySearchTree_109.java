package com.leetcode.tree.medium;

// Given the head of a singly linked list where elements are sorted in ascending
// order, convert it to a height balanced BST.
//
// For this problem, a height-balanced binary tree is defined as a binary tree i
// n which the depth of the two subtrees of every node never differ by more than 1.
//
//
//
// Example 1:
//
//
// Input: head = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the
// shown height balanced BST.
//
//
// Example 2:
//
//
// Input: head = []
// Output: []
//
//
// Example 3:
//
//
// Input: head = [0]
// Output: [0]
//
//
// Example 4:
//
//
// Input: head = [1,3]
// Output: [3,1]
//
//
//
// Constraints:
//
//
// The number of nodes in head is in the range [0, 2 * 104].
// -10^5 <= Node.val <= 10^5
//
// Related Topics Linked List Depth-first Search
// 👍 3067 👎 98

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;
import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
 O(nlog(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted List to Binary Search Tree.
 O(log(n) Memory Usage: 40.1 MB, less than 36.12% of Java online submissions for Convert Sorted List to Binary Search Tree.
*/
public class ConvertSortedListToBinarySearchTree_109 {
  public TreeNode sortedListToBST(ListNode head) {
    int size = 0;
    ListNode curr = head;
    while (curr != null) {
      curr = curr.next;
      size++;
    }
    return toTreeDfs(head, size);
  }

  public TreeNode toTreeDfs(ListNode head, int size) {
    if (size == 0) {
      return null;
    }
    if (size == 1) {
      return new TreeNode(head.val, null, null);
    }

    ListNode curr = head;
    for (int i = 0; i < (size + 1) / 2 - 1; i++) {
      curr = curr.next;
    }

    return new TreeNode(
        curr.val, toTreeDfs(head, (size + 1) / 2 - 1), toTreeDfs(curr.next, size / 2));
  }
}
// leetcode submit region end(Prohibit modification and deletion)
