package com.leetcode.greedy.hard;

// Given an array of integers target. From a starting array, A consisting of all
// 1's, you may perform the following procedure :
//
//
// let x be the sum of all elements currently in your array.
// choose index i, such that 0 <= i < target.size and set the value of A at inde
// x i to x.
// You may repeat this procedure as many times as needed.
//
//
// Return True if it is possible to construct the target array from A otherwise
// return False.
//
//
// Example 1:
//
//
// Input: target = [9,3,5]
// Output: true
// Explanation: Start with [1, 1, 1]
// [1, 1, 1], sum = 3 choose index 1
// [1, 3, 1], sum = 5 choose index 2
// [1, 3, 5], sum = 9 choose index 0
// [9, 3, 5] Done
//
//
// Example 2:
//
//
// Input: target = [1,1,1,2]
// Output: false
// Explanation: Impossible to create target array from [1,1,1,1].
//
//
// Example 3:
//
//
// Input: target = [8,5]
// Output: true
//
//
//
// Constraints:
//
//
// N == target.length
// 1 <= target.length <= 5 * 10^4
// 1 <= target[i] <= 10^9
//
// Related Topics Greedy
// 👍 308 👎 45
/*
 O(nlog(n) + log(m)) Runtime: 8 ms, faster than 38.24% of Java online submissions for Construct Target Array With Multiple Sums.
 O(n) Memory Usage: 47 MB, less than 5.88% of Java online submissions for Construct Target Array With Multiple Sums.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConstructTargetArrayWithMultipleSums_1354 {
  public boolean isPossible(int[] target) {
    if (target.length == 1) {
      return target[0] == 1;
    }
    int sum = Arrays.stream(target).sum();

    Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for (int val : target) {
      if (val != 1) {
        pq.add(val);
      }
    }

    while (!pq.isEmpty()) {
      int maxValue = pq.poll();
      int sumWithoutMax = sum - maxValue;

      if (maxValue == 1 || sumWithoutMax == 1) {
        return true;
      }

      int prevValue = maxValue % sumWithoutMax;
      sum = sumWithoutMax + prevValue;

      if (prevValue == 0 || prevValue == maxValue) {
        return false;
      }
      pq.add(prevValue);
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
