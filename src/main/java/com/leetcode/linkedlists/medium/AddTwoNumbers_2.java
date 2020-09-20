package com.leetcode.linkedlists.medium;

// You are given two non-empty linked lists representing two non-negative integer
// s. The most significant digit comes first and each of their nodes contain a sing
// le digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the nu
// mber 0 itself.
//
// Follow up:
// What if you cannot modify the input lists? In other words, reversing the lists
// is not allowed.
//
//
//
// Example:
//
// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7
//
// Related Topics Linked List
// 👍 1639 👎 164

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class AddTwoNumbers_2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    int over = 0;

    while (l1 != null || l2 != null) {
      int l1Val = l1 != null ? l1.val : 0;
      int l2Val = l2 != null ? l2.val : 0;
      int sum = l1Val + l2Val + over;

      over = sum / 10;

      curr.next = new ListNode(sum % 10);
      curr = curr.next;

      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }

    if (over > 0) {
      curr.next = new ListNode(over);
    }

    return dummy.next;
  }
}
/*
 O(max(n+m)) Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
 O(max(n+m)) Memory Usage: 39.6 MB, less than 60.29% of Java online submissions for Add Two Numbers.
*/
// leetcode submit region end(Prohibit modification and deletion)
