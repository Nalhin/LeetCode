package com.leetcode.greedy.medium;

// You are given a 0-indexed integer array tasks, where tasks[i] represents the
// difficulty level of a task. In each round, you can complete either 2 or 3 tasks
// of the same difficulty level.
//
// Return the minimum rounds required to complete all the tasks, or -1 if it is
// not possible to complete all the tasks.
//
//
// Example 1:
//
//
// Input: tasks = [2,2,3,3,2,4,4,4,4,4]
// Output: 4
// Explanation: To complete all the tasks, a possible plan is:
// - In the first round, you complete 3 tasks of difficulty level 2.
// - In the second round, you complete 2 tasks of difficulty level 3.
// - In the third round, you complete 3 tasks of difficulty level 4.
// - In the fourth round, you complete 2 tasks of difficulty level 4.
// It can be shown that all the tasks cannot be completed in fewer than 4 rounds,
// so the answer is 4.
//
//
// Example 2:
//
//
// Input: tasks = [2,3,3]
// Output: -1
// Explanation: There is only 1 task of difficulty level 2, but in each round,
// you can only complete either 2 or 3 tasks of the same difficulty level. Hence,
// you cannot complete all the tasks, and the answer is -1.
//
//
//
// Constraints:
//
//
// 1 <= tasks.length <= 10⁵
// 1 <= tasks[i] <= 10⁹
//
// 👍 197 👎 3
/*
 O(m) Runtime: 53 ms, faster than 17.73% of Java online submissions for Minimum Rounds to Complete All Tasks.
 O(m) Memory Usage: 101.3 MB, less than 5.01% of Java online submissions for Minimum Rounds to Complete All Tasks.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks_2244 {
  public int minimumRounds(int[] tasks) {
    Map<Integer, Integer> counter = new HashMap<>();

    for (int task : tasks) {
      counter.merge(task, 1, Integer::sum);
    }

    int result = 0;

    for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
      if (entry.getValue() == 1) {
        return -1;
      }

      result += entry.getValue() / 3;

      int rest = entry.getValue() % 3;
      if (rest != 0) {
        result++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
