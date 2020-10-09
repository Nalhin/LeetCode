package com.leetcode.linkedlists.easy;

// Given head which is a reference node to a singly-linked list. The value of eac
// h node in the linked list is either 0 or 1. The linked list holds the binary rep
// resentation of a number.
//
// Return the decimal value of the number in the linked list.
//
//
// Example 1:
//
//
// Input: head = [1,0,1]
// Output: 5
// Explanation: (101) in base 2 = (5) in base 10
//
//
// Example 2:
//
//
// Input: head = [0]
// Output: 0
//
//
// Example 3:
//
//
// Input: head = [1]
// Output: 1
//
//
// Example 4:
//
//
// Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
// Output: 18880
//
//
// Example 5:
//
//
// Input: head = [0,0]
// Output: 0
//
//
//
// Constraints:
//
//
// The Linked List is not empty.
// Number of nodes will not exceed 30.
// Each node's value is either 0 or 1.
// Related Topics Linked List Bit Manipulation
// 👍 647 👎 48

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class ConvertBinaryNumberInALinkedListToInteger_1290 {
  public int getDecimalValue(ListNode head) {
    ListNode curr = head;
    int result = 0;
    while (curr != null) {
      result <<= 1;
      result += curr.val;
      curr = curr.next;
    }
    return result;
  }
}
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
 O(1) Memory Usage: 36.1 MB, less than 99.48% of Java online submissions for Convert Binary Number in a Linked List to Integer.
*/
// leetcode submit region end(Prohibit modification and deletion)
