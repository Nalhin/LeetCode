package com.leetcode.design.easy;
// Implement a last in first out (LIFO) stack using only two queues. The implemen
// ted stack should support all the functions of a normal queue (push, top, pop, an
// d empty).
//
// Implement the MyStack class:
//
//
// void push(int x) Pushes element x to the top of the stack.
// int pop() Removes the element on the top of the stack and returns it.
// int top() Returns the element on the top of the stack.
// boolean empty() Returns true if the stack is empty, false otherwise.
//
//
// Notes:
//
//
// You must use only standard operations of a queue, which means only push to ba
// ck, peek/pop from front, size, and is empty operations are valid.
// Depending on your language, the queue may not be supported natively. You may
// simulate a queue using a list or deque (double-ended queue), as long as you use
// only a queue's standard operations.
//
//
// Follow-up: Can you implement the stack such that each operation is amortized
// O(1) time complexity? In other words, performing n operations will take overall
// O(n) time even if one of those operations may take longer.
//
//
// Example 1:
//
//
// Input
// ["MyStack", "push", "push", "top", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 2, 2, false]
//
// Explanation
// MyStack myStack = new MyStack();
// myStack.push(1);
// myStack.push(2);
// myStack.top(); // return 2
// myStack.pop(); // return 2
// myStack.empty(); // return False
//
//
//
// Constraints:
//
//
// 1 <= x <= 9
// At most 100 calls will be made to push, pop, top, and empty.
// All the calls to pop and top are valid.
//
// Related Topics Stack Design
// 👍 804 👎 604

import java.util.ArrayDeque;
import java.util.Queue;

// leetcode submit region begin(Prohibit modification and deletion)
public class ImplementStackUsingQueues_225 {
  static class MyStack {

    private final Queue<Integer> queue = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack() {}

    /** Push element x onto stack. */
    public void push(int x) {
      int size = queue.size();
      queue.add(x);
      while (size-- > 0) {
        queue.add(queue.poll());
      }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      return queue.remove();
    }

    /** Get the top element. */
    public int top() {
      return queue.element();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return queue.isEmpty();
    }
  }
}
/*
 O(1) pop
 O(n) push

      Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
 O(n) Memory Usage: 36.4 MB, less than 17.24% of Java online submissions for Implement Stack using Queues.
*/
/*
 * Your MyStack object will be instantiated and called as such: MyStack obj = new MyStack();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top(); boolean param_4 = obj.empty();
 */
// leetcode submit region end(Prohibit modification and deletion)
