package com.leetcode.greedy.medium;

// There is a special kind of apple tree that grows apples every day for n days.
// On the ith day, the tree grows apples[i] apples that will rot after days[i] days
// , that is on day i + days[i] the apples will be rotten and cannot be eaten. On s
// ome days, the apple tree does not grow any apples, which are denoted by apples[i
// ] == 0 and days[i] == 0.
//
// You decided to eat at most one apple a day (to keep the doctors away). Note t
// hat you can keep eating after the first n days.
//
// Given two integer arrays days and apples of length n, return the maximum numb
// er of apples you can eat.
//
//
// Example 1:
//
//
// Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
// Output: 7
// Explanation: You can eat 7 apples:
// - On the first day, you eat an apple that grew on the first day.
// - On the second day, you eat an apple that grew on the second day.
// - On the third day, you eat an apple that grew on the second day. After this d
// ay, the apples that grew on the third day rot.
// - On the fourth to the seventh days, you eat apples that grew on the fourth da
// y.
//
//
// Example 2:
//
//
// Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
// Output: 5
// Explanation: You can eat 5 apples:
// - On the first to the third day you eat apples that grew on the first day.
// - Do nothing on the fouth and fifth days.
// - On the sixth and seventh days you eat apples that grew on the sixth day.
//
//
//
// Constraints:
//
//
// apples.length == n
// days.length == n
// 1 <= n <= 2 * 104
// 0 <= apples[i], days[i] <= 2 * 104
// days[i] = 0 if and only if apples[i] = 0.
//
// Related Topics Heap Greedy
// 👍 223 👎 113

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 O(nlog(k) + m) Runtime: 48 ms, faster than 65.43% of Java online submissions for Maximum Number of Eaten Apples.
 O(k) Memory Usage: 42.8 MB, less than 36.98% of Java online submissions for Maximum Number of Eaten Apples.
*/
public class MaximumNumberOfEaterApples_1705 {
  public int eatenApples(int[] apples, int[] days) {
    int result = 0;
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    for (int day = 0; day < apples.length || !pq.isEmpty(); day++) {
      if (day < apples.length) {
        pq.add(new int[] {apples[day], day + days[day]});
      }

      while (!pq.isEmpty() && (pq.peek()[1] <= day || pq.peek()[0] <= 0)) {
        pq.poll();
      }

      if (!pq.isEmpty()) {
        result++;
        pq.peek()[0]--;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
