package com.leetcode.linkedlists.medium;

// Given a singly linked list, return a random node's value from the linked list.
// Each node must have the same probability of being chosen.
//
// Follow up:
// What if the linked list is extremely large and its length is unknown to you? C
// ould you solve this efficiently without using extra space?
//
//
// Example:
//
//// Init a singly linked list [1,2,3].
// ListNode head = new ListNode(1);
// head.next = new ListNode(2);
// head.next.next = new ListNode(3);
// Solution solution = new Solution(head);
//
//// getRandom() should return either 1, 2, or 3 randomly. Each element should h
// ave equal probability of returning.
// solution.getRandom();
//
// Related Topics Reservoir Sampling
// 👍 673 👎 183

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class LinkedListRandomNode_382 {
  /*
   O(1) Runtime: 13 ms, faster than 47.33% of Java online submissions for Linked List Random Node.
   O(n) Memory Usage: 41.1 MB, less than 32.48% of Java online submissions for Linked List Random Node.
  */
  static class Solution {

    private final Random random = new Random();
    private final List<Integer> list;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
     *     contains at least one node.
     */
    public Solution(ListNode head) {
      list = new ArrayList<>();
      while (head != null) {
        list.add(head.val);
        head = head.next;
      }
    }

    /** Returns a random node's value. */
    public int getRandom() {
      int rand = random.nextInt(list.size());
      return list.get(rand);
    }
  }

  /*
   O(n) Runtime: 16 ms, faster than 14.27% of Java online submissions for Linked List Random Node.
   O(1) Memory Usage: 40.9 MB, less than 51.97% of Java online submissions for Linked List Random Node.
  */
  static class SolutionSampling {

    private final Random random = new Random();
    private final ListNode head;
    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
     *     contains at least one node.
     */
    public SolutionSampling(ListNode head) {
      this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
      ListNode curr = head;
      int count = 1;
      int result = -1;

      while (curr != null) {

        if (random.nextFloat() < 1.0 / count) {
          result = curr.val;
        }
        curr = curr.next;
        count++;
      }

      return result;
    }
  }
}

/*
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// leetcode submit region end(Prohibit modification and deletion)
