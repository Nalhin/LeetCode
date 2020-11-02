package com.leetcode.dp.medium;

// Imagine you have a special keyboard with the following keys:
// Key 1: (A): Print one 'A' on screen.
// Key 2: (Ctrl-A): Select the whole screen.
// Key 3: (Ctrl-C): Copy selection to buffer.
// Key 4: (Ctrl-V): Print buffer on screen appending it after what has already b
// een printed.
//
//
//
// Now, you can only press the keyboard for N times (with the above four keys),
// find out the maximum numbers of 'A' you can print on screen.
//
//
// Example 1:
//
// Input: N = 3
// Output: 3
// Explanation:
// We can at most get 3 A's on screen by pressing following key sequence:
// A, A, A
//
//
//
// Example 2:
//
// Input: N = 7
// Output: 9
// Explanation:
// We can at most get 9 A's on screen by pressing following key sequence:
// A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
//
//
//
// Note:
//
// 1 <= N <= 50
// Answers will be in the range of 32-bit signed integer.
//
//
// Related Topics Math Dynamic Programming Greedy
// 👍 393 👎 57

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for 4 Keys Keyboard.
 O(1)  Memory Usage: 35.7 MB, less than 11.05% of Java online submissions for 4 Keys Keyboard.
*/
public class FourKeysKeyboard_651 {
  public int maxA(int N) {
    if (N <= 6) {
      return N;
    }
    int[] dp = new int[N];

    for (int i = 0; i < 6; i++) {
      dp[i] = i + 1;
    }

    for (int i = 6; i < N; i++) {
      dp[i] = Math.max(dp[i - 5] * 4, dp[i - 4] * 3);
    }

    return dp[N - 1];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
