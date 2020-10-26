package com.leetcode.linkedlists.easy;

// Given the head of a linked list and two integers m and n. Traverse the linked
// list and remove some nodes in the following way:
//
//
// Start with the head as the current node.
// Keep the first m nodes starting with the current node.
// Remove the next n nodes
// Keep repeating steps 2 and 3 until you reach the end of the list.
//
//
// Return the head of the modified list after removing the mentioned nodes.
//
// Follow up question: How can you solve this problem by modifying the list in-p
// lace?
//
//
// Example 1:
//
//
//
//
// Input: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
// Output: [1,2,6,7,11,12]
// Explanation: Keep the first (m = 2) nodes starting from the head of the linked
// List  (1 ->2) show in black nodes.
// Delete the next (n = 3) nodes (3 -> 4 -> 5) show in read nodes.
// Continue with the same procedure until reaching the tail of the Linked List.
// Head of linked list after removing nodes is returned.
//
// Example 2:
//
//
//
//
// Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
// Output: [1,5,9]
// Explanation: Head of linked list after removing nodes is returned.
//
// Example 3:
//
//
// Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1
// Output: [1,2,3,5,6,7,9,10,11]
//
//
// Example 4:
//
//
// Input: head = [9,3,7,7,9,10,8,2], m = 1, n = 2
// Output: [9,7,8]
//
//
//
// Constraints:
//
//
// The given linked list will contain between 1 and 10^4 nodes.
// The value of each node in the linked list will be in the range [1, 10^6].
// 1 <= m,n <= 1000
// Related Topics Linked List
// 👍 119 👎 2

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete N Nodes After M Nodes of a Linked List.
 O(1) Memory Usage: 39.9 MB, less than 12.42% of Java online submissions for Delete N Nodes After M Nodes of a Linked List.
*/
public class DeleteNNodesAfterMNodesOfALinkedList_1474 {
  public ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode curr = head;
    while (curr != null) {

      for (int i = m - 1; i > 0 && curr != null; i--) {
        curr = curr.next;
      }

      ListNode prev = curr;
      for (int i = n; i >= 0 && curr != null; i--) {
        curr = curr.next;
        prev.next = curr;
      }
    }

    return head;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
