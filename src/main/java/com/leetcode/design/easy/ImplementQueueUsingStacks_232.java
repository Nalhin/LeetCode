package com.leetcode.design.easy;

// Implement a first in first out (FIFO) queue using only two stacks. The impleme
// nted queue should support all the functions of a normal queue (push, peek, pop,
// and empty).
//
// Implement the MyQueue class:
//
//
// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.
//
//
// Notes:
//
//
// You must use only standard operations of a stack, which means only push to to
// p, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, the stack may not be supported natively. You may
// simulate a stack using a list or deque (double-ended queue) as long as you use o
// nly a stack's standard operations.
//
//
// Follow-up: Can you implement the queue such that each operation is amortized
// O(1) time complexity? In other words, performing n operations will take overall
// O(n) time even if one of those operations may take longer.
//
//
// Example 1:
//
//
// Input
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 1, 1, false]
//
// Explanation
// MyQueue myQueue = new MyQueue();
// myQueue.push(1); // queue is: [1]
// myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
// myQueue.peek(); // return 1
// myQueue.pop(); // return 1, queue is [2]
// myQueue.empty(); // return false
//
//
//
// Constraints:
//
//
// 1 <= x <= 9
// At most 100 calls will be made to push, pop, peek, and empty.
// All the calls to pop and peek are valid.
//
// Related Topics Stack Design
// 👍 1296 👎 150

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks_232 {
  static class MyQueue {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> backup = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyQueue() {}

    /** Push element x to the back of queue. */
    public void push(int x) {
      while (!stack.isEmpty()) {
        backup.push(stack.pop());
      }
      backup.push(x);
      while (!backup.isEmpty()) {
        stack.push(backup.pop());
      }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
      return stack.element();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return stack.isEmpty();
    }
  }

  static class MyQueueAmortized {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> reversed = new ArrayDeque<>();
    int front = 0;

    /** Initialize your data structure here. */
    public MyQueueAmortized() {}

    /** Push element x to the back of queue. */
    public void push(int x) {
      if (stack.isEmpty()) {
        front = x;
      }
      stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      if (reversed.isEmpty()) {
        while (!stack.isEmpty()) {
          reversed.push(stack.pop());
        }
      }
      return reversed.pop();
    }

    /** Get the front element. */
    public int peek() {
      return reversed.isEmpty() ? front : reversed.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return stack.isEmpty() && reversed.isEmpty();
    }
  }
}
/*

O(n) push (amortized impl O(1))
O(1) pop/peek/empty

     Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
O(n) Memory Usage: 36.7 MB, less than 16.75% of Java online submissions for Implement Queue using Stacks.
*/

/*
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */
// leetcode submit region end(Prohibit modification and deletion)
