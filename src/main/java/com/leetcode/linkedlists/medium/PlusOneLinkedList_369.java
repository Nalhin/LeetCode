package com.leetcode.linkedlists.medium;

// Given a non-negative integer represented as non-empty a singly linked list of
// digits, plus one to the integer.
//
// You may assume the integer do not contain any leading zero, except the number
// 0 itself.
//
// The digits are stored such that the most significant digit is at the head of
// the list.
//
//
// Example :
//
//
// Input: [1,2,3]
// Output: [1,2,4]
//
//
// Related Topics Linked List
// 👍 509 👎 32

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One Linked List.
 O(n) Memory Usage: 36.1 MB, less than 99.30% of Java online submissions for Plus One Linked List.
*/
public class PlusOneLinkedList_369 {
  public ListNode plusOne(ListNode head) {
    ListNode curr = head;

    Deque<ListNode> deque = new ArrayDeque<>();

    while (curr != null) {
      deque.push(curr);
      curr = curr.next;
    }

    int over = 1;

    while (over != 0) {
      if (deque.isEmpty()) {
        ListNode node = new ListNode(1);
        node.next = curr;
        return node;
      }
      curr = deque.pop();
      int temp = curr.val;
      curr.val = (curr.val + over) % 10;
      over = (temp + over) / 10;
    }
    return head;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
