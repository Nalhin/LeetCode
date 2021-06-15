package com.leetcode.dp.medium;

// You are given an array colors, in which there are three colors: 1, 2 and 3.
//
// You are also given some queries. Each query consists of two integers i and c,
// return the shortest distance between the given index i and the target color c.
// If there is no solution return -1.
//
//
// Example 1:
//
//
// Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
// Output: [3,0,3]
// Explanation:
// The nearest 3 from index 1 is at index 4 (3 steps away).
// The nearest 2 from index 2 is at index 2 itself (0 steps away).
// The nearest 1 from index 6 is at index 3 (3 steps away).
//
//
// Example 2:
//
//
// Input: colors = [1,2], queries = [[0,3]]
// Output: [-1]
// Explanation: There is no 3 in the array.
//
//
//
// Constraints:
//
//
// 1 <= colors.length <= 5*10^4
// 1 <= colors[i] <= 3
// 1 <= queries.length <= 5*10^4
// queries[i].length == 2
// 0 <= queries[i][0] < colors.length
// 1 <= queries[i][1] <= 3
//
// Related Topics Binary Search
// 👍 172 👎 5
/*
 O(n * c + q) Runtime: 12 ms, faster than 97.41% of Java online submissions for Shortest Distance to Target Color.
 O(n * c) Memory Usage: 70.8 MB, less than 35.18% of Java online submissions for Shortest Distance to Target Color.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToTargetColor_1182 {
  public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
    int[][] distances = new int[3][colors.length];

    for (int color = 1; color <= 3; color++) {
      int[] leftMin = new int[colors.length];
      int[] rightMin = new int[colors.length];

      int prevFound = -1;

      for (int i = 0; i < colors.length; i++) {
        if (colors[i] == color) {
          for (int j = i; j > prevFound; j--) {
            leftMin[j] = i - j;
          }
          prevFound = i;
        }
      }

      boolean colorNotFound = prevFound == -1;
      if (colorNotFound) {
        Arrays.fill(distances[color - 1], -1);
        continue;
      }

      for (int i = prevFound + 1; i < colors.length; i++) {
        leftMin[i] = i - prevFound;
      }

      prevFound = colors.length;

      for (int i = colors.length - 1; i >= 0; i--) {
        if (colors[i] == color) {
          for (int j = i; j < prevFound; j++) {
            rightMin[j] = j - i;
          }
          prevFound = i;
        }
      }

      for (int i = prevFound - 1; i >= 0; i--) {
        rightMin[i] = prevFound - i;
      }

      for (int i = 0; i < colors.length; i++) {
        distances[color - 1][i] = Math.min(rightMin[i], leftMin[i]);
      }
    }

    List<Integer> result = new ArrayList<>();

    for (int[] query : queries) {
      int position = query[0];
      int color = query[1];
      result.add(distances[color - 1][position]);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
