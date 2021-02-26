package com.leetcode.stack.medium;

// Given two sequences pushed and popped with distinct values, return true if and
// only if this could have been the result of a sequence of push and pop operation
// s on an initially empty stack.
//
//
//
//
// Example 1:
//
//
// Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
// Output: true
// Explanation: We might do the following sequence:
// push(1), push(2), push(3), push(4), pop() -> 4,
// push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//
//
//
// Example 2:
//
//
// Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
// Output: false
// Explanation: 1 cannot be popped before 2.
//
//
//
//
//
// Constraints:
//
//
// 0 <= pushed.length == popped.length <= 1000
// 0 <= pushed[i], popped[i] < 1000
// pushed is a permutation of popped.
// pushed and popped have distinct values.
//
// Related Topics Stack
// 👍 1502 👎 34

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 95.06% of Java online submissions for Validate Stack Sequences.
 O(n) Memory Usage: 38.4 MB, less than 90.47% of Java online submissions for Validate Stack Sequences.
*/
import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences_946 {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int poppedIndex = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int num : pushed) {
      stack.push(num);

      while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
        stack.pop();
        poppedIndex++;
      }
    }

    return stack.size() == 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
