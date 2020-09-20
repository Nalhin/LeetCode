package com.leetcode.linkedlists.easy;

// Given a singly linked list, determine if it is a palindrome.
//
// Example 1:
//
//
// Input: 1->2
// Output: false
//
// Example 2:
//
//
// Input: 1->2->2->1
// Output: true
//
// Follow up:
// Could you do it in O(n) time and O(1) space?
// Related Topics Linked List Two Pointers
// 👍 3686 👎 382

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class PalindromeLinkedList_234 {
  public boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode reversed = reverse(slow);
    ListNode left = head;
    while (reversed != null) {
      if (left.val != reversed.val) {
        return false;
      }
      left = left.next;
      reversed = reversed.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    ListNode curr = head;
    ListNode reversed = null;
    while (curr != null) {
      ListNode temp = curr;
      curr = curr.next;
      temp.next = reversed;
      reversed = temp;
    }
    return reversed;
  }
}

/*
 O(n) Runtime: 1 ms, faster than 96.69% of Java online submissions for Palindrome Linked List.
 O(1) Memory Usage: 42.1 MB, less than 73.52% of Java online submissions for Palindrome Linked List.
*/
// leetcode submit region end(Prohibit modification and deletion)
