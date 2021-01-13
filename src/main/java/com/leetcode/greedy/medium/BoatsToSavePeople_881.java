package com.leetcode.greedy.medium;

// The i-th person has weight people[i], and each boat can carry a maximum weight
// of limit.
//
// Each boat carries at most 2 people at the same time, provided the sum of the
// weight of those people is at most limit.
//
// Return the minimum number of boats to carry every given person. (It is guaran
// teed each person can be carried by a boat.)
//
//
//
//
// Example 1:
//
//
// Input: people = [1,2], limit = 3
// Output: 1
// Explanation: 1 boat (1, 2)
//
//
//
// Example 2:
//
//
// Input: people = [3,2,2,1], limit = 3
// Output: 3
// Explanation: 3 boats (1, 2), (2) and (3)
//
//
//
// Example 3:
//
//
// Input: people = [3,5,3,4], limit = 5
// Output: 4
// Explanation: 4 boats (3), (3), (4), (5)
//
// Note:
//
//
// 1 <= people.length <= 50000
// 1 <= people[i] <= limit <= 30000
//
//
//
//
// Related Topics Two Pointers Greedy
// 👍 874 👎 42

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(nlog(n)) Runtime: 14 ms, faster than 90.84% of Java online submissions for Boats to Save People.
 O(sort) Memory Usage: 48 MB, less than 47.05% of Java online submissions for Boats to Save People.
*/
import java.util.Arrays;

public class BoatsToSavePeople_881 {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int result = 0;
    int left = 0;
    int right = people.length - 1;

    while (left <= right) {
      if (people[right] + people[left] <= limit) {
        left++;
      }
      right--;
      result++;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
