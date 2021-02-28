package com.leetcode.design.hard;

// Implement FreqStack, a class which simulates the operation of a stack-like dat
// a structure.
//
// FreqStack has two functions:
//
//
// push(int x), which pushes an integer x onto the stack.
// pop(), which removes and returns the most frequent element in the stack.
//
// If there is a tie for most frequent element, the element closest to the top o
// f the stack is removed and returned.
//
//
//
//
//
//
// Example 1:
//
//
// Input:
// ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"
// ],
// [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
// Output: [null,null,null,null,null,null,null,5,7,5,4]
// Explanation:
// After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to t
// op.  Then:
//
// pop() -> returns 5, as 5 is the most frequent.
// The stack becomes [5,7,5,7,4].
//
// pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the t
// op.
// The stack becomes [5,7,5,4].
//
// pop() -> returns 5.
// The stack becomes [5,7,4].
//
// pop() -> returns 4.
// The stack becomes [5,7].
//
//
//
//
// Note:
//
//
// Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
// It is guaranteed that FreqStack.pop() won't be called if the stack has zero e
// lements.
// The total number of FreqStack.push calls will not exceed 10000 in a single te
// st case.
// The total number of FreqStack.pop calls will not exceed 10000 in a single tes
// t case.
// The total number of FreqStack.push and FreqStack.pop calls will not exceed 15
// 0000 across all test cases.
//
//
//
//
//
// Related Topics Hash Table Stack
// 👍 1405 👎 29

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 Runtime: 48 ms, faster than 19.27% of Java online submissions for Maximum Frequency Stack.
 Memory Usage: 51.7 MB, less than 15.70% of Java online submissions for Maximum Frequency Stack.

*/
public class MaximumFrequencyStack_895 {
  /*
   O(log(n)) Runtime: 46 ms, faster than 19.98% of Java online submissions for Maximum Frequency Stack.
   O(n) Memory Usage: 51.6 MB, less than 15.86% of Java online submissions for Maximum Frequency Stack.
  */
  static class FreqStackTreeSet {

    private final Map<Integer, Node> elements = new HashMap<>();
    private final TreeSet<Node> ordered = new TreeSet<>();
    private int insertionIndex = 0;

    public FreqStackTreeSet() {}

    public void push(int x) {
      if (elements.containsKey(x)) {
        Node node = elements.get(x);
        ordered.remove(node);
        node.increment(insertionIndex++);
        ordered.add(node);
      } else {
        Node node = new Node(x, insertionIndex++, 1);
        ordered.add(node);
        elements.put(x, node);
      }
    }

    public int pop() {
      Node el = ordered.first();
      ordered.remove(el);
      el.decrement();
      if (el.isEmpty()) {
        elements.remove(el.val);
      } else {
        ordered.add(el);
      }

      return el.getVal();
    }

    private static class Node implements Comparable<Node> {
      private final int val;
      private final Deque<Integer> insertedIndices = new ArrayDeque<>();
      private int frequency;

      Node(int val, int insertedIndex, int frequency) {
        this.val = val;
        this.insertedIndices.push(insertedIndex);
        this.frequency = frequency;
      }

      public boolean isEmpty() {
        return this.frequency == 0;
      }

      public void decrement() {
        insertedIndices.pop();
        frequency--;
      }

      public void increment(int index) {
        insertedIndices.push(index);
        frequency++;
      }

      public int getVal() {
        return val;
      }

      @Override
      public int compareTo(Node node) {
        int freq = -Integer.compare(frequency, node.frequency);

        if (freq != 0) {
          return freq;
        }

        return -Integer.compare(insertedIndices.peek(), node.insertedIndices.peek());
      }
    }
  }
  /*
   O(1) Runtime: 26 ms, faster than 81.05% of Java online submissions for Maximum Frequency Stack.
   O(n) Memory Usage: 47.6 MB, less than 94.37% of Java online submissions for Maximum Frequency Stack.
  */
  static class FreqStackListOfStacks {
    private final Map<Integer, Integer> frequencies = new HashMap<>();
    private final Map<Integer, Stack<Integer>> groups = new HashMap<>();
    private int maxFreq = 0;

    public FreqStackListOfStacks() {}

    public void push(int x) {
      int currFreq = frequencies.getOrDefault(x, 0) + 1;
      frequencies.put(x, currFreq);
      maxFreq = Math.max(maxFreq, currFreq);
      groups.computeIfAbsent(currFreq, (key) -> new Stack<>()).push(x);
    }

    public int pop() {
      int last = groups.get(maxFreq).pop();
      frequencies.put(last, frequencies.get(last) - 1);
      if (groups.get(maxFreq).size() == 0) {
        maxFreq--;
      }
      return last;
    }
  }
}

/**
 * Your FreqStack object will be instantiated and called as such: FreqStack obj = new FreqStack();
 * obj.push(x); int param_2 = obj.pop();
 */
// leetcode submit region end(Prohibit modification and deletion)
