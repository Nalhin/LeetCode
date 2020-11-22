package com.leetcode.graph.medium;

// Given an array of non-negative integers arr, you are initially positioned at s
// tart index of the array. When you are at index i, you can jump to i + arr[i] or
// i - arr[i], check if you can reach to any index with value 0.
//
// Notice that you can not jump outside of the array at any time.
//
//
// Example 1:
//
//
// Input: arr = [4,2,3,0,3,1,2], start = 5
// Output: true
// Explanation:
// All possible ways to reach at index 3 with value 0 are:
// index 5 -> index 4 -> index 1 -> index 3
// index 5 -> index 6 -> index 4 -> index 1 -> index 3
//
//
// Example 2:
//
//
// Input: arr = [4,2,3,0,3,1,2], start = 0
// Output: true
// Explanation:
// One possible way to reach at index 3 with value 0 is:
// index 0 -> index 4 -> index 1 -> index 3
//
//
// Example 3:
//
//
// Input: arr = [3,0,2,1,2], start = 2
// Output: false
// Explanation: There is no way to reach at index 1 with value 0.
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 5 * 10^4
// 0 <= arr[i] < arr.length
// 0 <= start < arr.length
//
// Related Topics Breadth-first Search Graph
// 👍 702 👎 27

import java.util.ArrayDeque;
import java.util.Queue;

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Jump Game III.
  O(n) Memory Usage: 47.2 MB, less than 9.43% of Java online submissions for Jump Game III.
*/
public class JumpGameIII_1306 {
  public boolean canReach(int[] arr, int start) {
    boolean[] visited = new boolean[arr.length];
    Queue<Integer> queue = new ArrayDeque<>();

    visited[start] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
      int curr = queue.remove();

      if (arr[curr] == 0) {
        return true;
      }

      int left = curr - arr[curr];
      if (left >= 0 && left < arr.length && !visited[left]) {
        visited[left] = true;
        queue.add(left);
      }

      int right = curr + arr[curr];
      if (right >= 0 && right < arr.length && !visited[right]) {
        visited[right] = true;
        queue.add(right);
      }
    }
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
