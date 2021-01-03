package com.leetcode.linkedlists.medium;

// Given a linked list and a value x, partition it such that all nodes less than
// x come before nodes greater than or equal to x.
//
// You should preserve the original relative order of the nodes in each of the t
// wo partitions.
//
// Example:
//
//
// Input: head = 1->4->3->2->5->2, x = 3
// Output: 1->2->2->4->3->5
//
// Related Topics Linked List Two Pointers
// 👍 1727 👎 348

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
 O(1) Memory Usage: 38.4 MB, less than 38.36% of Java online submissions for Partition List.
*/
public class PartitionList_86 {
  public ListNode partition(ListNode head, int x) {
    ListNode dummyLeft = new ListNode();
    ListNode dummyRight = new ListNode();

    ListNode currLeft = dummyLeft;
    ListNode currRight = dummyRight;

    while (head != null) {
      if (head.val < x) {
        currLeft.next = head;
        currLeft = currLeft.next;
      } else {
        currRight.next = head;
        currRight = currRight.next;
      }
      head = head.next;
    }

    currLeft.next = dummyRight.next;
    currRight.next = null;

    return dummyLeft.next;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
