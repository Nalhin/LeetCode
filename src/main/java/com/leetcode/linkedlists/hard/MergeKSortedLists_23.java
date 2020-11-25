package com.leetcode.linkedlists.hard;

// You are given an array of k linked-lists lists, each linked-list is sorted in
// ascending order.
//
// Merge all the linked-lists into one sorted linked-list and return it.
//
//
// Example 1:
//
//
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//  1->4->5,
//  1->3->4,
//  2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
//
//
// Example 2:
//
//
// Input: lists = []
// Output: []
//
//
// Example 3:
//
//
// Input: lists = [[]]
// Output: []
//
//
//
// Constraints:
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] is sorted in ascending order.
// The sum of lists[i].length won't exceed 10^4.
//
// Related Topics Linked List Divide and Conquer Heap
// 👍 5829 👎 318

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(nlog(k)) Runtime: 5 ms, faster than 40.42% of Java online submissions for Merge k Sorted Lists.
 O(k) Memory Usage: 40.9 MB, less than 33.52% of Java online submissions for Merge k Sorted Lists.
*/
public class MergeKSortedLists_23 {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode();
    Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

    for (ListNode head : lists) {
      if (head != null) {
        pq.add(head);
      }
    }

    ListNode curr = dummy;
    while (!pq.isEmpty()) {
      ListNode next = pq.poll();
      curr.next = next;
      if (next.next != null) {
        pq.add(next.next);
      }
      curr = curr.next;
    }

    return dummy.next;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
