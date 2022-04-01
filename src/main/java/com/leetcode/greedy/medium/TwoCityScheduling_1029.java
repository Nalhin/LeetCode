package com.leetcode.greedy.medium;

// A company is planning to interview 2n people. Given the array costs where
// costs[i] = [aCosti, bCosti], the cost of flying the iᵗʰ person to city a is aCosti,
// and the cost of flying the iᵗʰ person to city b is bCosti.
//
// Return the minimum cost to fly every person to a city such that exactly n
// people arrive in each city.
//
//
// Example 1:
//
//
// Input: costs = [[10,20],[30,200],[400,50],[30,20]]
// Output: 110
// Explanation:
// The first person goes to city A for a cost of 10.
// The second person goes to city A for a cost of 30.
// The third person goes to city B for a cost of 50.
// The fourth person goes to city B for a cost of 20.
//
// The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people
// interviewing in each city.
//
//
// Example 2:
//
//
// Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
// Output: 1859
//
//
// Example 3:
//
//
// Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[65
// 0,359],[631,42]]
// Output: 3086
//
//
//
// Constraints:
//
//
// 2 * n == costs.length
// 2 <= costs.length <= 100
// costs.length is even.
// 1 <= aCosti, bCosti <= 1000
//
// Related Topics Array Greedy Sorting 👍 3512 👎 269

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class TwoCityScheduling_1029 {
  public int twoCitySchedCost(int[][] costs) {

    int firstLen = 0;
    int secondLen = 0;

    int total = 0;

    Arrays.sort(costs, (a, b) -> -Integer.compare(Math.abs(a[0] - a[1]), Math.abs(b[0] - b[1])));

    for (int[] cost : costs) {
      if (firstLen >= costs.length / 2) {
        total += cost[1];
        continue;
      }

      if (secondLen >= costs.length / 2) {
        total += cost[0];
        continue;
      }

      if (cost[0] > cost[1]) {
        secondLen++;
        total += cost[1];

      } else if (cost[0] < cost[1]) {
        firstLen++;
        total += cost[0];
      } else {
        if (firstLen > secondLen) {
          firstLen++;
          total += cost[1];
        } else {
          secondLen++;
          total += cost[0];
        }
      }
    }

    return total;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
