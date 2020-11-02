package com.leetcode.dp.medium;

// n passengers board an airplane with exactly n seats. The first passenger has l
// ost the ticket and picks a seat randomly. But after that, the rest of passengers
// will:
//
//
// Take their own seat if it is still available,
// Pick other seats randomly when they find their seat occupied
//
//
// What is the probability that the n-th person can get his own seat?
//
//
// Example 1:
//
//
// Input: n = 1
// Output: 1.00000
// Explanation: The first person can only get the first seat.
//
// Example 2:
//
//
// Input: n = 2
// Output: 0.50000
// Explanation: The second person has a probability of 0.5 to get the second seat
// (when first person gets the first seat).
//
//
//
// Constraints:
//
//
// 1 <= n <= 10^5
// Related Topics Math Dynamic Programming Brainteaser
// 👍 203 👎 366

// leetcode submit region begin(Prohibit modification and deletion)

public class AirplaneSeatAssignmentProbability_1227 {
  /*
  O(n) Runtime: 26 ms, faster than 7.92% of Java online submissions for Airplane Seat Assignment Probability.
  O(n) Memory Usage: 38.7 MB, less than 5.57% of Java online submissions for Airplane Seat Assignment Probability.
  */
  static class Dp {

    public double nthPersonGetsNthSeat(int n) {
      if (n == 1) {
        return 1.0;
      }
      double[] dp = new double[n + 1];
      dp[0] = 1.0 / n;
      for (int i = 1; i <= n; i++) {
        dp[i] = 1.0 / (i + 1) + ((i + 1 - 2.0) / (i + 1)) * dp[i - 1];
      }
      return dp[n];
    }
  }
  /*
  O(1) Runtime: 0 ms, faster than 100.00% of Java online submissions for Airplane Seat Assignment Probability.
  O(1) Memory Usage: 36.2 MB, less than 5.57% of Java online submissions for Airplane Seat Assignment Probability.
  */
  static class TrickySolution {
    public double nthPersonGetsNthSeat(int n) {
      if (n == 1) {
        return 1.0;
      }
      return 0.5;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
