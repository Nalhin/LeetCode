package com.leetcode.linkedlists.medium;

// You are given the head of a linked list, and an integer k.
//
// Return the head of the linked list after swapping the values of the kth node
// from the beginning and the kth node from the end (the list is 1-indexed).
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]
//
//
// Example 2:
//
//
// Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
// Output: [7,9,6,6,8,7,3,0,9,5]
//
//
// Example 3:
//
//
// Input: head = [1], k = 1
// Output: [1]
//
//
// Example 4:
//
//
// Input: head = [1,2], k = 1
// Output: [2,1]
//
//
// Example 5:
//
//
// Input: head = [1,2,3], k = 2
// Output: [1,2,3]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is n.
// 1 <= k <= n <= 105
// 0 <= Node.val <= 100
//
// Related Topics Linked List
// 👍 309 👎 20

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n) Runtime: 4 ms, faster than 54.59% of Java online submissions for Swapping Nodes in a Linked List.
 O(1) Memory Usage: 65.2 MB, less than 60.65% of Java online submissions for Swapping Nodes in a Linked List.
*/

public class SwappingNodesInALinkedList_1721 {
  public ListNode swapNodes(ListNode head, int k) {

    ListNode curr = head;
    int len = 1;

    while (curr.next != null) {
      curr = curr.next;
      len++;
    }

    curr = head;
    int currLen = 1;

    ListNode leftNode = null;
    ListNode rightNode = null;
    while (leftNode == null || rightNode == null) {
      if (currLen == k) {
        leftNode = curr;
      }
      if (len == k) {
        rightNode = curr;
      }
      curr = curr.next;
      len--;
      currLen++;
    }

    int temp = leftNode.val;
    leftNode.val = rightNode.val;
    rightNode.val = temp;

    return head;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
