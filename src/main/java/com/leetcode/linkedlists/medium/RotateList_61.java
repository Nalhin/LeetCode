package com.leetcode.linkedlists.medium;

// Given a linked list, rotate the list to the right by k places, where k is non-
// negative.
//
// Example 1:
//
//
// Input: 1->2->3->4->5->NULL, k = 2
// Output: 4->5->1->2->3->NULL
// Explanation:
// rotate 1 steps to the right: 5->1->2->3->4->NULL
// rotate 2 steps to the right: 4->5->1->2->3->NULL
//
//
// Example 2:
//
//
// Input: 0->1->2->NULL, k = 4
// Output: 2->0->1->NULL
// Explanation:
// rotate 1 steps to the right: 2->0->1->NULL
// rotate 2 steps to the right: 1->2->0->NULL
// rotate 3 steps to the right: 0->1->2->NULL
// rotate 4 steps to the right: 2->0->1->NULL
// Related Topics Linked List Two Pointers
// 👍 1468 👎 1046

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class RotateList_61 {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode tail = head;

    int size;
    for (size = 1; tail.next != null; size++) {
      tail = tail.next;
    }

    tail.next = head;
    ListNode new_tail = head;

    for (int i = 0; i < size - k % size - 1; i++) {
      new_tail = new_tail.next;
    }

    ListNode new_head = new_tail.next;

    new_tail.next = null;

    return new_head;
  }
}

/*
 O(n) Runtime: 1 ms, faster than 42.87% of Java online submissions for Rotate List.
 O(1) Memory Usage: 40.7 MB, less than 5.58% of Java online submissions for Rotate List.

*/

// leetcode submit region end(Prohibit modification and deletion)
