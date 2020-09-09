package easy;// Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists.
//
// Example:
//
//
// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4
//
// Related Topics Linked List
// 👍 4772 👎 619

// leetcode submit region begin(Prohibit modification and deletion)

public class MergeTwoSortedLists_21 {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode curr = result;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }

    if (l1 != null) {
      curr.next = l1;
    } else {
      curr.next = l2;
    }
    return result.next;
  }
}
/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
    Memory Usage: 39.3 MB, less than 53.32% of Java online submissions for Merge Two Sorted Lists.
*/

// leetcode submit region end(Prohibit modification and deletion)
