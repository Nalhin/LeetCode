package com.leetcode.linkedlists.medium;

//Given a node from a Circular Linked List which is sorted in ascending order, w
//rite a function to insert a value insertVal into the list such that it remains a
// sorted circular list. The given node can be a reference to any single node in t
//he list, and may not be necessarily the smallest value in the circular list.
//
// If there are multiple suitable places for insertion, you may choose any place
// to insert the new value. After the insertion, the circular list should remain s
//orted.
//
// If the list is empty (i.e., given node is null), you should create a new sing
//le circular list and return the reference to that single node. Otherwise, you sh
//ould return the original given node.
//
//
// Example 1:
//
//
//
//Input: head = [3,4,1], insertVal = 2
//Output: [3,4,1,2]
//Explanation: In the figure above, there is a sorted circular list of three ele
//ments. You are given a reference to the node with value 3, and we need to insert
// 2 into the list. The new node should be inserted between node 1 and node 3. Aft
//er the insertion, the list should look like this, and we should still return nod
//e 3.
//
//
//
//
//
// Example 2:
//
//
//Input: head = [], insertVal = 1
//Output: [1]
//Explanation: The list is empty (given head is null). We create a new single ci
//rcular list and return the reference to that single node.
//
//
// Example 3:
//
//
//Input: head = [1], insertVal = 0
//Output: [1,0]
//
//
//
// Constraints:
//
//
// 0 <= Number of Nodes <= 5 * 10^4
// -10^6 <= Node.val <= 10^6
// -10^6 <= insertVal <= 10^6
//
// Related Topics Linked List
// 👍 321 👎 321


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/


import com.leetcode.utils.LinkedList.ListNode;

public class InsertIntoASortedCircularLinkedList_708 {
  public ListNode insert(ListNode head, int insertVal) {
    ListNode curr = head;

    if (curr == null) {
      ListNode node = new ListNode(insertVal);
      node.next = node;
      return node;
    }

    while (curr.val <= curr.next.val && curr.next != head) {
      curr = curr.next;
    }

    if (curr.val > insertVal) {
      while (curr.next.val < insertVal) {
        curr = curr.next;
      }
    }

    curr.next = new ListNode(insertVal, curr.next);
    return head;
  }
}

/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Sorted Circular Linked List.
  O(1) Memory Usage: 39.1 MB, less than 66.27% of Java online submissions for Insert into a Sorted Circular Linked List.
 */

//leetcode submit region end(Prohibit modification and deletion)
