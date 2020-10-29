package com.leetcode.arrays.medium;

// You are given an array representing a row of seats where seats[i] = 1 represen
// ts a person sitting in the ith seat, and seats[i] = 0 represents that the ith se
// at is empty (0-indexed).
//
// There is at least one empty seat, and at least one person sitting.
//
// Alex wants to sit in the seat such that the distance between him and the clos
// est person to him is maximized.
//
// Return that maximum distance to the closest person.
//
//
// Example 1:
//
//
// Input: seats = [1,0,0,0,1,0,1]
// Output: 2
// Explanation:
// If Alex sits in the second open seat (i.e. seats[2]), then the closest person
// has distance 2.
// If Alex sits in any other open seat, the closest person has distance 1.
// Thus, the maximum distance to the closest person is 2.
//
//
// Example 2:
//
//
// Input: seats = [1,0,0,0]
// Output: 3
// Explanation:
// If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats a
// way.
// This is the maximum distance possible, so the answer is 3.
//
//
// Example 3:
//
//
// Input: seats = [0,1]
// Output: 1
//
//
//
// Constraints:
//
//
// 2 <= seats.length <= 2 * 104
// seats[i] is 0 or 1.
// At least one seat is empty.
// At least one seat is occupied.
//
// Related Topics Array
// 👍 1000 👎 122

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n) Runtime: 2 ms, faster than 75.88% of Java online submissions for Maximize Distance to Closest Person.
  O(n) Memory Usage: 40.1 MB, less than 10.99% of Java online submissions for Maximize Distance to Closest Person.
*/
public class MaximizeDistanceToClosestPerson_849 {
  static class Dp {
    public int maxDistToClosest(int[] seats) {
      int[] leftDp = new int[seats.length];
      int[] rightDp = new int[seats.length];

      for (int i = 0; i < leftDp.length; i++) {
        if (seats[i] == 0) {
          leftDp[i] = i > 0 ? leftDp[i - 1] + 1 : Integer.MAX_VALUE;
        } else {
          leftDp[i] = 0;
        }
      }

      for (int i = rightDp.length - 1; i >= 0; i--) {
        if (seats[i] == 0) {
          rightDp[i] = i < rightDp.length - 1 ? rightDp[i + 1] + 1 : Integer.MAX_VALUE;
        } else {
          rightDp[i] = 0;
        }
      }

      int max = 0;

      for (int i = 0; i < seats.length; i++) {
        max = Math.max(Math.min(leftDp[i], rightDp[i]), max);
      }
      return max;
    }
  }
  /*
    O(n) Runtime: 2 ms, faster than 75.88% of Java online submissions for Maximize Distance to Closest Person.
    O(1) Memory Usage: 41.2 MB, less than 10.99% of Java online submissions for Maximize Distance to Closest Person.
  */
  static class TwoPointer {
    public int maxDistToClosest(int[] seats) {
      int slow = -1;
      int fast = 0;
      int max = 0;
      for (int i = 0; i < seats.length; i++) {
        if (seats[i] == 1) {
          slow = i;
        } else {
          while (fast < seats.length && seats[fast] == 0 || fast < i) {
            fast++;
          }
          int fastDist = fast == seats.length ? Integer.MAX_VALUE : fast - i;
          int slowDist = slow == -1 ? Integer.MAX_VALUE : i - slow;
          max = Math.max(Math.min(slowDist, fastDist), max);
        }
      }

      return max;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
