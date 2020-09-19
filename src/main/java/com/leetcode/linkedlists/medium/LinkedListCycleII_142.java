package com.leetcode.linkedlists.medium;

// Given a linked list, return the node where the cycle begins. If there is no cy
// cle, return null.
//
// There is a cycle in a linked list if there is some node in the list that can
// be reached again by continuously following the next pointer. Internally, pos is
// used to denote the index of the node that tail's next pointer is connected to. N
// ote that pos is not passed as a parameter.
//
// Notice that you should not modify the linked list.
//
// Follow up:
//
// Can you solve it using O(1) (i.e. constant) memory?
//
//
// Example 1:
//
//
// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the s
// econd node.
//
//
// Example 2:
//
//
// Input: head = [1,2], pos = 0
// Output: tail connects to node index 0
// Explanation: There is a cycle in the linked list, where tail connects to the f
// irst node.
//
//
// Example 3:
//
//
// Input: head = [1], pos = -1
// Output: no cycle
// Explanation: There is no cycle in the linked list.
//
//
//
// Constraints:
//
//
// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list.
//
// Related Topics Linked List Two Pointers
// 👍 3072 👎 244

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val
 * = x; next = null; } }
 */
public class LinkedListCycleII_142 {

  public static class HashSetSolution {
    public ListNode detectCycle(ListNode head) {
      ListNode curr = head;
      Set<ListNode> visited = new HashSet<>();

      while (curr != null && visited.add(curr)) {
        curr = curr.next;
      }
      return curr;
    }
  }
  /*
   O(n) Runtime: 3 ms, faster than 25.47% of Java online submissions for Linked List Cycle II.
   O(n) Memory Usage: 40.4 MB, less than 39.08% of Java online submissions for Linked List Cycle II.
  */

  public static class TwoPointerSolution {
    public ListNode detectCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (slow == fast) {
          ListNode start = head;

          while (start != slow) {
            start = start.next;
            slow = slow.next;
          }

          return start;
        }
      }
      return null;
    }
  }
  /*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
   O(1) Memory Usage: 39.3 MB, less than 88.64% of Java online submissions for Linked List Cycle II.
  */
}
// leetcode submit region end(Prohibit modification and deletion)
