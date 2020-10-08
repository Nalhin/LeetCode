package com.leetcode.design.easy;

// Design a stack that supports push, pop, top, and retrieving the minimum elemen
// t in constant time.
//
//
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
//
//
//
// Example 1:
//
//
// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]
//
// Output
// [null,null,null,null,-3,null,0,-2]
//
// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2
//
//
//
// Constraints:
//
//
// Methods pop, top and getMin operations will always be called on non-empty sta
// cks.
//
// Related Topics Stack Design
// 👍 3932 👎 370

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;

public class MinStack_155 {
  static class MinStack {

    private final ArrayDeque<StackItem> stack = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
      if (stack.isEmpty()) {
        stack.push(new StackItem(x, x));
      } else {
        stack.push(new StackItem(x, Math.min(stack.peek().min, x)));
      }
    }

    public void pop() {
      stack.pop();
    }

    public int top() {
      return stack.peek().val;
    }

    public int getMin() {
      return stack.peek().min;
    }

    private static class StackItem {
      public int val;
      public int min;

      public StackItem(int val, int min) {
        this.val = val;
        this.min = min;
      }
    }
  }
}
/*
 O(1) each operation Runtime: 4 ms, faster than 91.19% of Java online submissions for Min Stack.
 O(n) Memory Usage: 40.7 MB, less than 94.16% of Java online submissions for Min Stack.
*/

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// leetcode submit region end(Prohibit modification and deletion)
