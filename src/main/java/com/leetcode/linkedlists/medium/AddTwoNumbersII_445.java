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
// 👍 1820 👎 177

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n + m) Runtime: 3 ms, faster than 65.39% of Java online submissions for Add Two Numbers II.
 O(n + m) Memory Usage: 39.6 MB, less than 9.36% of Java online submissions for Add Two Numbers II.
*/
public class AddTwoNumbersII_445 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<ListNode> stack1 = new ArrayDeque<>();
    Deque<ListNode> stack2 = new ArrayDeque<>();
    ListNode result = null;

    while (l1 != null) {
      stack1.push(l1);
      l1 = l1.next;
    }

    while (l2 != null) {
      stack2.push(l2);
      l2 = l2.next;
    }

    int overflow = 0;
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      ListNode first = stack1.poll();
      ListNode second = stack2.poll();

      int firstVal = first == null ? 0 : first.val;
      int secondVal = second == null ? 0 : second.val;

      int val = firstVal + secondVal + overflow;
      overflow = val / 10;

      ListNode curr = new ListNode(val % 10);
      curr.next = result;
      result = curr;
    }

    if (overflow != 0) {
      ListNode curr = new ListNode(overflow);
      curr.next = result;
      result = curr;
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
