package com.leetcode.dp.hard;

// Given n orders, each order consist in pickup and delivery services.
//
// Count all valid pickup/delivery possible sequences such that delivery(i) is
// always after of pickup(i).
//
// Since the answer may be too large, return it modulo 10^9 + 7.
//
//
// Example 1:
//
//
// Input: n = 1
// Output: 1
// Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
//
//
// Example 2:
//
//
// Input: n = 2
// Output: 6
// Explanation: All possible orders:
// (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and
// (P2,D2,P1,D1).
// This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2
// .
//
//
// Example 3:
//
//
// Input: n = 3
// Output: 90
//
//
//
// Constraints:
//
//
// 1 <= n <= 500
//
// Related Topics Math Dynamic Programming Combinatorics 👍 1345 👎 128

import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class CountAllValidPickupAndDeliveryOptions_1359 {

  private static final long MOD = 1_000_000_007;

  public int countOrders(int n) {
    long[][] dp = new long[n + 1][n + 1];

    for (long[] row : dp) {
      Arrays.fill(row, -1);
    }

    return (int) count(n, n, dp);
  }

   private long count(int pickups, int deliveries, long[][] memo) {

    if (deliveries < 0 || pickups < 0) {
      return 0;
    }

    if (deliveries + pickups == 1) {
      return 1;
    }

    if (memo[pickups][deliveries] != -1) {
      return memo[pickups][deliveries];
    }

    int deliveryDiff = deliveries - pickups;

    long curr =
        (deliveryDiff * count(pickups, deliveries - 1, memo)) % MOD
            + (pickups * count(pickups - 1, deliveries, memo)) % MOD;

    return memo[pickups][deliveries] = curr;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
