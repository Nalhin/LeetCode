package com.leetcode.linkedlists.medium;

// Given a linked list, remove the n-th node from the end of list and return its
// head.
//
// Example:
//
//
// Given linked list: 1->2->3->4->5, and n = 2.
//
// After removing the second node from the end, the linked list becomes 1->2->3->
// 5.
//
//
// Note:
//
// Given n will always be valid.
//
// Follow up:
//
// Could you do this in one pass?
// Related Topics Linked List Two Pointers
// 👍 3854 👎 246

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class RemoveNthNodeFromEndOfList_19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
  }
}
/*
  O(n) Runtime: 1 ms, faster than 28.55% of Java online submissions for Remove Nth Node From End of List.
  O(1) Memory Usage: 39.8 MB, less than 7.70% of Java online submissions for Remove Nth Node From End of List.
*/

// leetcode submit region end(Prohibit modification and deletion)
