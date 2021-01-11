package com.leetcode.tree.medium;

// Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
//
//
// You can think of the left and right pointers as synonymous to the predecessor
// and successor pointers in a doubly-linked list. For a circular doubly linked li
// st, the predecessor of the first element is the last element, and the successor
// of the last element is the first element.
//
// We want to do the transformation in place. After the transformation, the left
// pointer of the tree node should point to its predecessor, and the right pointer
// should point to its successor. You should return the pointer to the smallest el
// ement of the linked list.
//
//
// Example 1:
//
//
//
//
// Input: root = [4,2,5,1,3]
//
//
// Output: [1,2,3,4,5]
//
// Explanation: The figure below shows the transformed BST. The solid line indica
// tes the successor relationship, while the dashed line means the predecessor rela
// tionship.
//
//
//
// Example 2:
//
//
// Input: root = [2,1,3]
// Output: [1,2,3]
//
//
// Example 3:
//
//
// Input: root = []
// Output: []
// Explanation: Input is an empty tree. Output is also an empty Linked List.
//
//
// Example 4:
//
//
// Input: root = [1]
// Output: [1]
//
//
//
// Constraints:
//
//
// -1000 <= Node.val <= 1000
// Node.left.val < Node.val < Node.right.val
// All values of Node.val are unique.
// 0 <= Number of Nodes <= 2000
//
// Related Topics Linked List Divide and Conquer Tree
// 👍 1141 👎 104

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

import java.util.ArrayDeque;
import java.util.Deque;
/*
O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
O(n) Memory Usage: 38.6 MB, less than 23.14% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
 */
// leetcode submit region end(Prohibit modification and deletion)
public class ConvertBinarySearchTreeToSortedDoublyLinkedList_426 {
  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    Node dummy = new Node();
    Node listBuilder = dummy;
    Deque<Node> deque = new ArrayDeque<>();
    Node curr = root;

    while (!deque.isEmpty() || curr != null) {
      while (curr != null) {
        deque.push(curr);
        curr = curr.left;
      }
      Node prev = deque.pop();
      listBuilder.right = prev;
      prev.left = listBuilder;
      listBuilder = listBuilder.right;
      curr = prev.right;
    }
    listBuilder.right = dummy.right;
    dummy.right.left = listBuilder;
    return dummy.right;
  }

  private static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }
}
