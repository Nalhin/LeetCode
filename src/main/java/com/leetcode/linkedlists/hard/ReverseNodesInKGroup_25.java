package com.leetcode.linkedlists.hard;

// Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list.
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is.
//
// You may not alter the values in the list's nodes, only nodes themselves may b
// e changed.
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
//
//
// Example 2:
//
//
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
//
//
// Example 3:
//
//
// Input: head = [1,2,3,4,5], k = 1
// Output: [1,2,3,4,5]
//
//
// Example 4:
//
//
// Input: head = [1], k = 1
// Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range sz.
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
//
//
// Follow-up: Can you solve the problem in O(1) extra memory space? Related Topic
// s Linked List Recursion
// 👍 4267 👎 419
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
 O(1) Memory Usage: 39.6 MB, less than 26.40% of Java online submissions for Reverse Nodes in k-Group.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class ReverseNodesInKGroup_25 {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;

    ListNode dummyHead = new ListNode();
    ListNode prev = dummyHead;

    while (curr != null) {
      if (!shouldReverseGroup(curr, k)) {
        prev.next = curr;
        return dummyHead.next;
      }

      int size = 0;
      ListNode reversed = null;
      ListNode lastNode = curr;

      while (size < k) {
        size++;
        ListNode next = curr.next;
        curr.next = reversed;
        reversed = curr;
        curr = next;
      }

      prev.next = reversed;
      prev = lastNode;
    }

    return dummyHead.next;
  }

  private boolean shouldReverseGroup(ListNode curr, int k) {
    int len = 0;
    while (curr != null && len < k) {
      curr = curr.next;
      len++;
    }
    return len == k;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
